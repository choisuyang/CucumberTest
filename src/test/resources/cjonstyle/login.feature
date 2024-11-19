Feature: Is it login success?
  Check Login Success.

  Scenario: Check Login Success
    Given Input text ID and PW
    When Click Login Button
    Then Move home page and check text "logout"

