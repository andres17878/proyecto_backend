FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
# dockerbuild -t springbootapp:1.0 .
# docker image list
# docker run -p 8080:8080 --name springapp -d -t springbootapp:1.0


# Ejecución desde otra maquina haciendo pull del repositorio de dockerhub andres178/springbootapp:1.0
    # docker run -p 8080:8080 --name springapp -d -t andres178/springbootapp:1.0




