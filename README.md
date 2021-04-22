# User Documentation
The below guide serves the purpose of explaining to our users how the system could be used and what are the various features it offers, and limitations it comes with. 

## How to Use Our System


## Features and Limitations


# Technical Documentation



## How to Build and Run the Application from Source Code / Repositories

### Java Renjin

The Java Renjin project associated with this repository is the backbone of our R programming language integration which runs on the Browser. To build this project, perform the following steps.

Requirements: 
- JDK version used to built Renjin must be JDK 1.8. 

1. Clone the repository locally: `git clone https://github.com/shuvamnandi/ROBRenjinBackend.git`.
2. Change into the directory cloned: `cd ROBRenjinBackend`
3. Run Maven package command: `mvn package`
4. JAR package with dependencies is created at the path: **/target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar** 

An example R code can be run by running by calling the main function in the JAR package using following command:
`java -jar target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar`

The Java JAR package thus generated is going to be deployed inside the web directory to be executed on the browser. This is already done and is available within the UI code using Cadet front-end React application.

### DoppioJS & JavaPolyJS

### Cadet Front-end

The Cadet Front-end code repository is available at https://github.com/nus-cs4215/x-frontend-t3-ps-sn-r.git. 

## Renjin Version and Compatibility


## DoppioJVM architecture and performance bottleneck  


## Extending the product with other libraries from Renjin
