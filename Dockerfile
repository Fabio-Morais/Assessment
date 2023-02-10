FROM openjdk:11

RUN mkdir /app

COPY out/artifacts/Assessment_jar/Assessment.jar /app

WORKDIR /app

CMD  ["java","-jar","Assessment.jar"]

