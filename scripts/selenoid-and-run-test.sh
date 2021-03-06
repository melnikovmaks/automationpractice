#!/bin/bash

main() {
  # Removes selenoid if exists

  stop_and_remove_if_exists selenoid
  remove_image_if_exists selenoid
  docker-compose up --no-recreate -d selenoid
  docker image ls selenoid/chrome:97.0 | grep 'selenoid/chrome' || docker pull selenoid/chrome:97.0
  docker image ls selenoid/chrome:96.0 | grep 'selenoid/chrome' || docker pull selenoid/chrome:96.0
  docker image ls selenoid/firefox:96.0 | grep 'selenoid/firefox' || docker pull selenoid/firefox:96.0

  i="0"
  while [ $i -lt 5 ]; do
    i=$(($i + 1))

    if [ -n "$(docker ps -aq --filter "name=healthcheck")" ]; then
      echo Remove healthcheck...
      docker rm $(docker stop healthcheck)
    fi

    docker images | grep 'selenoid/chrome' || continue
    docker images | grep 'selenoid/firefox' || continue

    docker run --rm --name healthcheck --network automationpractice_default curlimages/curl:7.72.0 \
      curl -i selenoid:4444 | grep "HTTP/1.1 200 OK" && break

    echo "Waiting for selenoid to start..."

    sleep 3

    if [ "$i" -eq 5 ]; then
      echo -e "========FAILED TO START SELENOID...========\n"

      docker ps -a
      echo -e "======================================================================="
      exit 1
    fi
  done
  echo "======== Run automation... ========"
}

stop_and_remove_if_exists() {
  docker-compose rm -f -s -v $1
}

remove_image_if_exists() {
  local image=$(docker images | grep $1)
  if [[ ! -z "$image" ]]; then
    docker rmi -f $1
  fi
}

main
mvn clean test
