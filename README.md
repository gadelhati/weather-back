# Weather _Back_

![github](https://img.shields.io/github/stars/gadelhati/nutrition?style=social "Github")
![java](https://img.shields.io/badge/java-19-2145E8 "Java")
![postgresql](https://img.shields.io/badge/postgresql-15.1.1-6495ED "PostgreSQL")
![springboot](https://img.shields.io/badge/springboot-3.0.1-53D05D "Spring Boot")

#### Necessary knowledge:
<a href="https://www.java.com" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="25" height="25"/>
</a>
<a href="https://www.postgresql.org" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="25" height="25"/>
</a>
<a href="https://spring.io/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="25" height="25"/>
</a>
<a href="https://heroku.com" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/heroku/heroku-icon.svg" alt="heroku" width="25" height="25"/>
</a>

## Description
The codes FM 12 - XI SYNOP and FM 13 - XI SHIP are preset number sequences
that encode observations made at a Surface Meteorological Station (SYNOP) or from
Stations on board ships (SHIP).
The initiative to create a program in which the code is typed instead of being filled out on paper. Automating the exchange and its consequent inclusion in historical database.

### Required downloads:
|     name     | source |                 file name version | link for download                                                                   |
|:------------:|:------:|----------------------------------:|:------------------------------------------------------------------------------------|
|  `intellij`  |  IDE   |               idealC-2022.3.1.exe | https://download-cdn.jetbrains.com/idea/ideaIC-2022.3.1.exe                         |
|    `java`    |  JDK   |        jdk-19_windows-x64_bin.exe | https://download.oracle.com/java/19/latest/jdk-19_windows-x64_bin.exe               |
| `postgresql` |  SGBD  | postgresql-15.1.1-windows-x64.exe | https://get.enterprisedb.com/postgresql/postgresql-15.1-1-windows-x64.exe           |
|  `pgadmin4`  |        |             pgadmin4-6.19-x64.exe | https://ftp.postgresql.org/pub/pgadmin/pgadmin4/v6.19/windows/pgadmin4-6.19-x64.exe |

### Roadmap
#### in development
[//]: # (q1 If you have ideas for releases in the future, it is a good idea to list them in the README.)
- [ ] filter by Source
- [x] auditAware with UserEntity, to add user in GenericEntity
- [x] @PostFilter(hasPermission('')), hasAuthority('Admin')
#### in concept
- [ ] add data Point of PostGis
- [ ] set up Role Hierarchy
- [ ] service to provide sidebar access
- [ ] service to provide color palete
- [ ] improve refresh token
- [ ] change application.properties to [dev using h2, and prod using postgres]
- [ ] add Internationalization to ValidationMessages.properties
- [ ] swagger something is not showing (Whitelabel Error Page)

## Summary
* [How to work with this project](#how-to-work-with-this-project)
    - [how to create this project](#how-to-create-this-project)
    - [how to clone the project and build locally](#how-to-clone-the-project-and-build-locally)
    - [how to install dependencies for this project](#how-to-install-dependencies-for-this-project)
    - [how to run project](#how-to-run-project)
    - [how to stop application on localhost](#how-to-stop-application-on-localhost)
    - [how to create file war](#how-to-create-file-war)
    - [how to select page on get request](#how-to-select-page-on-get-request)
    - [how to deploy on Tomcat Server](#how-to-deploy-on-tomcat-server)
* [Change JDBC URL on h2](#change-JDBC-URL-on-h2)
* [Features](#features)
* [HTTP Status code list](#http-status-code-list)
* [Developers](#developers)
* [Licence](#licence)

## How to work with this project
Type in intellij terminal tab

### how to create this project
> [https://start.spring.io/](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.0&packaging=war&jvmVersion=20&groupId=com.observation&artifactId=weather&name=weather&description=weather%20observation&packageName=com.observation.weather)

### how to clone the project and build locally
```
git clone http://localhost:3120/nutrition/food
```

### how to install dependencies for this project
```
mvn dependency:copy-dependencies
```

### how to run project
```
mvn spring-boot:run
```

### how to stop application on localhost
```
netstat -a -n -o
tskill "NÚMERO DO PID"
```

### how to create file war
```
mvn clean package
```
two files with the extension .war will be created, the one with the shortest name will be used.

### how to select page on get request
```
{{weather-back}}/user?page=2&size=5
{{weather-back}}/user?sort=name,desc
```

### how to deploy on Tomcat Server
Type in your linux server
```
service tomcat stop
rm /opt/tomcat/webapps/<old_version>.war
rm -Rfv /opt/tomcat/webapps/<old_version>
cp /home/<user>/<application_name>.war /opt/tomcat/webapps/
chown tomcat:tomcat /opt/tomcat/webapps/<application_name>.war
chmod 755 <application_name>
service tomcat start
```
## Change JDBC URL on h2:
```
2021-04-18 21:44:01.317  INFO 7560 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-ui'. Database available at 'jdbc:h2:mem:testdb'
```
in case:
```
jdbc:h2:mem:testdb
```
## Dependencies
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.1.0</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <version>3.1.0</version>
        <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-websocket -->
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-websocket</artifactId>
        <version>11.0.0-M5</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.26</version>
        <scope>provided</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.5.5.Final</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-envers -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-envers</artifactId>
        <version>6.2.3.Final</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api -->
    <dependency>
        <groupId>jakarta.validation</groupId>
        <artifactId>jakarta.validation-api</artifactId>
        <version>3.0.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>3.1.0</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
        <version>3.1.0</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-test -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <version>6.1.0</version>
        <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.5.1</version>
        <scope>runtime</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`

```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/observation
spring.datasource.username= postgres
spring.datasource.password= password

spring.jpa.properties.hibernate.dialect= org.hibernate.spatial.dialect.postgis.PostgisDialect
spring.jpa.hibernate.ddl-auto= create

```

## Features
These are the paths to services:

- [x] [CREATE](http://127.0.0.1/weather-back/user) - path to item creation;
- [x] [RETRIEVE](http://127.0.0.1/weather-back/user/source) - path to retrieve of all or an item both by source;
- [x] [UPDATE](http://127.0.0.1/weather-back/user) - path to update an item;
- [x] [DELETE](http://127.0.0.1/weather-back/user/id) - path to delete an item;
- [x] [DELETE_ALL](http://127.0.0.1/weather-back/user) - path to delete all items;

## HTTP Status code list
> [HHTP Status Code](https://httpstatuses.com/)

## Developers
> [Gadelha TI](https://github.com/gadelhati)

## Licence
> [MIT License](https://choosealicense.com/licenses/mit/)

```
MIT License

Copyright (c) 2020 Jason Watmore

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```