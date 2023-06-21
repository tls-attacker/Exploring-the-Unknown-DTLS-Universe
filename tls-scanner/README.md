### Building TLS-Scanner

---
In order to compile and use TLS-Scanner, you need to have Java 11 and Maven installed.  Additionally, TLS-Attacker needs to be installed as library since TLS-Scanner uses it. Once TLS-Attacker is installed, you can proceed with compiling TLS-Scanner.
```bash
cd TLS-Attacker
mvn clean install
cd ../TLS-Scanner
mvn clean package
```

In order to run TLS-Scanner, you need to run the jar file in the apps/ folder.
```bash
java -jar apps/TLS-Server-Scanner.jar -connect [ip]:[port] -dtls
```
