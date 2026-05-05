# Imagen base de Java 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el archivo JAR generado por Maven
COPY target/*.jar app.jar

# Copiamos la carpeta de la Wallet al directorio interno /app/wallet
COPY Wallet_UGNFM3WC8EM1NFQI /app/wallet

# Exponemos el puerto 8080 (estándar para Hoteles)
EXPOSE 8080

# Comando de inicio inyectando la propiedad tns_admin para la Wallet
ENTRYPOINT ["java", "-Doracle.net.tns_admin=/app/wallet", "-jar", "app.jar"]