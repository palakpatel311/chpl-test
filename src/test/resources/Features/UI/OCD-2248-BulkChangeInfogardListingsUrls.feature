Feature: OCD-2248 - Regression test to test Public Test Summary Report and UCD URLs for listings		
		 
@Regression
Scenario Outline: Verify Public Test Summary Report URL exists and shows correct URL for that listing
	Given I am on listing details page of listing with ID "<CHPL_ID>"
	When I look at Additional Information 
	Then the Test Results Summary URL should be: "<URL>"
	Examples:
	|CHPL_ID|URL|
	|CHP-019344|http://connect.ul.com/rs/365-LEA-623/images/13-2392-R-0007-PRI%20V1.0%20GE%20Health%206.94.1%20PTR.pdf|	
	|CHP-019087|http://connect.ul.com/rs/365-LEA-623/images/13-2936-R-0003-PRI%20V1.0%20FairWarning%20PTR.pdf|	
	|CHP-019342|http://connect.ul.com/rs/365-LEA-623/images/13-2967-R-0012-PRA-PEPID-PTR.pdf|	
	|14.02.02.1388.A018.01.00.0.160906|http://connect.ul.com/rs/365-LEA-623/images/15-2453-R-0018-PRA-V1.0-Ebio-PTR.pdf|
	|14.02.02.2902.A003.01.01.1.160503|http://connect.ul.com/rs/365-LEA-623/images/16-2392-R-0013-PRI-GE-Healthcare.pdf|
	|14.02.02.2902.A003.02.01.1.160929|http://connect.ul.com/rs/365-LEA-623/images/16-2392-R-0028-PRI-V1.0-GE-Healthcare.pdf|
	|14.02.02.2926.A011.01.01.1.160620|http://connect.ul.com/rs/365-LEA-623/images/16-2423-R-0022-PRI%20V1.0%20Picis%20ED%20PulseCheck%20PTR.pdf|
	|14.02.02.2926.A011.02.01.1.160620|http://connect.ul.com/rs/365-LEA-623/images/16-2423-R-0023-PRI%20V1.0%20Picis%20ED%20PulseCheck%20PTR.pdf|
		
@Regression
Scenario Outline: Verify UCD URL exists and shows correct URL for that listing
	Given I am on listing details page of listing with ID "<CHPL_ID>"
	When I look at SED details 
	Then the UCD URL should be: "<URL>"
	Examples:
	|CHPL_ID|URL|
	|15.02.02.1112.A062.01.00.1.180320|http://connect.ul.com/rs/365-LEA-623/images/Arete-SED-Report.pdf|
	|15.05.02.2670.A048.01.00.1.171206|http://connect.ul.com/rs/365-LEA-623/images/ATG-EHR-10-SED.pdf|
	|15.02.02.2614.A053.01.00.1.180123|http://connect.ul.com/rs/365-LEA-623/images/TRIARQ-QSuite-Usability-Test-Report.pdf|	
		 