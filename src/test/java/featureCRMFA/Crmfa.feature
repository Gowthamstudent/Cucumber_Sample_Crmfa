Feature: Validating Website

Scenario: Verify website is working

When user enter username and password
|username|password|
|DemoSalesManager|crmsfa|
And verify the title page
And enter to main Lead page
Then user mainpage and enter in create lead page
And user fill company name
And user exit browser








