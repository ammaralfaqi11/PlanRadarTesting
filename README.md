# PlanRadar Testing

Automated tests for PlanRadar's form builder, focusing on default value functionality.

## What it tests

Creates a form with a short text field that has a default value, then verifies the default value shows up correctly in the form preview.

## Running the tests

```bash
mvn clean test
```

## Tech Stack

- Java
- TestNG
- Selenium WebDriver
- SHAFT Engine
- Allure Reports
- Maven

## Project Structure

- `src/main/java/Pages/` - Page Object Model classes
- `src/test/java/Tests/` - Test classes
- `src/test/resources/testDataFiles/` - Test data (credentials, etc.)

