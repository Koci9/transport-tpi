# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar pom + código
COPY pom.xml ./
COPY src ./src

# Opcional: ajustar si tenés parent pom en la raíz
# COPY ../pom.xml ../pom.xml

# Construir el jar (skip tests para acelerar)
RUN mvn -B -DskipTests clean package

# Run stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiar jar generado desde el stage de build
COPY --from=build /app/target/*-SNAPSHOT.jar app.jar
# si tus artefactos usan versiones fijas: COPY --from=build /app/target/gateway-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
