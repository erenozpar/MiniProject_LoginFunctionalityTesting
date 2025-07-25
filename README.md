# Mini UI Automation Project

# Login Functionality Testing (Selenium + Java)

This project is a mini UI automation test framework designed to test the login functionality of a sample web application using **Selenium WebDriver**, **TestNG**, and **ExtentReports**. It also demonstrates **Data-Driven testing** using an external Excel file.

## Project Structure
src/main/resources/

├── LoginTestData/

src/test/java/com/practicetestautomation/

├── listeners/

│ └── ExtentListener.java

├── pages/

│ └── LoginPage.java

├── tests/

│ └── LoginTest.java

├── utils/

│ ├── Driver.java

│ ├── ExtentReportManager.java

│ ├── ScreenshotUtil.java

│ └── ExcelUtils.java

testng.xml


## Features

### Test Scenarios
This framework includes the following 5 login test scenarios:
1. **Positive Login**
2. **Negative Login - Invalid Username**
3. **Negative Login - Invalid Password**
4. **Negative Login - Empty Username**
5. **Negative Login - Empty Password**

Each test uses parameterized data from an Excel file.


### Extent Report Integration
- Automatically creates **Dynamic HTML Reports** after each test run.
- Adds test name, log status (PASS/FAIL/SKIP), and screenshots for failed tests.
- Report is generated using `ExtentSparkReporter`.

### TestNG + DataProvider
- `@DataProvider` is used to run tests with different sets of test data from an external Excel file (`LoginTestData.xlsx`).
- Test data is loaded dynamically using `ExcelUtils`.

### Screenshot on Failure
- Failed tests are automatically captured using `ScreenshotUtils`.

### Cross Browser Testing
- Browser is selected dynamically via `testng.xml` or system property (`chrome` or `firefox`).
- Managed via `Driver` utility class.

### Technologies Used
Java
Selenium WebDriver
TestNG
ExtentReports
Apache POI (for Excel reading)
Maven

### How to Run
* Clone this repository.
* Open the project in IntelliJ or Eclipse.
* Ensure all dependencies are installed via Maven.
* Modify the testng.xml as needed.
* Run LoginTest.java or testng.xml.
* View reports in /test-output/ExtentReports/.


### To-Do / Future Improvements
*-* Add PageFactory for better Page Object design.

*-* Integrate with Jenkins for CI/CD.

*-* Add logging using Log4j or SLF4J.


### Test Data
Located at: /src/test/resources/LoginTestData.xlsx

Format: username, password, expectedResult
