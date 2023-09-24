# Spring Boot Mini Project

## Docker

### Build before running

```
./gradlew clean build
```

### Run docker

type below in terminal in the path containing docker-compose.yml

```
docker-compose up
```

## JPA

### Querydsl

Run the below from build.gradle

```
compileQuerydsl {
	options.annotationProcessorPath = configurations.querydsl
}
```
