FROM java
WORKDIR /app
COPY /target/demo-mysql-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-mysql-0.0.1-SNAPSHOT.jar"]
