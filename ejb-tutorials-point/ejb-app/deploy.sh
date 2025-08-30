#!/bin/bash
# deploy.sh
#
# This script automates the deployment of the Enterprise Java Beans (EJB) modules to the Wildfly application server
# running in a Docker container built and started with the code available in the `dev-environment` folder included in
# this repository (ejb-tutorials-point/dev-environment). It copies the EJB JAR files to the appropriate deployment
# folder.

# UI messages
MESSAGE_MISSING_ARTIFACT="The artifact is not present in the target folder"

# Determine the folder where this script resides to enable relative path operations
REPOSITORY_FOLDER=$(dirname "${BASH_SOURCE[0]}")

# Load environment variables from the .env file located in the same folder of this script
if [[ -f "${REPOSITORY_FOLDER}/../dev-environment/.env" ]]; then
    set -a
    source "${REPOSITORY_FOLDER}/../dev-environment/.env"
    set +a
else
    echo -e "[\e[31mERROR\e[0m] The .env file was not found in ${REPOSITORY_FOLDER}"
    exit 1
fi

EJB_SERVER="${WILDFLY_CONTAINER_NAME}:/opt/jboss/wildfly/standalone/deployments"

echo "------------------------------------------------------------------------------------------------------------------"
echo -e "[\e[34mINFO\e[0m] Deploying the ejb-library module on the Wildfly container"
if [ -f ./library-bean/target/ejb-library.jar ]; then
    docker cp "./library-bean/target/ejb-library.jar" "${EJB_SERVER}/"
else
    echo -e "[\e[31mERROR\e[0m] ${MESSAGE_MISSING_ARTIFACT}"
fi
echo "------------------------------------------------------------------------------------------------------------------"
