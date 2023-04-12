@E2E-antidote-price-plan

  Feature: End to End example on antidote pricing plan

    Scenario: User go to antidotehealth Website and press pricing button
      When I go to AntidoteHealth website
      And I navigate to pricing

    Scenario: User randomly selects a Service plan
      Then I select a service randomly and toggle view details button
      Then I click the select button
      And I Assert the plans features
