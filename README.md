<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

<h1>Swag Labs Test Automation Framework</h1>

<p>This project is a <strong>Test Automation Framework</strong> designed to automate the testing of the <strong>Swag Labs eCommerce website</strong>. The framework is built using <strong>Selenium WebDriver</strong> with <strong>Java</strong>, following the <strong>Page Object Model (POM)</strong> design pattern. <strong>TestNG</strong> is used as the testing framework, and <strong>ExtentReports</strong> is integrated for generating detailed test reports. The framework is managed through <strong>GitLab</strong> for version control, and <strong>Maven</strong> is used for dependency management and build automation.</p>

<h2>Screen Record of Tests Running </h2>
<p>The screen recording showcases the execution of test cases across multiple browsers, including Chrome, Firefox. The recording demonstrates that all test cases have successfully passed, ensuring consistent functionality and reliability of the Swag Labs eCommerce platform across different environments.</p>

https://github.com/user-attachments/assets/6390d6df-56fc-4289-934a-f2df7e4227e8

<h2>Extent Report of Tests Running</h2>
<p>This report provides a detailed summary of all the test cases executed, including pass/fail status, test duration, and additional logs. The ExtentReport offers a visually rich interface to review test execution results, enhancing transparency and making debugging more efficient. You can view the latest test summary by accessing the report.</p>

