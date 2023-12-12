Feature: As a actiTIME user , I should be able to login to actiTIME application

  @Sanity
  Scenario Outline: User should login to the application with valid credentials
    Given the application "actiTime_URL"
    When the user enters the credentials "<userName>","<passWord>"
    Then the user should be navigate to the user specific homepage
    Examples:
      | userName   | passWord       |
      | valid_user | valid_password |

  @Sanity
  Scenario Outline: User should login to the application with Invalid credentials
    Given the application "actiTime_URL"
    When the user enters the credentials "<userName>","<passWord>"
    Then the user will see error message "Username or Password is invalid. Please try again."
    Examples:
      | userName     | passWord         |
      | inValid_user | inValid_password |

