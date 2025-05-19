# Stage 1: Build do projeto com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom.xml e o código-fonte
COPY pom.xml .
COPY src ./src

# Faz o build do projeto (gera o JAR)
RUN mvn clean package -DskipTests

# Stage 2: Imagem final com JRE e o JAR já compilado
FROM openjdk:21-jdk
WORKDIR /app

# Copia o JAR gerado do build stage
COPY --from=build /app/target/MateriaProject-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
