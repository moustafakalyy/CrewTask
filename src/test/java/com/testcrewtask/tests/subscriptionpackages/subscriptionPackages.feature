Feature: Subscription Packages plans' data for all countries

  Scenario Outline: Validate the Subscription Packages for all countries
    Given navigated to choose your plan page
    When user selects "<CountryName>"
    Then all subscription packages should be displayed
    And plan prices should be displayed as "<LitePlanPrice>" , "<ClassicPlanPrice>","<PremiumPlanPrice>" for Lite, Classic and Premium plans respectively
    And all plans currencies displayed as "<Currency>"
    Examples:
      | CountryName | Currency | LitePlanPrice | ClassicPlanPrice | PremiumPlanPrice |
      | Bahrain     | BHD      | 2             | 3                | 6                |
      | Saudi       | SAR      | 15            | 25               | 60               |
      | Kuwait      | KWD      | 1.2           | 2.5              | 4.8              |


