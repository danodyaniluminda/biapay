FROM harbor.biapay.net/maven/3-adoptopenjdk-11:01 as builder
WORKDIR /application
COPY . /application
RUN mvn package -DskipTests
RUN mvn deploy:deploy-file
