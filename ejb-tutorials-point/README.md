# Enterprise Java Beans by Tutorials Point

The folder [`ejb-tutorials-point`](../ejb-tutorials-point) contains the code written while following
the [EJB Tutorial](https://www.tutorialspoint.com/ejb/index.htm)
available at [Tutorials Point](https://www.tutorialspoint.com/).

## Table of Contents

1. [Tutorial Content & Progress](#tutorial-content--progress)
2. [Tutorial environment setup](#tutorial-environment-setup)

## Tutorial Content & Progress

- [x] EJB - Home
- [x] EJB - Overview
- [x] EJB - Environment Setup - TAG: `EJBT-L03`
- [x] EJB - Create Application -TAG: `EJBT-L04`
- [ ] EJB - Stateless Bean
- [ ] EJB - Stateful Bean
- [ ] EJB - Persistence
- [ ] EJB - Message Driven Beans
- [ ] EJB - Annotations
- [ ] EJB - Callbacks
- [ ] EJB - Timer Service
- [ ] EJB - Dependency Injection
- [ ] EJB - Interceptors
- [ ] EJB - Embeddable Objects
- [ ] EJB - Blobs/Clobs
- [ ] EJB - Transactions
- [ ] EJB - Security
- [ ] EJB - JNDI Bindings
- [ ] EJB - Entity Relationships
- [ ] EJB - Access Database
- [ ] EJB - Query Language
- [ ] EJB - Exception Handling
- [ ] EJB - Web Services
- [ ] EJB - Packaging Applications
- [ ] EJB - Quick Guide
- [ ] EJB - Useful Resources
- [ ] EJB - Discussion

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

To stop the environment, run the below command in the [`dev-environment`](./dev-environment) folder:

```bash
./docker-down.sh --stop
```

To perform a full environment cleanup by stopping and removing containers, networks, and dangling volumes,
run the following command in the  [`dev-environment`](./dev-environment) folder:

```bash
./docker-down.sh --delete
```
## Application deployment

To deploy the EJB modules developed while following the tutorial, you can use the provided `deploy.sh` script
executing the below command in the [`ejb-app`](./ejb-app) folder:

```bash
./deploy.sh
```
