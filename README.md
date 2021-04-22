# User Documentation
The below guide serves the purpose of explaining to our users how the system could be used and what are the various features it offers, and limitations it comes with. 

## How to Use Our System


## Features and Limitations


# Technical Documentation

## How to Build and Run the Application from Source Code / Repositories

### Java Renjin

The Java Renjin project associated with this repository is the backbone of our R programming language integration which runs on the Browser. It is available at the GitHub repository https://github.com/shuvamnandi/ROBRenjinBackend.git.

#### Requirements: 
- JDK version used to built Renjin must be JDK 1.8.
- Renjin Version used (as specified in `pom.xml`) should be as follows (newer versions do not work on DoppioJVM):
```
<dependency>
    <groupId>org.renjin</groupId>
    <artifactId>renjin-script-engine</artifactId>
    <version>0.7.0-RC7</version>
</dependency>
```

#### To build this project, perform the following steps: 

1. Clone the repository locally: `git clone https://github.com/shuvamnandi/ROBRenjinBackend.git`.
2. Change into the directory of the cloned repo: `cd ROBRenjinBackend`
3. Run Maven package command: `mvn package`
4. JAR package with dependencies is created at the path: **/target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar** 

An example R code can be run by running by calling the main function in the JAR package using following command:

`java -jar target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar`

The Java JAR package thus generated also contains all of its dependencies from Renjin and also R packages that can be imported for evaluating R code. This JAR package would be deployed inside the directory of the web server run which executes on the browser. This is already done and is available within the UI code repository with this GitHub repository, hosting the Cadet front-end React application which supports R code execution.

### DoppioJS & JavaPolyJS

### Cadet Front-end

The Cadet Front-end code repository is available at https://github.com/nus-cs4215/x-frontend-t3-ps-sn-r.git. 

## Renjin Version and Compatibility


## DoppioJVM architecture and performance bottleneck  


## Extending the product with other libraries from Renjin

R Packages like **matlib** are included to be used for executing code on the browser. These are added as Maven dependencies within the `pom.xml` file present in the ROBRenjinBackend GitHub repository.

The above dependency is added to the project as per an example below:
```
<dependency>
    <groupId>org.renjin.cran</groupId>
    <artifactId>matlib</artifactId>
    <version>0.4.1-b1</version>
</dependency>
```

There are several CRAN (the Comprehensive R Archive Network) and BioConductor packages available at the website http://packages.renjin.org. The packages in this repository are built and packaged for use with Renjin. Not all packages can be built for Renjin, therefore the available list of packages could be searched to confirm whether a given package is available for Renjin.
