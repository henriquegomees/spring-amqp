FROM openjdk:11

RUN mkdir /app
COPY ./target/spring-amqp-1.0-SNAPSHOT.jar /app/app.jar
COPY ./scripts/execute.sh /app/
RUN chmod +x /execute.sh

ENTRYPOINT ["/bin/sh", "execute.sh"]
