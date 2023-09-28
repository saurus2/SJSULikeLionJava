# JPA

## Entity

> a class of type Entity (e.g. UserEntity) indicates a class that, at an abstract level, is correlated with a table in the database.

- JPA helps create table in the connected MySQL following the annotations and components of the class.

### Cheat Sheet

https://www.codecademy.com/learn/learn-spring/modules/spring-data-and-jpa/cheatsheet

https://www.javaguides.net/2023/07/jpa-and-hibernate-annotations-cheat-sheet.html

## Repository

JpaRepository is a JPA (Java Persistence API) contains the full API of CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and also API for pagination and sorting.

- insert example

```
public void insert(){
	User user =  User.builder()
		.username("user1")
		.password("1234")
		.build();
	userRepository.save(user);
}
```

## Querydsl

> Querydsl is an extensive Java framework, which helps with creating and running type-safe queries in a domain-specific language that is similar to SQL.

- Run 'compileQuerydsl' in build.gradle
- build/generated/querydsl created

```
compileQuerydsl {
	options.annotationProcessorPath = configurations.querydsl
}
```
