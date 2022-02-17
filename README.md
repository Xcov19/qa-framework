## QA Framework

This repo uses Selenium web driver with Java for UI automation of xcov19.

### Prerequisites

1. Install java https://www.oracle.com/java/technologies/downloads/#jdk17-mac

```
$ java -version
java version "17.0.2" 2022-01-18 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
```

2. Install maven https://maven.apache.org/download.cgi
```
$ mvn -version
Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: /usr/local/Cellar/maven/3.8.4/libexec
Java version: 17.0.2, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk/17.0.2/libexec/openjdk.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.7", arch: "x86_64", family: "mac"
```
### To start automation script

1. Go to the project root directory
```
$ cd qa-framework
```
2. Start the script
```
  $ mvn test
```
3. Command to run a particular test class
```
$ mvn test -Dtest="classname"
```
Example: 
``` 
$ mvn test -Dtest="com.xcov19.test.LoginValidation"
```

----------------------------------------------------------------------------------------------------------
#### Steps to setup using Eclipse
1. Install Eclipse
2. Create  a workspace in your local. Workspace is nothing but a folder which is dedicated for all selenium files.
3. Open Eclipse and switch to the newly created workspace.
4. Copy all the files from git into your local.
5. There is no need to add any drivers or libraries externally as we have created a Maven project and everything that is required, is available in pom.xml file of the project. ie dependancy code with the list of all jar files and libraries.

#### Project structure:
Consists of two main folders: 
##### src/main/java 
Consists of two packages:
- com.XCOV19.generics: consists of classes and interfaces with all userdefined reusable methods.
- com.XCOV19.pom: consists of all the POM(Page object model) classes (To be created by QA).


##### src/test/java
Consists of one package:
 - com.XCOV19.test: This package consists of all the test classes. Each test class is one test case (To be created by QA).

#### Steps to run the test classes on Eclipse
- Right click on the project.
- Click on TestNG.
- Select convert to TestNG option. 
- Refresh the project.  testng.xml file will be created with all the test classes within it.
- Open the testng.xml file.
- Click on Run as button available on the top menu bar.
- Select TestNG suite and click on OK.

#### Steps to see the output
- Click on the Test output folder.
- Right click on emailable report and mouse hover on Open with.
- Select web browser option. A detailed report with all passed and failed test cases is shown.
