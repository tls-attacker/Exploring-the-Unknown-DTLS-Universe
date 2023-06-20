### Building the server implementations

---

In order to build the DTLS servers, you need to have Docker installed. By executing the included bash script, you can build all docker images:
```bash
bash setup.sh
```

To launch a server, you can use the following commands:

- Mbed TLS
```bash
docker run --rm -p 4433:4433/udp --name mbedtls-dtls-server mbedtls-dtls-server server_port=4433 dtls=1
```

- TinyDTLS (Eclipse)
```bash
docker run --rm -p 4433:4433/udp --name tinydtls-e-dtls-server tinydtls-e-dtls-server -p 4433
```

We are currently working on additional Docker files for the following server implementations, which we will soon make available: 
Botan, GnuTLS, JSSE, LibreSSL, MatrixSSL, OpenSSL, PionDTLS, Scandium, TinyDTLS (Contiki-NG), and wolfSSL.
