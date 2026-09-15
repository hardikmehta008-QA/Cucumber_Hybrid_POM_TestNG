Feature: Contact Us Feature

  Scenario Outline: Contact Us scenario with different set of data
    Given user navigates to contact us page
    When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on submit button
    And user accept the alert "Press OK to proceed!"
    Then it shows a successful message "Success! Your details have been submitted successfully."
    Examples:
      |SheetName|RowNumber|
      |contactus|0|
      |contactus|1|