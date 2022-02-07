### QA Framework

This repo uses Selenium web driver with Java for UI automation of xcov19.

#### Steps to setup
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

#### Steps to run the test classes
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
