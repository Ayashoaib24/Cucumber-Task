Feature: stc

  Scenario Outline: Validate the Subscription Packages – Type & Price and Currency for all Countries
    Given user navigates to stctv.com search screen
    When I click on the select country button
    And country dialog appear
    And select "<country>" from the dialog
    Then validate "<currency>" and plans "<type-lite>","<type-classic>" and "<type-premium>" for every country

    Examples:
      | country | currency | type-lite | type-classic | type-premium |
      | sa      | SAR      | 15        | 25           | 60           |
      | kw      | KWD      | 1.2       | 2.5          | 4.8          |
      | bh      | BHD      | 2         | 3            | 6            |
