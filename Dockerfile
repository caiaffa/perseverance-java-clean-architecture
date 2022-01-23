FROM maven:3.6.0-jdk-11-slim AS builder

COPY . /build

RUN cd /build && mvn package

RUN mkdir /var/jar && mv /build/target/perseverance-*.jar /var/jar/perseverance.jar

COPY pom.xml /var/jar/

FROM openjdk:11-jre-slim

RUN  apt-get update \
  && apt-get install -y wget

RUN mkdir /var/jar
COPY --from=builder /var/jar/* /var/jar/
WORKDIR /var/jar/

ENTRYPOINT ["java", "-jar","perseverance.jar"]