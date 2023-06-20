### Building the server implementations

---

In order to build the DTLS servers, you need to have Docker installed. By executing the included bash script, you can build all docker images:
```bash
bash setup.sh
```

To launch a server, you can use the following commands:

- OpenSSL
```bash
docker run --rm -v [Absolute path to /certs]:/certs/ -p 4433:4433/udp --name openssl-dtls-server openssl-dtls-server -key /certs/private_key.pem -cert /certs/certificate.pem -accept 4433 -dtls
```

- Mbed TLS
```bash
docker run --rm -p 4433:4433/udp --name mbedtls-dtls-server mbedtls-dtls-server server_port=4433 dtls=1
```

We are currently working on additional Docker files for the following server implementations, which we will soon make available: 
Botan, GnuTLS, JSSE, LibreSSL, MatrixSSL, OpenSSL, PionDTLS, Scandium, TinyDTLS (Contiki-NG), TinyDTLS (Eclipse), and wolfSSL.
