#!/bin/bash

KEYCLOAK_HOST="host.docker.internal"
KEYCLOAK_PORT=3000

while getopts ":d:g:a:" opt; do
  case $opt in
    d) DOMAIN_NAME="$OPTARG"
    ;;
    g) GROUP_NAME="$OPTARG"
    ;;
    a) APP_NAME="$OPTARG"
    ;;
    \?) echo "Invalid option -$OPTARG" >&2
    exit 1
    ;;
  esac
  case $OPTARG in
    -*) echo "Option $opt needs a valid argument"
    exit 1
    ;;
  esac
done

# REPLACE DIRECTORIES
mv ./src/main/kotlin/REPLACE_DOMAIN "./src/main/kotlin/$DOMAIN_NAME"
mv "./src/main/kotlin/$DOMAIN_NAME/REPLACE_GROUP" "./src/main/kotlin/$DOMAIN_NAME/$GROUP_NAME"
mv "./src/main/kotlin/$DOMAIN_NAME/$GROUP_NAME/REPLACE_APP_NAME" "./src/main/kotlin/$DOMAIN_NAME/$GROUP_NAME/$APP_NAME"
mv "./src/main/kotlin/$DOMAIN_NAME/$GROUP_NAME/$APP_NAME/REPLACE_APP_NAMEApplication.kt" "./src/main/kotlin/$DOMAIN_NAME/$GROUP_NAME/$APP_NAME/${APP_NAME}Application.kt"

# REPLACE VARS IN ALL FILES
grep -rl REPLACE_DOMAIN . --exclude-dir=.git | xargs sed -i "s/REPLACE_DOMAIN/$DOMAIN_NAME/g"
grep -rl REPLACE_GROUP . --exclude-dir=.git | xargs sed -i "s/REPLACE_GROUP/$GROUP_NAME/g"
grep -rl REPLACE_APP_NAME . --exclude-dir=.git | xargs sed -i "s/REPLACE_APP_NAME/$APP_NAME/g"
grep -rl REPLACE_KEYCLOAK_HOST . --exclude-dir=.git | xargs sed -i "s/REPLACE_KEYCLOAK_HOST/$KEYCLOAK_HOST/g"
grep -rl REPLACE_KEYCLOAK_PORT . --exclude-dir=.git | xargs sed -i "s/REPLACE_KEYCLOAK_PORT/$KEYCLOAK_PORT/g"

# RUN DOCKER CONTAINERS
docker run -d --name "$GROUP_NAME-mariadb" --env MARIADB_USER="$GROUP_NAME" --env MARIADB_PASSWORD="$GROUP_NAME" --env MARIADB_ROOT_PASSWORD="$GROUP_NAME" -p "3306:3306" --env MARIADB_DATABASE="$GROUP_NAME"  mariadb:latest
docker run -d --name "$GROUP_NAME-redis" redis:latest
docker run -d -p $KEYCLOAK_PORT:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:19.0.2 start-dev
