FROM openjdk:11

RUN mkdir /app
COPY ./target/spring-amqp-0.0.1-SNAPSHOT.jar /app/app.jar
COPY ./scripts/execute.sh /app/execute.sh
RUN chmod +x /app/execute.sh
WORKDIR /app
RUN ls -la

ENTRYPOINT ["./execute.sh"]
