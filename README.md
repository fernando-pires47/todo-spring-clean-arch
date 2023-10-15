# TODO Spring Clean Architecture
TODO Project implementing concepts like Clean Architecture and Ports and Adapters at its core, also, implements best practices using design pattern.


### Modules
* Board
* Task

### Dependencies
* Docker
* Docker Compose
* Java 17

### Project libs used
* Spring Boot
* Spring Data JPA
* Spring Security
* Spring Web
* H2 Database
* Spring Open API

### Development concepts implemented
* Clean Architecture
* Ports and Adapters
* Design Pattern(Builder, Factory, Adapter)
* Inversion and Dependency Injection
* Domain Model
* Repository Presentation
* DRY
* KISS
* SOLID Principles

### Security implementation
* API Key Authentication
* Bearer Authentication

### Application Setting

Can be defined some settings in application.properties files.

#### Providers

Two environment providers are used in this application(Development and Production).

Default settings use application.properties file. If production profile is used, settings can be override.

To define profile default:

```bash
spring.profiles.active=dev
```


##### URL Access

To access application tt is necessary to take care of the following points: Port and Servlet Context. 

Example:

```bash
http://localhost:{port}{servlet_context}
```
  
To configure it:

```bash
server.port=8080
server.servlet.context-path=/api/v1
```

#### Database 

Used in this application H2 Database, some settings are required for optimal operation.

To allow access H2 manager:

```bash
spring.h2.console.enabled=true
```

You can access H2 manager using URL:

```bash
http://localhost:{port}{servlet_context}/h2-console
```

To customize main settings:

```bash
spring.datasource.url=jdbc:h2:mem:memdb
spring.datasource.username=user
spring.datasource.password=12345
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

To run scripts when starting the application, create file in resource directory is necessary.

Allow format:

```bash
spring.sql.init.mode=always
```

To define file name:

```bash
spring.sql.init.data-locations=classpath:data.sql
```

Current Script in data.sql:

```bash
insert into board (id, name, date_create, status) values (-99, 'teste', '2023-10-10', 'ACTIVE');
insert into board (id, name, date_create, status) values (-98, 'teste', '2023-10-10', 'ACTIVE');
insert into board (id, name, date_create, status) values (-97, 'teste', '2023-10-10', 'ACTIVE');
insert into task (id, title, description, status, date_create, board) values (-99, 'teste', 'teste', 'ACTIVE', '2023-10-10', -99);
insert into task (id, title, description, status, date_create, board) values (-98, 'teste', 'teste', 'ACTIVE', '2023-10-10', -99);
insert into task (id, title, description, status, date_create, board) values (-97, 'teste', 'teste', 'ACTIVE', '2023-10-10', -99);
```

Script above it is necessary to realize integrations tests. Change it can impact in all tests.

Default settings use JPA to auto generate and run scripts when application run start.

To define:

```bash
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
```
If you prefer manage the structural creation of the database you can use scheme structure. In this format you need create sql file inside resource directory. 

Allow format:

```bash
spring.sql.init.mode=always
```

To define file name:

```bash
spring.sql.init.schema-locations=classpath:schema.sql
```

And

```bash
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false
spring.jpa.generate-ddl=false
spring.jpa.hibernate.ddl-auto=none
spring.jpa.defer-datasource-initialization=false
```

#### Authentication

Two providers currently existing: (API Key, Bearer)

To define API Key provider:

```bash
custom.security.provider=api-key
custom.token.key=Authorization
custom.token.value=123
```

To define Bearer provider:

```bash
custom.security.provider=bearer
custom.token.value=123
```

#### API Documentation

Used Open API to document this application. You can define some settings in application:

To define Swagger URL access:

```bash
springdoc.swagger-ui.path=/swagger-ui
```

To access:

```bash
http://localhost:{port}{servlet_context}{springdoc.swagger-ui.path}
```

To define Swagger environments URL:

```bash
custom.openapi.dev-url=http://localhost:8080
custom.openapi.prod-url=http://localhost:8080
```

### Build and Run Web Application

To run manually:

##### Build

 To build with tests:

 ```bash
 ./mvnw -B clean package 
```

 To build without tests:

```bash
 ./mvnw -B clean package -Dmaven.test.skip
```

##### Run application

To run defining providers

```bash
 java -jar -Dspring.profiles.active=prod app.jar
```

Else

```bash
 java -jar app.jar
```

To run with docker-compose:

```bash
 docker-compose up -d
```

### Future features
* Implement basic auth
* Implement KeyClock auth


## License

This application is available under the
[MIT license](https://opensource.org/licenses/MIT).







  
