# Kafka learning services

Two independent Java 21 / Spring Boot 3.5 projects. The Kafka dependency is present, but neither service uses Kafka yet. No broker is needed to start them.

In IntelliJ IDEA, import the root `pom.xml` as a Maven project so each service's `src/main/java` directory is recognized as a source root.

## Build

With Java 21 and Maven installed, run from the workspace root:

```sh
cd order-service
mvn package
cd ../notification-service
mvn package
```

## Run

In separate terminals:

```sh
cd order-service
mvn spring-boot:run
```

```sh
cd notification-service
mvn spring-boot:run
```

The order service listens on port 8081. The notification service listens on port 8082 and has no message processing yet.

Example request:

```sh
curl -i -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d '{"orderId":1,"product":"Book","quantity":2}'
```

Valid requests receive HTTP 202 with `Order request received`. Invalid fields receive HTTP 400.
