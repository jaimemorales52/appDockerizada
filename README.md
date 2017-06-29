# appDockerizada
Simple application which uses Spring Boot, Swagger and contains the Maven plugin to generate Docker Images. Example about docker-compose too.


First part: 

If you want to start you should run the class "AppDockerizada" like a simple main. In addition, you have to install Mongo service and run it.

Ubuntu -> https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
Windows -> https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

There are three different endpoints: 

localhost:8090/healthCheck -> it checks if the application has runned correctly.

localhost:8090/generateChange -> it changes a text to uppercase, it a simple POST method, the important of this project is that you can use Swagger, Spring Boot and generate a Docker.
Example: RequestBody {"text":"JAIME"}. ResponseBody {"text":"IÑIGO", "change":"jaime"}

localhost:8090/getAllChanges -> it shows all the changes that the application has done.

localhost:8090 -> You can see the endpoints with Swagger Documentation.

Second part:

If you want to generate the Docker Image of this application you should change the class com.demo.docker.config.SpringMongoConfig and uncomment return new MongoClient("mongo"); and comment the other one. After that you have to put in a terminal:  mvn clean package docker:build.

You can use docker-compose to connect this docker with a Mongo Docker. The docker-compose should be this one: 

version: "2"
services:
  mongo:
    image: mongo:latest
    container_name: mongo
    ports:
      - "27017:27017"

  demo-docker:
     image: demo-docker:latest
     container_name: demo-docker
     ports:
      - "8090:8090"
     depends_on:
      - mongo

You can use the endpoints but the difference is that you are connecting to the Docker-compose