![Extent Report](https://github.com/user-attachments/assets/ace6f597-1359-40c2-a53c-3994c6d0c007)
![Extent Report summary](https://github.com/user-attachments/assets/942604a7-606f-4d1d-a0aa-dbf62c5f1a6c)

<hr>

<h2>Table of Contents</h2>
<ol>
    <li><a href="#project-structure">Project Structure</a></li>
    <li><a href="#technologies-used">Technologies Used</a></li>
    <li><a href="#pre-requisites">Pre-requisites</a></li>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#execution">Execution</a></li>
    <li><a href="#test-report">Test Report</a></li>
    <li><a href="#gitlab-integration">GitLab Integration</a></li>
    <li><a href="#adding-new-tests">Adding New Tests</a></li>
    <li><a href="#contributing">Contributing</a></li>
</ol>

<hr>

<h2 id="project-structure">Project Structure</h2>

<p>The framework follows a modular and scalable structure:</p>

<pre>
src/
│
├── main/
│   ├── java/
│   │   ├── base/                     # Base classes for test setup/teardown
│   │   ├── Locators/                 # Locators for web elements
│   │   ├── page objects/             # Page Object classes
│   │   ├── test/                     # Test-related classes
│   │   └── Utils/                    # Utility classes (helpers, WebDriver setup, etc.)
│
├── resources/                        # Test data, configuration files
├── reports/                          # ExtentReports output
├── pom.xml                           # Maven configuration
└── testng.xml                        # TestNG configuration file
</pre>

<hr>

<h2 id="technologies-used">Technologies Used</h2>
<ul>
    <li><strong>Selenium WebDriver</strong>: Automates browser interactions for UI testing.</li>
    <li><strong>Java</strong>: Core programming language for test scripting.</li>
    <li><strong>TestNG</strong>: Testing framework for test execution and reporting.</li>
    <li><strong>Maven</strong>: Build automation tool used for managing project dependencies and running tests.</li>
    <li><strong>ExtentReports</strong>: Used for generating rich, interactive test reports.</li>
    <li><strong>Page Object Model (POM)</strong>: Design pattern for better maintainability and readability of code.</li>
    <li><strong>GitLab</strong>: Version control for source code and continuous integration.</li>
</ul>

<hr>

<h2 id="pre-requisites">Pre-requisites</h2>
<ol>
    <li><strong>Java</strong> (version 8 or higher)</li>
    <li><strong>Maven</strong> (version 3.6+)</li>
    <li><strong>Git</strong> (for cloning the repository)</li>
    <li><strong>Selenium WebDriver</strong> (managed by Maven)</li>
    <li><strong>TestNG</strong> (included as a Maven dependency)</li>
    <li><strong>Browser Drivers</strong> (ChromeDriver, FirefoxDriver, etc.)</li>
</ol>

<hr>

<h2 id="installation">Installation</h2>
<ol>
    <li><strong>Clone the repository:</strong></li>
    <pre><code>git clone https:https://github.com/SanjanaVarma12/swag-labs-test-automation.git</code></pre>

    <li><strong>Navigate to the project directory:</strong></li>
    <pre><code>cd swag-labs-test-automation</code></pre>

    <li><strong>Install dependencies using Maven:</strong></li>
    <pre><code>mvn clean install</code></pre>

    <li><strong>Configure browser drivers:</strong> Make sure the necessary browser drivers (e.g., ChromeDriver) are set up. You can either place the drivers in the system PATH or configure them in the <code>BaseTest</code> class.</li>
</ol>

<hr>

<h2 id="execution">Execution</h2>
<h3>Running Tests from Command Line</h3>
<p>You can run the tests using <strong>Maven</strong> with the following command:</p>
<pre><code>mvn test</code></pre>

<h3>Running Tests via TestNG</h3>
<p>You can also run tests using <strong>TestNG</strong>:</p>
<pre><code>mvn test -DsuiteXmlFile=testng.xml</code></pre>

<p>The <code>testng.xml</code> file allows you to specify which tests to run, their order, and more.</p>

<hr>

<h2 id="test-report">Test Report</h2>
<p><strong>ExtentReports</strong> generates detailed HTML reports after each test run. The reports are saved in the <code>reports/</code> directory.</p>

<ul>
    <li>Open the <code>ExtentReport.html</code> file in your browser to view test results.</li>
    <li>The report includes:
        <ul>
            <li>Test case status (Pass/Fail/Skip)</li>
            <li>Screenshots of failed tests</li>
            <li>Execution time details</li>
        </ul>
    </li>
</ul>

<hr>

<h2 id="gitlab-integration">GitLab Integration</h2>
<p>The project integrates with <strong>GitLab CI/CD</strong> for automated test execution.</p>

<ol>
    <li><strong>GitLab CI Pipeline:</strong> The <code>.gitlab-ci.yml</code> file defines the pipeline for running tests on every push to the repository.</li>
    <li><strong>Continuous Integration:</strong>
        <ul>
            <li>The pipeline is triggered upon changes to the repository.</li>
            <li>Tests are executed on the GitLab CI runners.</li>
            <li>Reports can be accessed via the GitLab pipeline results.</li>
        </ul>
    </li>
</ol>

<hr>

<h2 id="adding-new-tests">Adding New Tests</h2>

<ol>
    <li><strong>Create Page Objects:</strong>
        <ul>
            <li>Add new page classes in the <code>PageObjects.java</code> package.</li>
            <li>Follow the POM structure by defining elements and actions related to each page.</li>
        </ul>
    </li>

    <li><strong>Create Test Cases:</strong>
        <ul>
            <li>Write test cases in the <code>tests.java</code> package.</li>
            <li>Maintain consistency with the existing test class structure.</li>
        </ul>
    </li>

    <li><strong>Update TestNG:</strong> Add new tests to the <code>testng.xml</code> file for inclusion in test execution.</li>
    <li><strong>Run Tests:</strong> Execute tests using the steps mentioned in the <a href="#execution">Execution</a> section.</li>
</ol>

<hr>

<h2 id="contributing">Contributing</h2>
<p>To contribute:</p>

<ol>
    <li>Fork the repository on GitLab.</li>
    <li>Create a feature branch.</li>
    <li>Commit your changes and push the branch.</li>
    <li>Submit a merge request for review.</li>
</ol>

<p>Please adhere to the existing code structure and coding standards.</p>

<hr>


</body>
</html>
