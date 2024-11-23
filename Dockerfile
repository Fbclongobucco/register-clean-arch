# Etapa 1: Usar uma imagem base do JDK 21
# Etapa 1: Construir a imagem base com o JDK 21
FROM eclipse-temurin:21-jdk-alpine as build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado para a imagem Docker
COPY /infraestructure/target/infraestructure-1.0-SNAPSHOT.jar infraestructure-1.0-SNAPSHOT.jar

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:21-jre-alpine

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado da etapa anterior
COPY --from=build /app/infraestructure-1.0-SNAPSHOT.jar /app/

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "infraestructure-1.0-SNAPSHOT.jar"]

