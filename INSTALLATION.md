# Installation

## Run with Docker-Compose

In order to set up the whole system consisting of multiple components, a `docker-compose` file has been prepared. This makes it straightforward to get a sample system up and running.

The full system will comprise:

- damap-backend,
- damap-frontend,
- dummy Keycloak with login name "user" and password "user",
- dummy PostgreSQL database,
- FITS service (https://github.com/harvard-lts/FITSservlet)
- and dummy APIs providing person and project data.

To start up the cluster of components, run the following command:

```shell
cd docker
docker compose up --build --force-recreate -d
```

- `--build`: Ensures that images are rebuilt before running.
- `--force-recreate`: Forces the recreation of containers, which is useful if you want to refresh your setup and ensure all components start cleanly.

For local development, it is often enough to only run the additional services, as the local development instances for the backend and frontend are used. To only start the additional services, run the following command:

```shell
cd docker
docker compose -f docker-compose-services.yaml up -d
```

The `-d` flag runs the services in detached mode, meaning they run in the background, allowing you to keep using the terminal for other commands.

See the documented sections in the [docker/docker-compose.yaml]() to make further configurations.

### Keycloak

Keycloak can be accessed through http://localhost:8087. You can log in to Keycloak as an admin with the following credentials:

```shell
username: admin
password: admin
```

### Update Realm Config

If you update a running Keycloak instance (e.g., adding users, changing properties), you can export the current configuration to a JSON file. Save this JSON file to [keycloak export file](docker/sample-damap-realm-export.json) to integrate it with the docker-compose cluster. Be sure to rebuild Keycloak by running the following commands:

```shell
# Rebuild Keycloak
docker compose build keycloak

# Restart Keycloak
docker compose up -d keycloak
```

### PostgreSQL

You can access the PostgreSQL CLI directly within the container using:

```shell
cd docker
docker compose exec damap-db psql -U damap damap
```

## Custom Deployment

In order to adapt the project and deploy it in your own institutional environment, follow the [deployment instructions](INSTALLATION.md).

## OpenAPI Documentation

The OpenAPI documentation is automatically generated for the backend. Additionally, a Swagger-UI is available for easy access to the API documentation. This interface allows you to explore and test the available endpoints.

## MUG API

For the Medical University of Graz (MUG) environment, the relevant API information can be found in the [application.yaml](https://github.com/sharedRDM/damap-backend/blob/4fe538bddda793ebdfd7a883ba0cd3764e32ef79/src/main/resources/application.yaml#L23-L24) file.
MUG also uses an authentication token in their configuration for the API, which can be found [here](https://github.com/sharedRDM/damap-backend/blob/4fe538bddda793ebdfd7a883ba0cd3764e32ef79/src/main/resources/application.yaml#L34-L37).
