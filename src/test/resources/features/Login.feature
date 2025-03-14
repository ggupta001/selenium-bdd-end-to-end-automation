Feature: Login Test
      Background:
        Given User is on Registration page
  Scenario: Validating Login
  Given User can see Customer login page
    When user enter username and password
    Then user can able to logged in