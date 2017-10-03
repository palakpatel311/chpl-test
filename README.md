# chpl-test
Selenium-cucumber : Automation Testing Using Java
Automation test framework and automated tests for regression and acceptance testing of chpl website.

Test framework built with:

    Eclipse - IDE
    Maven - Dependency Management
    Selenium Webdriver - Java 
	Cucumber - Gherkin
	TestNG

Prerequisites
Java
Maven
Eclipse
Eclipse Plugins
	Maven
	Cucumber

Getting started
Install Java and set path  
Install Maven and set path - Maven:https://maven.apache.org/download.cgi
Install Maven plugin in eclipse 
Install cucumber plugin in eclipse

Clone this repository:
$git clone https://github.com/ashwinimore/chpl-test.git

Writing a test
The cucumber features go in the features library and should have the ".feature" extension.
Each test in feature has code in related StepDefinition and is 'glued' together using runner class.

To run cucumber tests
Open a command prompt 
go to project directory where the project is saved and run command

mvn test (default will run on local Chrome browser)

View Reports
Reports generated after test run are saved at:
target/cucumber-html-report
target surefire-reports
test-output/emailable-report.html


