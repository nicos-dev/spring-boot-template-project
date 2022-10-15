# Spring Boot Template Project
*Clone repository, execute script & start writing code without the same boilerplate over and over again.*

<br/>

## About
**Versions:** `Gradle 7.5` `Java 17` `Keycloak 19.0.2`

**Features:** <br/>
:heavy_check_mark: Keycloak Authentication <br/>
:heavy_check_mark: Swagger + Authentication via Keycloak <br/>
:heavy_check_mark: Caching using Redis + clear cache endpoint <br/>
:heavy_check_mark: Startup Logger + Logger bean injection <br/>
:heavy_check_mark: Object Mapping <br/>
:heavy_check_mark: Index Page <br/>
:heavy_check_mark: API Versioning <br/>
:heavy_check_mark: Dummy implementation (controller, service, entity, repository & dto) <br/>
:heavy_check_mark: API Json response formatting <br/>
:heavy_check_mark: Maria DB + Liquibase <br/>
:heavy_check_mark: Dockerfile + GitHub Action <br/>

<br/>

## Prerequisites
- Docker Desktop & Logged into Docker
- Some IDE
- Tool to execute bash script (on Windows may use GitBash)

<br/>

## Start

````shell
# Run the script
./setup-project.sh -d "<domain>" -g "<group>" -a "<app-name>"
````

*After script finished....*

 1. Navigate to [Keycloak Admin Console](http://host.docker.internal:3000/admin/) (pw: admin; un: admin)
 2. Create realm ``<group>`` (see image 1)
 3. Create client ``swagger`` in created realm (see image 2)
 4. Create client ``<group>_<app-name>`` in created realm (see image 3)
 5. Create user in created realm (see image 4 + 5)
 6. Run application & open [index page](http://localhost:8080/)
 7. Follow link to Swagger, then hit authenticate and use ``implicit`` & finally login with the user you created
 8. Finally fetch objects via ``GET api/v1/dummy-objects`` in Swagger :tada:

<br/>

Image 1: <br/>
![](./docs/img/key-setup_create-realm.png)

Image 2: <br/>
![](./docs/img/keycloak-setup_create-swagger-client.png)

Image 3: <br/>
![](./docs/img/keycloak-setup_create-service-client.png)

Image 4: <br/>
![](./docs/img/keycloak-setup_create-user-1.png)

Image 5: <br/>
![](./docs/img/keycloak-setup_create-user-2.png)
