FROM openjdk:21 AS build

WORKDIR /app

COPY build/libs/student-1.0.0.jar student-1.0.0.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "student-1.0.0.jar"]