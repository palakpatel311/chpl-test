# CHPL Automated Testing Suite

Based on Selenium-cucumber: Automation Testing Using Java Automation test framework and automated tests for regression and acceptance testing of chpl website.

## Test framework built with:

* Eclipse - IDE
* Maven - Dependency Management
* Selenium Webdriver - Java
* Cucumber - Gherkin
* TestNG
* RestAssured

## Prerequisites
* Java
* Maven
* Eclipse
* Eclipse Plugins
* Cucumber
* Chromedriver

## Getting started

* Install Java and set path
* Install Maven and set path - Maven: https://maven.apache.org/download.cgi
* Install Maven plugin in eclipse
* Install cucumber plugin in eclipse
* Clone this repository: https://github.com/chpladmin/chpl-test.git
* Install chromedriver and set it on your PATH
* Install Geckodriver and set it on your PATH

## Browser configuration locally

* Set up browser in config.properties file in which you want to run test

## Writing a test

The cucumber features go in the src/test/resources/Features directory and should have the ".feature" extension.

Each test in feature has code in related StepDefinition and is 'glued' together using runner class.

## Running tests

To run cucumber tests open a command prompt go to project directory where the project is saved and run command

`mvn test`

### Options

Options can be used to tweak the functionality of the tests. They're used with the flag `-D`, as, for example `-Durl="http://localhost:3000/"`

| option name       | default value                                                                       | reason                               |
|-------------------|-------------------------------------------------------------------------------------|--------------------------------------|
| url               | http://localhost:3000/                                                              | URL to run tests against             |
| apikey            | no default; if a test needs an API Key and one is not specified it will fail        | API Key to use with rest calls       |
| downloadPath      | temporary directory, or if that fails `user.dir`/target/download-files              | Directory where files are downloaded |
| roleAdminUsername | no default; if a test needs an admin username and one is not specified it will fail | Admin User to log in as              |
| roleAdminPassword | no default; if a test needs an admin password and one is not specified it will fail | Admin Password to use                |
| roleOncUsername   | no default; if a test needs an ONC username and one is not specified it will fail   | ONC User to log in as                |
| roleOncPassword   | no default; if a test needs an ONC password and one is not specified it will fail   | ONC Password to use                  |
| roleAcbUsername   | no default; if a test needs an ACB username and one is not specified it will fail   | ACB User to log in as                |
| roleAcbPassword   | no default; if a test needs an ACB password and one is not specified it will fail   | ACB Password to use                  |

### Cucumber options

To run only a single feature file, run the command

`mvn test -Dcucumber.options="src/test/resources/Features/UI OR API/filename.feature"`

If your console does not support color, enable monochrome with:

`mvn test -Dcucumber.options="-m"`

To only run Features with specific tags:

`mvn test -Dcucumber.options="--tags @runThis"`

To not run some Features by tag:

`mvn test -Dcucumber.options="--tags ~@ignore"`

All together

`mvn test -Dcucumber.options="-m --tags @runThis --tags ~@ignore"`

To run UI Regression test

`mvn test -Dcucumber.options="-m "--tag @Regression"`

To run API Regression test

`mvn test -Dcucumber.options="-m "--tag @RegressionAPI"`

## Tags information:
@Regression: for UI regression test
@RegressionAPI: for API regression test

@Before and @After hooks will be ignoring @RegressionAPI tag.

## View Reports Reports generated after test run are saved at:

target/cucumber-pretty/index.html
