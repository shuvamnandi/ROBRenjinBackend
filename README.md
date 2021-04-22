# R On Browser (ROB)


Most popular high-level languages have playgrounds and scratch pads to work out simple questions or try some snippet of code. These platforms not only help a person to test some feature of a language but also can be used as a channel for education. For example, Kotlin has a fancy playground [ref] where interested developers can pick up the language. Unfortunately, we could only find one such platform [ref] for the language R that is packed with a lot of advertisements to generate revenue and also cover the costs of the backend servers. The lack of good options motivated us to develop an in-browser solution for R where people can teach, learn and conduct interviews. And this is how ROB (R On Browser) came into this world!


The below guide serves the purpose of explaining to our users how the system could be used and what are the various features it offers, and limitations it comes with. 

### How to Use Our System
It is fairly simple to work with ROB. Just go to the URL, be a little patient and then run your R code. 


### Features 
-	All the core features of language R are supported except plotting and other graphical features.
-	Syntax and code highlighting is provided within the editor
-	Matlib library for linear algebra is integrated with the platform.
-	Static analysis of the code using the lint library is available to teach and learn better

### Limitations
-	The initial setup and loading takes roughly 1 minute but once the system in booted on the browser, it’s quite fast to run and test code.
-	The system is meant for educational purposes and small tasks. It can be slow to run computationally intensive code.  

## Technical Documentation

### How to Build and Run the Application from Source Code / Repositories

#### Java Renjin

The Java Renjin project associated with this repository is the backbone of our R programming language integration which runs on the Browser. It is available at the GitHub repository https://github.com/shuvamnandi/ROBRenjinBackend.git.

##### Requirements: 
- JDK version used to built Renjin must be JDK 1.8.

##### To build this project, perform the following steps: 

1. Clone the repository locally: `git clone https://github.com/shuvamnandi/ROBRenjinBackend.git`.
2. Change into the directory of the cloned repo: `cd ROBRenjinBackend`
3. Run Maven package command: `mvn package`
4. JAR package with dependencies is created at the path: **/target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar** 

An example R code can be run by running by calling the main function in the JAR package using following command:

`java -jar target/ROBRenjinRunner-1.01-SNAPSHOT-jar-with-dependencies.jar`

The Java JAR package thus generated also contains all of its dependencies from Renjin and also R packages that can be imported for evaluating R code. This JAR package would be deployed inside the directory of the web server run which executes on the browser. This is already done and is available within the UI code repository with this GitHub repository, hosting the Cadet front-end React application which supports R code execution.

#### JavaPolyJS - A Wrapper JavaScript library for DoppioJVM & Browser FS

An external library called JavaPoly was referred https://github.com/jdstroy/JavaPoly for integrating DoppioJVM & BrowserFS libraries for running Java (and thus R) code on the browser.

#### Cadet Front-end

The Cadet Front-end code repository is available at https://github.com/nus-cs4215/x-frontend-t3-ps-sn-r.git. 

1. Make sure that you have the `x-slang` repository from https://github.com/nus-cs4215/x-slang-t3-ps-sn-r cloned locally, and have built it and linked it.
2. Install a stable version of NodeJS. The active LTS or current version should work fine.
3. Clone this repository and navigate to it using "cd" in your command line or shell tool.
4. Run `yarn link x-slang` to use your local x-slang for x-frontend.
5. Run `yarn install` to install dependencies.
6. Run `yarn run start` to start the server at localhost:8000. It might take a couple of minutes for the server to start.
7. Point your browser to http://localhost:8000 to see local Source Academy capable of running R code on the browser.

The Java Renjin JAR package is already part of this repository, and hence does not require copying over the package built from the previous steps again, in order to integrate it with this setup. The same goes for the modified JavaPolyJS library used to run is also part of this repository.


### Renjin Version and Compatibility

The Renjin Version used (as specified in `pom.xml`) should be as below (newer versions do not work on DoppioJVM). This is a limitation of DoppioJVM.

```
<dependency>
    <groupId>org.renjin</groupId>
    <artifactId>renjin-script-engine</artifactId>
    <version>0.7.0-RC7</version>
</dependency>
```

### DoppioJVM Architecture and Performance Bottleneck  


### Extending the Product with other Libraries from Renjin

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
