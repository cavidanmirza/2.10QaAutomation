@books
Feature: Add to Random book to basket
Scenario: Random book to basket
  Given Go to book site
  When Check mainpage is open
  Then Read data from csv
  Then Insert Roman to search field
  And Get text from basket count
  And Select random result
  And Add to basket
  And Check basket count again
  And Hover the basket icon
  And Goto Basket
  And The amount of the product is increased by “1”
  And Click the refresh basket button
  And It is checked whether the message "Səbət yeniləndi" is displayed
  And Clear Basket
  Then Verify basket is empty