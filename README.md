### About
This is a simple Spring Boot project, with RabbitMQ.

___
### Dependencies

Before running the project, make sure you have the following dependencies installed:
- JDK 11;
- Maven;
- Docker Compose;

___
### Building and running  

#### Build
First, build the application:
```bash
$ mvn clean package
```

#### Building the infrastructure
In order to run it locally, you first need to build the infrastructure. So run the following:

```bash
$ ./docker-build-infra.sh
```

#### Rodando um job
Now, with the infrastructure up and running, you can build the application container:

```bash
$ ./docker-run-application.sh 
```