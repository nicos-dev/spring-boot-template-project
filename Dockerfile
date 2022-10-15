FROM gradle:7.5-jdk17 AS builder

LABEL maintainer="FN LN @ REPLACE_GROUP"
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY src/ src/
RUN gradle --no-daemon build --stacktrace


FROM gcr.io/distroless/java17-debian11

WORKDIR /REPLACE_GROUP
COPY --from=builder /app/build/libs/*.jar ./app.jar
EXPOSE 8080
CMD [ "-Xmx256m", "-Xss32m", "-Djava.security.egd=file:/dev/./urandom","./app.jar"]
