Feature: OCD-2114 - Test update to ACB filters on Search page to have SLI Compliance ACB checked by deafult in search filters

Scenario: Verify SLI Compliance filter option under ACB filters is checked by default
	Given I am on CHPL search page
	When I look at ACB filter options selected for default search
	Then I see that "SLI_Compliance" checkbox is checked

Scenario Outline: Verify SLI Compliance filter option is checked by default on collections pages
	Given I am on "<PageTitle>" collections page: "<PageName>"
	When I look at ACB filter options
	Then I see that "SLI_Compliance" checkbox is checked
	Examples:
	|  PageTitle		       				|  PageName	|
	|  Banned Developers					|  developers	|
	|  Decertified Products					|  products		|
	|  Inactive Certificates				|  inactive		|
	|  Products: Corrective Action Status	|  correctiveAction	|
	|  SED Information for 2015 Edition		|  sed				|	
	|  Transparency Attestation				|  transparencyAttestations	|	
