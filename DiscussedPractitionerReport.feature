@PharmacistPortal @VerifyDiscussedPractitionerReport
Feature: Verify Discussed Practitioner Report Feature

  @Setup @Regression @Smoke
  Scenario Outline: SETUP: Launch Browser and go to application
    Given User launched "chrome"
    Then User go to application "$pharmacist_portal_url"
    When User login with "<username>" and "<password>"
    And Verify Login message: "<message>"
    Examples:
      | username                                            | password                                            | message |
      | $patient-discussedPractitionerReport.user1.username | $patient-discussedPractitionerReport.user1.password | success |

  @Regression @Smoke @campaignsTab
  Scenario Outline: verify_discussed_practitioner_report_in_campaigns_tab
    Given User select organization: "<Organization>"
    When Click on campaigns tab
    And User select campaigns date as: "<CampaignDate>"
    And User select campaign run date as: "<RunDate>"
    And User click on the log icon in the table for the prescriber: "<Practitioner>"
    And Wait to page load
    And Verify text on screen "What was discussed from this report ? (required)"
    Then Remove "Discussed Practitioner Report" from Steps Performed ComboBox
    And Wait to page load
    And Verify text on screen "This section is intentionally blank"
    Then Select "Confirmed Fax Received" from Steps Performed ComboBox
    And Wait to page load
    And Verify text on screen "This section is intentionally blank"
    Examples:
      | Organization                         | CampaignDate    | RunDate    | Practitioner                                       |
      | Admin Portal Test Patient Org DEV    | Test Campaign 1 | 05/11/2024 | Bichael TestJordan_specialist_in_nephrologist_0001 |


  @Regression @Smoke @practitionerTab
  Scenario Outline: verify_discussed_practitioner_report_in_practitioners_tab
    Given User select organization: "<Organization>"
    When Click on Practitioners Tab
    And User search practitioner by npi: "<NPI>"
    And Verify the User able select the campaigns value as: "Test Campaign 1"
    And Verify "Report History" table displayed in practitioner tab
    And User click on the log icon in the Report History table of row : "1"
    And Wait to page load
    And Verify text on screen "What was discussed from this report ? (required)"
    Then Remove "Discussed Practitioner Report" from Steps Performed ComboBox
    And Wait to page load
    And Verify text on screen "This section is intentionally blank"
    Then Select "Other Batch Follow-up" from Steps Performed ComboBox
    And Wait to page load
    And Verify text on screen "This section is intentionally blank"
    Examples:
      | Organization                         | NPI        |
      | Admin Portal Test Patient Org DEV    | 1750393690 |



  @Setup @Regression @Smoke
  Scenario: SETUP: Logout and Close Browser
    When User logout from the application
    Then User close browser