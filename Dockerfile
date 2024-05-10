FROM openjdk:17-jdk-alpine

EXPOSE 8080

ADD build/libs/shopping-list-0.0.1-SNAPSHOT.jar shopping-list.jar

ENTRYPOINT ["java", "-jar", "shopping-list.jar"]