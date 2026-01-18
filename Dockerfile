# 1. Usamos una imagen de Maven con Java 17 para compilar
FROM maven:3.8-eclipse-temurin-17 AS build
WORKDIR /app

# 2. Copiamos el pom.xml y descargamos librerías
COPY pom.xml .
RUN mvn dependency:go-offline

# 3. Copiamos el código y compilamos el .jar
COPY src ./src
RUN mvn package -DskipTests

# 4. Cambiamos a una imagen de ejecución más moderna y ligera
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# 5. Copiamos el archivo generado (el asterisco ayuda si el nombre varía)
COPY --from=build /app/target/*.jar app.jar

# 6. Puerto y ejecución
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]