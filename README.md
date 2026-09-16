# Cucumber_Hybrid_POM_TestNG

Selenium BDD automation framework using Cucumber (Gherkin), Page Object Model (POM) and TestNG/JUnit runners.

## Project structure
- src/main/java: Page objects, utilities and factory classes
- src/test/java: Cucumber step definitions, runners and hooks- src/test/resources: feature files and test data (Excel, properties)
## Key components- DriverFactory: manages WebDriver instances per thread using ThreadLocal for parallel runs.- Pages: LoginPage, HomePage, ContactUsPage implement page behaviors and locators.- ExcelReader: utility to read test data from Excel into List<Map<String,String>>.- ConfigReader: loads test configuration from `src/test/resources/config/config.properties`.- ApplicationHooks: Cucumber @Before and @After hooks to initialize and quit browser and capture screenshots on failure.
## How to run- Using TestNG (parallel): `mvn test` (configured via testngRunner)- Using JUnit: run TestRunner from IDE or `mvn -Dtest=runner.TestRunner test`## Notes and recommendations- Avoid hard-coded URLs and credentials in code; use config.properties and test data files.- Replace System.out.println with a logger (slf4j) for consistent test output.- Consider adding wait helpers in ElementUtil and central constants in util.Constants.- The hooks were adjusted so screenshots are taken before the driver quits to ensure attachments are available in reports.