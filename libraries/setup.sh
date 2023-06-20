#!/bin/bash

echo "### Building: Base Images ### "
docker build --build-arg VERSION=3.6 --tag alpine-build:3.6 --file dockerfile-alpine .
docker build --build-arg VERSION=3.12 --tag alpine-build:3.12 --file dockerfile-alpine .

# Using alpine-build:3.6
#echo "### Building: LibreSSL ###"
#docker build --tag libressl-dtls-server --file dockerfile-libressl .
#echo "### Building: wolfSSL ###"
#docker build --tag wolfssl-dtls-server --file dockerfile-wolfssl .
#echo "### Building: GnuTLS ###"
#docker build --tag gnutls-dtls-server --file dockerfile-gnutls .

# Using alpine-build:3.12
#echo "### Building: OpenSSL ###"
#docker build --tag openssl-dtls-server --file dockerfile-openssl .
#echo "### Building: MatrixSSL ###"
#docker build --tag matrixssl-dtls-server --file dockerfile-matrixssl .
#echo "### Building: Botan ###"
#docker build --tag botan-dtls-server --file dockerfile-botan .
echo "### Building: Mbed TLS ###"
docker build --tag mbedtls-dtls-server --file dockerfile-mbedtls .

# Using alpine-build:3.12
#echo "### Building: TinyDTLS (Contiki-NG) ###"
#docker build --tag tinydtls-c-dtls-server --file dockerfile-tinydtls-c .
echo "### Building: TinyDTLS (Eclipse) ###"
docker build --tag tinydtls-e-dtls-server --file dockerfile-tinydtls-e .
#echo "### Building: PionDTLS ###"
#docker build --tag piondtls-dtls-server --file dockerfile-piondtls .

# TODO
#echo "### Building: JSSE ###"
#docker build --tag jsse-dtls-server --file dockerfile-jsse .
#echo "### Building: Scandium ###"
#docker build --tag scandium-dtls-server --file dockerfile-scandium .
