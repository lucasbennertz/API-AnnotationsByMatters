FROM openjdk:21
LABEL authors="lucas"
WORKDIR /app
COPY ./target/MateriaProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
