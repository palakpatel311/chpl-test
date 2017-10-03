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
  "name": "Access login form",
  "description": "",
  "id": "loginfeature;access-login-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User is on CHPL home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User clicks on Administrator Login button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "login form shows in dropdown",
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
formatter.scenario({
  "line": 10,
  "name": "Login with correct username and password",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "User enters valid username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User clicks login button",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "login should be successful",
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
formatter.uri("chpldownload.feature");
formatter.feature({
  "line": 1,
  "name": "Download chpl data files",
  "description": "To test download files functionality of CHPL application",
  "id": "download-chpl-data-files",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Load download page",
  "description": "",
  "id": "download-chpl-data-files;load-download-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User is on CHPL home",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User clicks on CHPL Resources button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Download the CHPL page loads successfully and page title shows correct",
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
formatter.scenario({
  "line": 10,
  "name": "User is not logged in, 7 files available",
  "description": "",
  "id": "download-chpl-data-files;user-is-not-logged-in,-7-files-available",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "user is not logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "user clicks on download file box",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user sees 7 download files",
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
formatter.scenario({
  "line": 16,
  "name": "Each download file has associated definition file",
  "description": "",
  "id": "download-chpl-data-files;each-download-file-has-associated-definition-file",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "user selects a file in download file box",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "definition file shows based on download file selection",
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
  "line": 20,
  "name": "User logs in, 8 download files available",
  "description": "",
  "id": "download-chpl-data-files;user-logs-in,-8-download-files-available",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "user clicks on download file box",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "user sees 8 download files",
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
});