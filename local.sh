#!/bin/bash

docker build --tag test-service .

docker run --name test-service --rm -d -p 9995:9995 --net=es-kibana-bridge test-service