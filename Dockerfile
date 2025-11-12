FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/calculator.jar

WORKDIR /opt/app

COPY ${JAR_FILE} calculator.jar

COPY entrypoint.sh entrypoint.sh

COPY src/main/resources/application-dev.yml config/
COPY src/main/resources/application-uat.yml config/
COPY src/main/resources/application-prod.yml config/

RUN chmod 755 entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]