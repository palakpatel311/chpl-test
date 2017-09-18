$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "LoginFeature",
  "description": "To test Login functionality of CHPL application",
  "id": "loginfeature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User navigates to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters valid username and password",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User click slogin button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "login should be successfull",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("overviewTest.feature");
formatter.feature({
  "line": 2,
  "name": "To test Overview page",
  "description": "This test checks overview page under CHPl resources and verifies that it displays",
  "id": "to-test-overview-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@selenium"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Overview page loads and shows correct title",
  "description": "",
  "id": "to-test-overview-page;overview-page-loads-and-shows-correct-title",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User clicks on Overview page link in navigation menu",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Overview page loads successfully and verify title",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 10,
  "name": "Verify ONC-ACB and ONC-ATL information loads from database",
  "description": "",
  "id": "to-test-overview-page;verify-onc-acb-and-onc-atl-information-loads-from-database",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "User looks at ONC-ACB and ONC-ATL information table",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the table shows data from databse",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("sampletest.feature");
formatter.feature({
  "line": 2,
  "name": "To test my cucumber test is running",
  "description": "I want to run a sample feature file.",
  "id": "to-test-my-cucumber-test-is-running",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "cucumber setup",
  "description": "",
  "id": "to-test-my-cucumber-test-is-running;cucumber-setup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "sample feature file is ready",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I run the feature file",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});