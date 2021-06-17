# OrbitzFlightAutomation
This project is attempt to automate fraction of **orbitz.com**

Following technologies are used in this project to accomplish the give task:

1. **Java 8**
2. **Selenium WebDriver**
3. **Cucumber-Gherkin**
4. **JUnit**
5. **WebDriverManager/Bonigarcia**

###Structure of this Project

+ **pages** Package
    - In this package we keep our pages where we apply **Page Object Model** and **PageFactory Model** 
    - We  stay true to OOP principle and apply **encapsulation** to our WebElements to restrict to access to them
    - We  **create custom methods** and private WebElements inside them instead of using them on stepdefinitions and try to keep the code clean by doing so.
    

+ **runners** Package
    - We have our CukerRunner and FailedTestRunner. For bigger automation framework there would be SmokeRunner and RegressionRunner to trigger them using Maven Commands
    - By using **@RunWith** and **@CucumberOptions** annotations we configure our runner classes
    

+ **stepdefinitions** Package
    - We applied our step definitions in this package. 
    - We have our Hooks class which includes **@Before** and **@After** methods here to be executed before any other step definition.


+ **utilities** Package
    - We have our **BrowserUtil** , **ConfigurationReader** and **Driver** classes in this package.
    - **BrowserUtil** where we keep our browser utility methods. This is much bigger in real environment with lots of useful utility methods.
    - **ConfigurationReader** allows us to **read our properties file** which we keep our test data and saves us from hardcoding 
    - **Driver** class where we initialize our driver to be used and where **we are able to create multi-browser options** for our testing purposes.
  

+ **resources** Directory
    - **Resources** directory where we keep our feature files which we write using Gherkin language.
    - There can be different kind of resources in here in real environment.


+ **pom.xml**
    - pom -> **Project Object Model** is xml file where we keep our dependencies and other configuration details.
    - **pom.xml** is **Brain of our Project**.
    

+ **configurations.properties**
    - This file where we keep our **test data or credentials** that we often use and saves us from hardcoding.
    
  

###How to run

- We can run it manually by running CukesRunner class. For failed test we can FailedTestRunner class.
- We can run it using Maven command on terminal or on Jenkins by using mvn verify command with the help of surefire plugin.
- We applied parallel execution by adding configuration to our surefire plugin in our pom.xml file

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <parallel>methods</parallel>
                    <threadCount>4</threadCount>
                    <includes>
                        <include>**/*Runner*.java</include>
                    </includes>
                </configuration>
            </plugin>

