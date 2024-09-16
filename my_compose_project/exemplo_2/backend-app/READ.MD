## Criar .jar
mvn clean package -DskipTests

## Executar
java -jar <nome do jar>

## Dockerfile
FROM maven:3.8.7-openjdk-18 AS build

WORKDIR /app
COPY . .
RUN mvn package -Dmaven.test.skip -Dcheckstyle.skip

FROM amazoncorretto:18.0.1
VOLUME /tmp
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]