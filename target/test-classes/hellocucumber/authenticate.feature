Feature: Task test automation
    Scenario: Basic authentication
        Given I authenticate at "https://postman-echo.com/basic-auth" using username "postman" and password "password"
        Then I get "authenticated:true" response