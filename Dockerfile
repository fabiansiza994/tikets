FROM openjdk:17-alpine
MAINTAINER fmsp.com
ARG TIMEZONE="America/Bogota"
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tikets-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tikets-0.0.1-SNAPSHOT.jar"]
