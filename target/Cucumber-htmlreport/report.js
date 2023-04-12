$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AntidoteHealth_assignment.feature");
formatter.feature({
  "line": 3,
  "name": "End to End example on antidote pricing plan",
  "description": "",
  "id": "end-to-end-example-on-antidote-pricing-plan",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@E2E-antidote-price-plan"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "User go to antidotehealth Website and press pricing button",
  "description": "",
  "id": "end-to-end-example-on-antidote-pricing-plan;user-go-to-antidotehealth-website-and-press-pricing-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I go to AntidoteHealth website",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I navigate to pricing",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.I_go_to_AntidoteHealth_website()"
});
formatter.result({
  "duration": 16271691583,
  "status": "passed"
});
formatter.match({
  "location": "Steps.I_navigate_to_pricing()"
});
formatter.result({
  "duration": 3136281666,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "User randomly selects a Service plan",
  "description": "",
  "id": "end-to-end-example-on-antidote-pricing-plan;user-randomly-selects-a-service-plan",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I select a service randomly and toggle view details button",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I click the select button",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I Assert the plans features",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.I_select_a_service_randomly_and_toggle_view_details_button()"
});
formatter.result({
  "duration": 20554938875,
  "status": "passed"
});
formatter.match({
  "location": "Steps.I_click_the_select_button()"
});
formatter.result({
  "duration": 4491473500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.I_Assert_the_plans_features()"
});
