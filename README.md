
#Amamzon App - Appium - Cuucmber with TestNG POM-framework #


Highlights:
This is a sample POM framework to automate Amazon Android app


#Technology stack:
- Appium (mobile testing)
- Selenium (web app testing) [Used as a wrapper for appium]
- TestNG (test runner)
- Cucumber (reporting)
- Java (Programming Language)
- Maven (Dependency Manager)
- Page Object Model
- Apache POI library

** Prerequisites** 

- Appium configuration should be up and running 
- Android Simulator (Android Studio must be installed in the system)

** Steps to run the code ** 

There are 3 ways to run the code:

1. Go to Project directory in cmd/terminal and run the command "mvn clean verify".
2. Import the project as maven projectin eclipse. Go to the TestRunner.java class and Run as Java application.
3. Since there is only one feature file is avalable, then go to the "AmazonScenario.feature" feature file in eclipse IDE. Right click and select as Run as -> Cucumber Feature.
4. Also, through testng.xml file.


** Notes **
- Used DataProvider annotation to read the data from Excel which is located under TestData folder as InputData.xlsx
- A property file has been placed under 'Configuration' folder where all the desired capabilities are placed
- After running the code, reports can be found under the target folder. Go inside "cucumber-html-reports" folder, then click "overview-features.html'
 It will display the passed and failed report. (Note that report may not be generated if configuration has not been done property)
 
 
 ** Testcase Description: **
 - Login to the Amazon app with valid credentials
 - Through Hamburger menu, go to the Settings -> Countries and languages -> Select Australia
 - Search by entering the text '65-inch TV' in search bar.
 - Select any random item dynamically and go to Product Details Page
 - Store the name and description of the product. (Stored data will be dynamic)
 - Add the product to the cart
 - Go to checkout page and compare the details displayed in CHeckout page to the stored details of the product in Product Details page



