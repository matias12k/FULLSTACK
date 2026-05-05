FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el JAR generado
COPY target/*.jar app.jar

# Copiamos la Wallet a la ruta interna que definimos en el properties
COPY Wallet_UGNFM3WC8EM1NFQI /app/wallet

EXPOSE 8082

# Ejecutamos indicando la ruta de la Wallet a la JVM
ENTRYPOINT ["java", "-Doracle.net.tns_admin=/app/wallet", "-jar", "app.jar"]