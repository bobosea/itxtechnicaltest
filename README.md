# <span style="color:green"> itxtechnicaltest - Inditex technical test </span>

This project is a technical test to Inditex in order to demostrate technical skills.

### <span style="color:green"> About project </span>

The project is a demo of implementing a Rest service using Spring Boot. Hexagonal architecture has been used. The data base is H2. 

### <span style="color:green"> Import project </span>

The project can be imported in any IDE as maven project.

### <span style="color:green"> Running the application </span>

1. Compile the project executing the next command in the root folder of the project:

```bash
mvn clean install
```

2. Deploy the project executing the next command in the same folder:

```bash
java -jar .\launcher\target\launcher-0.0.1-SNAPSHOT.jar
```

The Service will be deployed in the endpoint:

http://localhost:8080/price?applicationDate=yyyy-MM-ddTHH:mm:ssZ&productId=x&brandId=x

### <span style="color:green"> Execute E2E tests </span>

Karate scenarios to do the E2E tests have been created.

Try them executing the next command in the `/launcher` folder:

```bash 
mvn test -Dtest=PriceRunner#priceTest
```

As alternative the class `PriceRunner` can be executed by the IDE.

Karate generates automaticaly a form with the result of the test execution at:

```bash
file:///project_path/launcher/target/karate-reports/karate-summary.html
```

### <span style="color:green"> See H2 db </span>

The database console is enabled and can be visited in the url:

http://localhost:8080/h2-console

url : `jdbc:h2:mem:itxtechnicaltestdb`

Username: `sa`

Password: 

