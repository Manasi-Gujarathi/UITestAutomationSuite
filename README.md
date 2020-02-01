# Trivago Automation test suit (Question: 3A)
The assessment consists of automating the happy flow customer journey for Trivago.

UI test Automation for Trivago
------------------------------

This is Java based automation test project covering smoke test for happy flow scenario using Selenium web-driver as a test automation tool.

**Application under test** : Trivago website (https://www.trivago.com)

**Functionality covered**: From identified test cases, I have chosen to automate following test cases,

- TC <1> Validate that user can search properties for his/her preferred location and dates, then hotel list should get displayed properly on each page. User should also navigate to next pages if present.
- TC <2> Validate that user can search hotel based on filter criteria such as price. Hotels within selected price range should get displayed.


    -	I have used BDD scenario written in acceptance test to perform automation to achieve complete coverage.
   
    -	This Maven project is configured to accept environment parameters such that it can be run on different environments on CI/CD pipeline. We just need to send environment name in the run command then given environment configurations are loaded for the test. For this assignment I have taken Prod environment which is provided. 
    
    - Maven project is attached in zip file which can be imported in any IDE
    
    - This project is configured to detect operating system and select required driver automatically. Currently windows and Unix are configured. (Please note, Unix flow is not tested due to non-availability of the said OS)
    
    - Note: Maven command to run project is mentioned below.


**Project  setup**:

--**Required tools**:

|Category                            |Tools                    |Version       |
|------------------------------------|-------------------------|--------------|
|Automation tools                    |Selenium Web driver      |3.14          |
|Programming language                |Java                     |8             |
|Build/ dependency management tool   |Maven                    |3.6.2         |
|IDE                                 |Eclipse                  |              |

--**Steps to configure test suit:**

1.	Install Java 1.8 as per the instructions mentioned in this link
2.	Install Maven 3.6.2 or above locally as per the instructions provided in this link
3.	Install/ update maven dependencies through command prompt or eclipse IDE using "mvn install" command.
4.	Run the project using one of the following methods.
    1. In command prompt on the root folder of the project run
test verify -Denv=prod -Dbrowser=chrome command.
    2. In eclipse IDE use run as-> maven test and parameter name as env and value as PROD and parameter name as browser and value chrome.
        1.	env: This property will define in which environment the script is getting executed. Current value is prod, which can be enhanced further as and when different environments are available.
        2.	Browser: Browser driver using which this script can be executed. Currently Chrome and Firefox browsers are configured. Other browsers can be supported by adding respective drivers or licensed copy of BrowserStack can be purchased to run on different platforms and browsers (out of scope of this implementation).
        3.	Other properties can be added as per further requirements and complexity.
5.	This should run the project and generate reports using Cucumber

			

**Reports location:**		*/Trivago-UIAutomationSuite/target/cucumber-html-reports/overview-features.html*

Please Note:These reports can be further enhanced to desired level but I have kept this as default for this assignment.
