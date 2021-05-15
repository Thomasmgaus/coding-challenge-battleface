This project was created with JDK 11 using Apache Maven 3.8.1

To run this project navigate to your git repo and run mvn clean install

This should generate quotationservice-0.0.1-SNAPSHOT.jar in quotationservice/target/

From there run java -jar quotationservice-0.0.1-SNAPSHOT.jar

This should start the service on localhost:8080

Then you can run a post sample request to localhost:8080/quotation 

{
    "age":"18,25,40",
    "currency_id":"EUR",
    "start_date":"2020-10-01",
    "end_date":"2020-10-30"
}

with the headers content-type:application/json



