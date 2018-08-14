#!/bin/bash

/home/logstash/logstash-6.3.1/bin/logstash -f /app/logstash.conf &

java -jar /app/target/test-service-1.0-SNAPSHOT.jar
