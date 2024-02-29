Feature: Display Bookshelves

  Scenario: Search Bookshelves
    Given Locate searchbox and search bookshelves
  	When close the add pop-up
    And Select the category as Kids
    And Set the price range
    And Select high to low 
    And Retrive the first three product data
    And Print the values in excel
    And Scroll to top
    And Click the logo btn
    And Hover on living header
    And Retrive the sub headers in living header
    And Print the data in excel
    And Click on gift card
    And Scroll and click birthday
    And Select the amount and date
    And Click ok btn
    And Fill the to data
    And Fill the from data     
    