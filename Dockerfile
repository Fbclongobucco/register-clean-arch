FROM eclipse-temurin:21-jdk-alpine as build


WORKDIR /app


COPY /infraestructure/target/infraestructure-1.0-SNAPSHOT.jar infraestructure-1.0-SNAPSHOT.jar


FROM eclipse-temurin:21-jre-alpine


WORKDIR /app


COPY --from=build /app/infraestructure-1.0-SNAPSHOT.jar /app/


ENTRYPOINT ["java", "-jar", "infraestructure-1.0-SNAPSHOT.jar"]

