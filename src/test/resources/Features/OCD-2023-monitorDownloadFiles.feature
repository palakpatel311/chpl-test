@Regression
Feature: OCD-2023 - Monitor that download files on CHPL download resources page are correct and current
  	Tests to verify download files show correct date on filenames to check file generation didn't fail at any point.
  	
  	Scenario: At any given time, when downloaded, 2015 edition products (xml) file is up-to-date 
  	Given I am on download the CHPL resources page
  	When I download the 2015 edition products file 
  	Then the downloaded file shows chpl-2015-currentdate.xml filename
  	
  	Scenario: At any given time, when downloaded, 2014 edition products (xml) file is up-to-date
  	Given I am on download the CHPL resources page
  	When I download the 2014 edition products file 
  	Then the downloaded file shows chpl-2014-currentdate.xml filename
  	
  	Scenario: At any given time, when downloaded, 2011 edition products (xml) file is up-to-date as per schedule
  	Given I am on download the CHPL resources page
  	When I download the 2011 edition products file 
  	Then the downloaded file shows 2011-chpl-lastrun.xml filename
  	
  	Scenario: At any given time, when downloaded, 2015 edition summary (csv) file is up-to-date 
  	Given I am on download the CHPL resources page
  	When I download the 2015 edition summary file 
  	Then the downloaded file shows chpl-2015-currentdate.csv filename
  	
  	Scenario: At any given time, when downloaded, 2014 edition summary (csv) file is up-to-date 
  	Given I am on download the CHPL resources page
  	When I download the 2014 edition summary file 
  	Then the downloaded file shows chpl-2014-currentdate.csv filename
  	
  	Scenario: At any given time, when downloaded, Surveillance Activity file is up-to-date 
  	Given I am on download the CHPL resources page
  	When I download the Surveillance Activity file 
  	Then the downloaded file shows surveillance-all.csv filename
  	
  	Scenario: At any given time, when downloaded, Non-Conformities file is up-to-date 
  	Given I am on download the CHPL resources page
  	When I download the Non-Conformities file 
  	Then the downloaded file shows surveillance-with-nonconformities.csv filename
  	