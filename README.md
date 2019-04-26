# spring-boot-oauth2-password-flow

Securing REST API with Spring Security OAuth2 password flow

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.satendra.springbootoauth2passwordflow.SpringBootOauth2PasswordFlowApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Usage example
###### 1. Generate token
```jshelllanguage
curl -X POST -u "trusted-client:trusted-secret" -d "grant_type=password&username=satendra&password=satendra1" http://localhost:8080/oauth/token

{
  "access_token":"1297a472-43d1-49f8-9615-cee0e1afaa44",
  "token_type":"bearer",
  "refresh_token":"b6681620-d142-404a-9af9-0adb1c55fe8d",
  "expires_in":3466,
  "scope":"read write"
}
```
###### 2. Wrong password
```jshelllanguage
curl -X POST -u "trusted-client:trusted-secret" -d "grant_type=password&username=satendra&password=worngpassword" http://localhost:8080/oauth/token

{
  "error":"invalid_grant",
  "error_description":"Bad credentials"
}

```
###### 3. Wrong client username or password
```jshelllanguage
curl -X POST -u "wrongclient:trusted-secret" -d "grant_type=password&username=satendra&password=satendra1" http://localhost:8080/oauth/token

{
  "timestamp":"2019-04-26T18:28:14.872+0000",
  "status":401,
  "error":"Unauthorized",
  "message":"Unauthorized",
  "path":"/oauth/token"
}

```
