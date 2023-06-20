#!/bin/bash

echo "### Building: Base Image ### "
docker build --build-arg VERSION=3.12 --tag alpine-build:3.12 --file dockerfile-alpine .
echo "### Building: OpenSSL ###"
docker build --tag openssl-dtls-server --file dockerfile-openssl .
echo "### Building: Mbed TLS ###"
docker build --tag mbedtls-dtls-server --file dockerfile-mbedtls .
