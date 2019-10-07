# Country service #

Country service is a very simple Spring Boot REST API written in Java 8. 
Service uses JPA and data is handled by CRUD -operations. Database is H2 in-memory DB.
REST API documentation with testing options is made by [Swagger](https://swagger.io/).

Below is a guide how to set service up and running.

### Prerequisites ###

* Java 8
* Maven

### Version control ###

Clone repository, see [GitHub Help](https://help.github.com/en/articles/cloning-a-repository).

### Deployment to localhost ###

Make sure you are in folder where's pom.xml -file. 

First, run Maven command to verify that everything is OK

```bash
mvn clean install
```
Then just run command to make service up and running 

```bash
mvn spring-boot:run
```
>Hostname is localhost, port is 8080 and context-path is /countries.

* Database: [H2 Console](http://localhost:8080/countries/h2-console/login.jsp)
(No password needed, just click Connect -button.)

* For testing: [Country service](http://localhost:8080/countries/swagger-ui.html)

If you want to stop the service, then hit

```
Ctrl + c
```

### Contact ###

If you have questions or problems, do not hesitate to ask.