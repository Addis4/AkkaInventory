FROM openjdk:8-jre-alpine
COPY ./inventory-assembly-0.1.0-SNAPSHOT.jar /
CMD java -jar ./inventory-assembly-0.1.0-SNAPSHOT.jar

