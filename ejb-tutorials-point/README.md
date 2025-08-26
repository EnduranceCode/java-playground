# Enterprise Java Beans by Tutorials Point

The folder [`ejb-tutorials-point`](../ejb-tutorials-point) contains the code written while following
the [EJB Tutorial](https://www.tutorialspoint.com/ejb/index.htm)
available at [Tutorials Point](https://www.tutorialspoint.com/).

## Tutorial environment setup

To set up the [EJB Tutorial](https://www.tutorialspoint.com/ejb/index.htm) development environment, it's necessary to
deploy a Java EE application server and a PostgresSQL database server. The folder [`dev-environment`](dev-environment)
contains the Docker environment setup required to run both the application server and the PostgreSQL database server
needed for development environment.

To start the environment, run the below command in the `dev-environment` folder, which will start
a WildFly application server and a PostgreSQL database server:

```bash
./docker-up.sh
```

To stop the environment, run the below command in the `dev-environment` folder:

```bash
./docker-down.sh --stop
```

To perform a full environment cleanup by stopping and removing containers, networks, and dangling volumes,
run the following command in the `dev-environment` folder:

```bash
./docker-down.sh --delete
```
