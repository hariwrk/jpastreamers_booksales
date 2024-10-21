FROM openjdk:17-oracle
COPY ./target/bookservice-0.0.1-SNAPSHOT.jar book-service.jar
CMD ["java","-jar","book-service.jar"]