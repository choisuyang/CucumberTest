@purchase
Feature: Purchase various options
  Scenario: purchase options
    Given Login setting
    When Input item number in search module
    And Click first item and enter the detail page
    And Click first options and click purchase button
    Then Success enter the purchase page

