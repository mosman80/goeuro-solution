# goeuro-solution

What Is This?
-------------
This repository is created to provide a proposed solution of the goeuro dev test 

Application Description
-----------------------
The main functionality of this application is to call a simple Restfull service which returns a json Object with a list of properties, and export the result values to a CSV file with a specific format. To achieve this the application uses Jersey Client API for building the service client and execute the service call. To map the response to CSV file the jackson-dataformat-csv liberary is used.

How To Install The Application
------------------------------
Before installing/ building the application, it is better to configure the application parameters according to your environment. For simplicity the application contains a single property file, but it should have a property file for each environment mapped to a maven profile. The configured parameter as following:

1- Open the property file wsClientConfiguration.properties and edit its properties as following:

- generated.file : is the default path to export the generated CSV file.
- log4j.file : is the default path for creating the application logs
- log4j.file.level : is the level of log for on the file appender
- log4j.stdout.level : is the log level for the console.


2- To build the application use the following mvn command:
- mvn clean package

3- output of the above command will compile all sources and generate a fat jar file named GoEuroTest-1.0-jar-with-dependencies.jar

How To Use The Application
-----------------------
1- To run the application navigate to the generated jar file and execute the command:
- java -jar GoEuroTest-1.0-jar-with-dependencies.jar "CITY NAME"

2- To run the unit test cases use following mvn command:

- mvn clean test -pl :GoEuroTest -Dtest=FileExportTest
- mvn clean test -pl :GoEuroTest -Dtest=WebServiceCityConsumerTest

