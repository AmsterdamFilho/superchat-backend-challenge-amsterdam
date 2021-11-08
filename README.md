# Superchat backend technical challenge

This is a solution for the Superchat backend technical challenge described [here](https://www.notion.so/Backend-Technical-Challenge-c78b96ca4291429aba79aefe1721c7e8).

## Key design decisions

### Stack: Quarkus, Postgres, Hibernate, Docker

Chosen as this is the stack used by the company.

### Reactive with Mutiny

To take full advantage of the Quarkus framework, reactive has been chosen as the programming model.

This will result in a highly efficient application, which is essential, especially in the Cloud and in containerized environments.

### Hexagonal architecture

To help mitigate the risks of using a cutting-edge framework, hexagonal architecture has been chosen as the way to organize the code.

This also comes with the additional benefit of making the domain very explicit.

### DDD

DDD concepts have been applied to help deal with the complexity inherent of dealing with multiple integrations that should fit in the same model.

An anemic domain model has been avoided in favor of a rich one.

A diagram can be found in the docs folder.

## Running the application

All shell commands assume the current directory is the project root.

### Using the command line

System requirements: jvm 11 in JAVA_HOME and docker.

First start the postgres database with the command:

`docker compose -f docker-compose-db-only.yml up -d`

Then run the application with:

`./mvnw quarkus:dev` for Unix OS or `mvnw.cmd quarkus:dev` for Windows

### Using docker

System requirements: just docker.

Simply execute:

`docker compose -f docker-compose-full-app.yml up -d`

This may take a while, since it will build the image.

### Using the application

Just type `http://localhost:8080/q/swagger-ui/` in the browser to access the swagger ui and test the endpoints.

Placeholders for contact name and bitcoin price are {{contactName}} and {{bitcoinPrice}}

## Disclaimer

The chosen architecture has many layers of abstraction that, given the simplicity of the requirements, make the solution look over-engineered.
In a real application, though, requiring observability, auditing and real third party clients, all layers would have a fundamental importance in keeping the complexity under control.