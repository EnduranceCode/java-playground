# Enterprise Java Beans by Tutorials Point

The folder [`ejb-tutorials-point`](../ejb-tutorials-point) contains the code written while following
the [EJB Tutorial](https://www.tutorialspoint.com/ejb/index.htm)
available at [Tutorials Point](https://www.tutorialspoint.com/).

## Table of Contents

1. [Tutorial Content & Progress](#tutorial-content--progress)
2. [Folder Structure](#folder-structure) 
3. [Tutorial environment setup](#tutorial-environment-setup)
4. [Application deployment](#application-deployment)

## Tutorial Content & Progress

- [x] EJB - Home
- [x] EJB - Overview
- [x] EJB - Environment Setup | tag: `EJBT-L03`
- [x] EJB - Create Application | tag: `EJBT-L04`
- [x] EJB - Stateless Bean | tag: `EJBT-L05`
- [x] EJB - Stateful Bean | tag: `EJBT-L06`
- [x] EJB - Persistence | tag: `EJBT-L07`
- [x] EJB - Message Driven Beans | tag: `EJBT-L08`
- [x] EJB - Annotations | tag: `EJBT-L09`
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

## Folder Structure

### dev-environment

The folder [`dev-environment`](./dev-environment) contains the Docker environment setup required to run both
the application server and the PostgreSQL database server needed for the tutorial's development environment.

The WildFly server debug port is exposed and mapped to host port `${WILDFLY_DEBUG_PORT}`, allowing you to connect
a debugger to the application server if needed. The [`.run`](./ejb-app/.run) folder contains the IntelliJ IDEA
run configuration for connecting the debugger to the WildFly server.

### ejb-app

The folder [`ejb-app`](./ejb-app) contains the EJB modules developed while following the tutorial and the script
to deploy them to the application server.

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

### Deployment tasks for the EJB Persistence lesson

Before deploying the application, after creating the `LibraryPersistenceSessionBean` (**EJB Persistence** lesson with the
git tag `EJBT-L07`), you must create the `books` table in the PostgreSQL database. To do this, connect to the PostgreSQL
server and execute the SQL script located in the [`db-scripts`](./ejb-app/library-bean/src/main/resources/db-scripts)
folder of the `library-bean` resources.

### Deployment tasks for the EJB Message Driven Beans lesson

To be able to follow the **EJB - Message Driven Beans** lesson, you need to create a JMS queue on the WildFly server.
To do this, connect to the Wildfly web console and navigate to the **Configuration** tab, then select **Subsystems** and
then select the **Messaging-ActiveMQ** option. With the **Messaging ActiveMQ** selected, click the **Server** category.
In the **Server** category, select the **Default** option, then click the **Destinations** tab and finally click
the **View** button.

On the new screen that is shown, select the **JMS Queue** option, on the sidebar, and then click the **Add** button
to create the new JMS Queue. Fill the fields as follows:

- **Name**: `BookQueue`
- **Durable**: Leave checked (default ON)
- **Selector**: Leave black
- **Entries**: `java:/queue/BookQueue` and press enter to add the entry
- **Entries**: `java:jboss/exported/jms/queue/BookQueue` and press enter again to add a second entry

Then click the **Save** button to create the JMS Queue.
