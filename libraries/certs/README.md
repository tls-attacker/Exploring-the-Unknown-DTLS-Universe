### Keys and Certificates for the Example Servers

---

Generated with OpenSSL:
```bash
openssl genpkey -algorithm EC -out private_key.pem -pkeyopt ec_paramgen_curve:prime256v1
openssl req -new -x509 -sha256 -key private_key.pem -out certificate.pem -days 36500 -subj "/C=DE/ST=NRW/L=Bochum/O=RUB/OU=NDS/CN=NDS"
```
