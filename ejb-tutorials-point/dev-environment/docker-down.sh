#!/bin/bash
#
# ----------------------------------------------------------------------------------------------------------------------
# docker-down.sh
#
# Purpose:
#   This script manages Docker containers for the Tutorials Point EJB Tutorial development environment.
#   Options:
#     --delete | -d : Stop and remove containers, networks, and dangling volumes (full cleanup)
#     --stop | -s : Only stop the containers
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

usage() {
    echo
    echo -e "\e[1mPurpose:\e[0m This script manages Docker containers for the Tutorials Point EJB Tutorial"
    echo "development environment."
    echo
    echo "It can be used to either stop the containers or perform a full environment cleanup"
    echo "by stopping and removing containers, networks, and dangling volumes."
    echo
    echo -e "\e[1mUsage:\e[0m $0 [--down|-d | --stop|-s]"
    echo
    echo -e "\e[1mOptions:\e[0m"
    echo "    --down | -d : Stop and remove containers, networks, and dangling volumes (full cleanup)"
    echo "    --stop | -s : Only stop the containers"
    echo
    exit 1
}

if [ $# -ne 1 ]; then
    usage
fi

if [ ! -f "docker-compose.yaml" ]; then
    echo -e "[\e[31mERROR\e[0m] docker-compose.yaml is missing. Command not executed."
    exit 1
fi

case "$1" in
    --delete|-d)
        echo -e "[\e[34mINFO\e[0m] Stopping and deleting the Docker containers and networks..."
        docker compose down
        echo

        if [ -z "$(docker volume ls -qf dangling=true)" ]; then
            echo -e "[\e[33mWARN\e[0m] No dangling volumes to be removed."
        else
            echo -e "[\e[34mINFO\e[0m] Removing the Docker dangling volumes..."
            # shellcheck disable=SC2046
            docker volume rm $(docker volume ls -qf dangling=true)
        fi
        echo -e "[\e[34mINFO\e[0m] Pruning the Docker system..."
        docker system prune --force --volumes
        ;;
    --stop|-s)
        echo -e "[\e[34mINFO\e[0m] Stopping the Docker containers..."
        docker stop "${WILDFLY_CONTAINER_NAME}"
        docker stop "${POSTGRES_CONTAINER_NAME}"
        ;;
    *)
        usage
        ;;
esac
