# Imagem base para o build
FROM eclipse-temurin:21-jdk-alpine AS build

# Diretório de trabalho
WORKDIR /workspace/app

# Copiar os arquivos de configuração do Gradle
COPY gradlew .
COPY gradle gradle

# Conceder permissão de execução ao wrapper do Gradle
RUN chmod +x ./gradlew

# Copiar o arquivo com as dependências
COPY build.gradle .
COPY settings.gradle .

# Baixar as dependências sem executar o build
RUN ./gradlew dependencies --no-daemon

# Copiar os arquivos-fonte
COPY src src

# Realizar o build da aplicação sem executar os testes
RUN ./gradlew build -x test --no-daemon

# Imagem para implantação em produção
FROM eclipse-temurin:21-jre-alpine AS final

# Diretório de trabalho
WORKDIR /workspace/app

# Copiar o JAR gerado para o container
COPY --from=build /workspace/app/build/libs/*.jar /workspace/app/app.jar

# Expor a porta utilizada na aplicação
EXPOSE 8100

# Executar o JAR
ENTRYPOINT ["java", "-jar", "/workspace/app/app.jar"]
