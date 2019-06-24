Feature:
  Scenario: Find image on page
    When I navigate to "https://www.google.com/"
    Then I verify that main image matches "test.jpg" image
