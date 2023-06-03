FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ARG SPRING_PROFILES_ACTIVE
COPY ${JAR_FILE} order-service-1.1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","/order-service-1.1.0-SNAPSHOT.jar"]
