# Spring Boot Mini Project

## How to run

### Build before running (first time only)

```bash
./gradlew clean build
```

### 1. Run mysql server in docker container

```bash
cd database
docker build -t liondb-img .
docker run --name liondb-con -p 3306:3306 -d liondb-img
```

### 2. Run Spring boot project in IDE
