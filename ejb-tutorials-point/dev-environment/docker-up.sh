#!/bin/bash
#
# ----------------------------------------------------------------------------------------------------------------------
# docker-up.sh
#
# Purpose:
#   This script starts and initializes Docker containers, networks and volumes for the Docker environment to be used
#   with the Tutorials Point EJB Tutorial.
#
# ----------------------------------------------------------------------------------------------------------------------

# Determine the folder where this script resides to enable relative path operations
REPOSITORY_FOLDER=$(dirname "${BASH_SOURCE[0]}")

# Load environment variables from the .env file located in the same directory as this script
#
if [[ -f "${REPOSITORY_FOLDER}/.env" ]]; then
    set -a
    source "${REPOSITORY_FOLDER}/.env"
    set +a
else
    echo -e "[\e[31mERROR\e[0m] The .env file was not found in ${REPOSITORY_FOLDER}"
    exit 1
fi

if [ -f "docker-compose.yaml" ]; then
    # Gets the development environment containers list
    CONTAINERS=()
    CONTAINERS+=("${POSTGRES_CONTAINER_NAME}")
    CONTAINERS+=("${WILDFLY_CONTAINER_NAME}")

    # gets the list of existing containers from the above list
    EXISTING_CONTAINERS=()
    for c in "${CONTAINERS[@]}"; do
        if docker ps -a --format '{{.Names}}' | grep -q "^$c$"; then
            EXISTING_CONTAINERS+=("$c")
        fi
    done

    if [ ${#EXISTING_CONTAINERS[@]} -gt 0 ]; then
        echo -e "[\e[34mINFO\e[0m] Starting existing containers: ${EXISTING_CONTAINERS[*]}"
        docker start "${EXISTING_CONTAINERS[@]}"
    else
        echo -e "[\e[34mINFO\e[0m] [Re]Creating the Docker containers and networks in the local environment..."
        docker compose up -d
    fi
    echo
else
    echo -e "[\e[31mERROR\e[0m] One of the referred Docker Compose files is missing. Command not executed."
    echo
    exit 1
fi
