FROM maven:3.8.3-jdk-11-slim AS build

RUN mkdir /MockProjectFPT

COPY . /MockProjectFPT

WORKDIR /MockProjectFPT

RUN mvn clean package

FROM adoptopenjdk/openjdk11:jre-11.0.15_10-alpine

RUN mkdir /app

COPY --from=build /MockProjectFPT/target/MockProject-0.0.1-SNAPSHOT.jar /app/fptmockproject.jar

WORKDIR /app

CMD java $JAVA_OPTS -jar fptmockproject.jar

EXPOSE 8081