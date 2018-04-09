Feature: OCD-2134 - Batch update of Certification Status to 'Withdrawn by Developer'
		Batch update Certification Status to 'Withdrawn by Developer' for a set of Cerner and Intermountain Healthcare listings
		
Background: User is on search page and 'Withdrawn by Developer' filter option is checked
	Given I am on CHPL search page
	And I look at Certification Status options
	And I apply "Withdrawn by Developer" filter

@Regression
Scenario Outline: Verify that certification status is updated to 'Withdrawn by Developer' for Intermountain Healthcare listings after batch update
	When I search for a listing with CHPL ID "<CHPL_ID>"
	Then the certification status of the listing shows as "Withdrawn by Developer"
	Examples:
    |CHPL_ID|
    |CHP-024522|
    |14.07.07.1734.HEI1.03.01.1.160623|
	|CHP-022555|
	|14.03.07.1221.HEI3.02.01.1.160711|

@Acceptance
Scenario Outline: Verify that certification status is updated to 'Withdrawn by Developer' for Intermountain Healthcare listings after batch update	
	When I search for a listing with CHPL ID "<CHPL_ID>"
	Then the certification status of the listing shows as "Withdrawn by Developer"
	Examples:
    |CHPL_ID|
    |CHP-024522|
    |CHP-024519|
	|CHP-024741|
	|CHP-024742|
	|CHP-023341|
	|CHP-023343|
	|CHP-023344|
	|CHP-023345|
	|CHP-029138|
	|CHP-029141|
	|CHP-029145|
	|CHP-029146|
	|CHP-029147|
	|CHP-029143|
	|CHP-029134|
	|CHP-029148|
	|CHP-029151|
	|CHP-029152|
	|CHP-025082|
	|CHP-025083|
	|CHP-025087|
	|CHP-025088|
	|CHP-025089|
	|CHP-025090|
	|CHP-023641|
	|CHP-023643|
	|CHP-023644|
	|CHP-023645|
	|CHP-023642|
	|CHP-023646|
	|CHP-023647|
	|CHP-023648|
	|CHP-023253|
	|CHP-023254|
	|CHP-023257|
	|CHP-023258|
	|CHP-022458|
	|CHP-022459|
	|CHP-028656|
	|CHP-028657|
	|CHP-028658|
	|CHP-028659|
	|CHP-028660|
	|CHP-028661|
	|CHP-028663|
	|CHP-028664|
	|CHP-028665|
	|CHP-028667|
	|CHP-028668|
	|CHP-028669|
	|CHP-028670|
	|CHP-028671|
	|CHP-028672|
	|CHP-028673|
	|CHP-028674|
	|CHP-028675|
	|CHP-028676|
	|CHP-028677|
	|CHP-028678|
	|CHP-028679|
	|14.07.07.1734.HEI1.03.01.1.160623|
	|14.07.07.1734.HEI1.01.01.1.160623|
	|14.07.07.1734.HEA1.01.01.1.160623|
	|14.07.07.1734.HEA1.03.01.1.160623|
	|14.07.07.1734.HEA1.02.01.1.160623|
	|14.07.07.1734.HEI1.02.01.1.160623|
	
Scenario Outline: Verify that certification status is updated to 'Withdrawn by Developer' for Cerner listings after batch update
	Given I am on CHPL search page
	When I search for a listing with CHPL ID "<CHPL_ID>"
	Then the certification status of the listing shows as "Withdrawn by Developer"
	Examples:
    |CHPL_ID|
    |CHP-021411|
	|CHP-021717|
	|CHP-023122|
	|CHP-023131|
	|CHP-024156|
	|CHP-023325|
	|CHP-023330|
	|CHP-024175|
	|CHP-022560|
	|CHP-023189|
	|CHP-023197|
	|CHP-021673|
	|CHP-022090|
	|CHP-021866|
    |CHP-028580|
	|CHP-028583|
	|CHP-028693|
	|CHP-028696|
	|CHP-029203|
	|CHP-029200|
	|14.03.07.1221.HEI3.02.01.1.160711|
	|14.03.07.1221.HEA3.02.01.1.160711|
	|14.03.07.1221.HEA3.04.01.1.160711|
	|14.03.07.1221.HEI3.04.01.1.160711|
	|CHP-025191|
	|CHP-025200|
	|CHP-025395|
	|CHP-025387|
	|CHP-025464|
    |CHP-024960|
	|CHP-028470|
	|CHP-023319|
	|CHP-028466|
	|CHP-023130|
	|CHP-024153|
	|CHP-023135|
	|CHP-023327|
	|CHP-024170|
	|CHP-024703|
	|CHP-021128|
	|CHP-024709|
	|CHP-023228|
	|CHP-023230|
	|CHP-022555|
    |14.07.07.1221.POA6.02.01.1.161012|
	|14.07.07.1221.POI7.02.01.0.161012|
	|14.07.07.1221.POI7.03.01.0.161012|
	|14.07.07.1221.POA6.03.01.1.161012|
	|14.07.07.1221.POA6.04.01.1.161012|
	|14.07.07.1221.POI7.04.01.0.161012|
	|14.07.07.1221.POA6.05.01.1.161012|
	|14.07.07.1221.POI7.05.01.0.161012|
	|14.07.07.1221.POI8.06.01.0.170120|
	|14.07.07.1221.POA8.06.01.1.170120|
	|14.07.07.1221.POA8.07.01.1.170120|
	|14.07.07.1221.POI8.07.01.0.170120|
	|14.07.07.1221.POA8.08.01.1.170313|
	|14.07.07.1221.POI8.08.01.0.170313|
	|14.07.07.1221.POI8.09.01.0.170313|
    |14.03.07.1222.FIAM.99.01.1.140818|
	|15.07.07.1221.FI01.08.01.1.171117|
	|15.07.07.1221.PO05.08.01.1.171117|
	|15.07.07.1221.SO05.01.00.1.171117|
	|15.07.07.1221.SO05.01.01.1.171117|
          