# CODING
FEATURE DESCRIPTION FOR AUTOMATION:

[Clicking on the "LOGIN" button of www.shipt.com page.
Takes to login page.
With EMAIL (VALID) AND PASSWORD (VALID).Clicking on the "log in" button.
Then the home page of user comes.
Going to the "ACCOUNT" tab and clicking on it
Takes to "membership"," plan" page .On the same page click the "log out" button.
Again it takes to login page.]

BASE APP.JAVA contains the whole coding.


TOOLS REQUIRED FOR AUTOMATION:  ECLIPSE, SELENIUM , TEST NG from ECLIPSE MARKET PLACE INSTALLED
Browser used is CHROME.
The code can be ran on other browser as well.
All dependencies have been added in pom.xml
Dependencies are of selenium java,apache poi, test ng.
DATA DRIVEN FRAMEWORK created.
Excel file are in format of xlsx
EMAIL AND PASSWORD read from "EXCEL INPUT FILE" sheet which serves as an input.
"FINAL OUTPUT " displays result coloumn as passed and when other data are pulled it does not show passed since they are invalid input as a result READ DATA() becomes failure.
With valid credentials " READ DATA" test ran successfully and as a result it writes "PASSED" on excel output file
I have attached the console output files" .PNG " files for different scenarios respectively 
Code has ran successfully.
