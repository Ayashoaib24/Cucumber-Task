Feature: stc

  Scenario Outline: Validate the Subscription Packages – Type & Price and Currency for all Countries with Java
    Given user navigates to stctv.com search screen2
    When I click on the select country button2
    And country dialog appear2
    And select "<country>" from the dialog2
    Then validate currency and plans for every2 "<country>"

    Examples:
      | country |
      | sa      |
      | kw      |
      | bh      |
