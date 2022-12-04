# Page Object Model + Cucumber BDD

The purpose of this project is to clearly define the different layers of a test automation design that uses the Page Object Model pattern.

Each package represents a different purpose in the following way:

## Elements
Each class added in the elements package represents a page object, some projects also separate modules and/or components as the page object unit. In this case, our class is a Page unit and with the help of Selenium's PageFactory we can locate the elements we interact with by using the @FindBy annotation. Any methods that interact with those elements are also added in this class.

## Steps
This is the place to add your Cucumber step definitions that will match via regular expression the content of your feature files. 

## Utils
This package is to add classes of general/global utilities. Like getting the WebDriver. Some features to extend this class can be adding different viewports support, cookies management and frame changing just to name a few.

## Resources
This is the place to add your feature files and your drivers (chromedriver in this example). Remember to keep the driver up to date with the latest browser version and OS you are using, for this example the driver works for Mac.

### What is the current example

1. The driver goes to the KitabEvim website (book selling site).
2. Select a random book from main page.
3. Add this book into basket and remove.
