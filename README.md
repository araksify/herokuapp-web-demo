# herokuapp-web-demo
Project covers test automation demo cases for http://the-internet.herokuapp.com/

Small Documentation about herokuapp-web-automation project

TOOLS AND FRAMEWORKS
1. JAVA JDK should be installed because skripting language is Java.
2. MAVEN build system (Download apache-maven). I prefer maven compared to ant,
because it is easy to set dependencies with maven pom.xml
3. I use IntelIJ IDE, I am used to it and it better works with MAVEN
4. I use TestNG framwork for Test annotations.

HOW I START THE SETUP
1. First install IntellIJ IDE, apache-maven and java jdk, if not installed
2. On IntellIj create new MAVEN project and it will automatically create project in page object model structure
3. Open pom.xml file and setup all dependencies used in project (testng, selenium server, maven compiler, firefox driver)
4. After including all dependencies go to right click on pom.xml -> maven -> Download Sources and refresh the project
5. Download chromedriver and put it in project
6. Create Common pages and pages for each screen. This is page object model pattern which allows to have reusable components
7. I created main methods in Helper class, which are used in most pages
8. With Abstract class I setup the driver and include Helper class
9. I created separate classes of each page which extend by AbstractPage. (I prefer this pattern as if screen elements are changed,
I need to change only variable name, implementation and button click are not changed)
10. I create test classes, each class includes all tests related to that page.
11. On each test class I have the following annotations:
- @BeforeMethod to setup driver include pages used
- @AfterMethod to close browser window
- @AfterClass to quit the driver and close all windows
- @Test for actual test case steps and assertion
12. Important part is testng.xml. We can have multiple xml files if we want to run test cases by groups.
In this testng.xml I included all test classes to run all together.
Also I have testng listener, which creates html report in test-output folder.
13. Final step, run testng.xml file and check reports for test results.
