FROM openjdk:8-jre-alpine
COPY ./inventory/target/scala-2.12/inventory-assembly-0.1.0-SNAPSHOT.jar /
CMD java -jar ./inventory-assembly-0.1.0-SNAPSHOT.jar

