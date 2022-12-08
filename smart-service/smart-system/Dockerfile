FROM openjdk:8u332-jre

ARG JAR_FILE

COPY target/${JAR_FILE} /smart-system.jar

ENTRYPOINT ["java", "-jar", "/smart-system.jar"]