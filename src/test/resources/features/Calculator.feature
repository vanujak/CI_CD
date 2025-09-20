Feature: Basic calculator operations

  Background:
    Given a fresh calculator

  Scenario: Addition
    When I add 2 and 3
    Then the result should be 5.0

  Scenario: Subtraction
    When I subtract 7 minus 4
    Then the result should be 3.0

  Scenario: Division
    When I divide 8 by 2
    Then the result should be 4.0

  Scenario: Division by zero
    When I divide 10 by 0
    Then I should see an error "Cannot divide by zero"
