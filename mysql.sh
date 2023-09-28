#!/usr/bin/env bash

cd database
docker build -t liondb-img .
docker run --name liondb-con -p 3306:3306 -d liondb-img