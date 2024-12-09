
Feature: Purchase various options

  @purchase
  Scenario Outline: purchase options
    Given Login setting
    When Input item <code> in search module
    And Click first item and enter the detail page
    And Click first options and click purchase button
    Then Success enter the purchase page

    Examples:
      | code |
      | "2043687951" |
      | "2044625886" |
