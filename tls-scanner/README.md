### Building TLS-Scanner

---
In order to compile and use TLS-Scanner, you need to have Java 11 and Maven installed. 
```bash
mvn clean package
```

In order to run TLS-Scanner, you need to run the jar file in the apps/ folder.
```bash
java -jar apps/TLS-Server-Scanner.jar -connect [ip]:[port] -dtls
```
