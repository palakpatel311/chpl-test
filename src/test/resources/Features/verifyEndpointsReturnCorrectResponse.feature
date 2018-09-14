Feature: Verify endpoints return correct response 
         OCD-2398- Verify the "basic information" product endpoint reports correct addl s/w code in CHPL ID
         
Scenario Outline: Test CP call
When I send request for product details using basic information product endpoint with "<DB_ID>" then I should get correct "<CHPL_ID>" in response
Examples:
         |DB_ID|CHPL_ID|
         |8252|15.04.04.2945.Ligh.21.00.1.161229| 
             