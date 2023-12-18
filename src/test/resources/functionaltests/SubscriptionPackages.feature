Feature: Subscription Packages plans' data for all countries

  Scenario Outline: Validate Subscription Packages' types, prices and currencies for all countries
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

  Scenario Outline: Validate that all packages includes discovery+ subscription for all countries
    Given navigated to choose your plan page
    When user selects "<CountryName>"
    Then discovery+ subscription should be included for all subscription packages

    Examples:
      | CountryName |
      | Bahrain     |
      | Saudi       |
      | Kuwait      |

  Scenario Outline: Validate free trial period for Saudi packages
    Given navigated to choose your plan page
    When user selects saudi arabia
    Then free trial periods should be displayed as "<LitePlanFreTrialPeriod>" , "<ClassicPlanFreTrialPeriod>" and "<PremiumPlanFreTrialPeriod>"
    Examples:
      | LitePlanFreTrialPeriod | ClassicPlanFreTrialPeriod | PremiumPlanFreTrialPeriod |
      | 90                     | 7                         | 7                         |


  Scenario Outline: Validate user is directed to payment method page after selecting plan
    Given navigated to choose your plan page
    When user selects "<CountryName>"
    And selects "<PlanType>"
    Then user is directed to payment method page
    And plan price should be displayed as "<PlanPrice>"
    And plan type should be displayed as   "<PlanType>"
    Examples:
      | CountryName | PlanType | PlanPrice |
      | Bahrain     | Lite     | 2.00      |
      | Bahrain     | Classic  | 3.00      |
      | Bahrain     | Premium  | 6.00      |
      | Saudi       | Lite     | 15.00     |
      | Saudi       | Classic  | 25.00     |
      | Saudi       | Premium  | 60.00     |
      | Kuwait      | Lite     | 1.20      |
      | Kuwait      | Classic  | 2.50      |
      | Kuwait      | Premium  | 4.80      |

