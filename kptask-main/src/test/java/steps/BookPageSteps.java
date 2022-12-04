package steps;

import elements.BookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import java.io.FileNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class BookPageSteps {
    static final Logger logger = LogManager.getLogger(BookPageSteps.class.getName());
    protected WebDriver wd = Driver.getDriver();
    BookPage hp = new BookPage(wd);


    @Given("Go to book site")

    public void the_user_visits_the_El_Tiempo_website() {
        wd.get("https://kitabevim.az/");
        DOMConfigurator.configure("log4j.xml");
        logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
        logger.info("TEST Has Started");

    }

    @When("Check mainpage is open")
    public void check_mainpage_is_open(){
        if(wd.getTitle() != null && wd.getTitle().contains("Kitabevim.az")){
            logger.info("Web page is opened");
        }
        else{
            System.exit(0);
        }
    }

    @Then("Read data from csv")
    public void read_data_from_csv() throws FileNotFoundException {
      logger.info("CSV Readed!");
      String data =  hp.readCsv();
    }
    @Then("Insert Roman to search field")
    public void the_user_clicks_on_the_Colombia_option() throws FileNotFoundException {
        logger.info("Roman searched!");
        hp.searchInField(wd, hp.readCsv());
    }

    @And("Get text from basket count")
    public void get_text_from_basket_count() {
        hp.count();
        logger.info("Basket Count readed");
    }

    @And("Select random result")
    public void select_random_result() throws InterruptedException {
        hp.selectRandom(wd);
        logger.info("Random book is selected");
    }

    @And("Add to basket")
    public void add_to_basket(){
        hp.addToBasket();
        logger.info("The book added to basket");
    }
    @And("Check basket count again")
    public void check_basket_count_again(){
        hp.checkAgain();
        logger.info("Basket Count checked again");
    }

    @And("Hover the basket icon")
    public void go_to_basket() throws InterruptedException {
        hp.setGotoBasket(wd);
        logger.info("Hovering to basket icon");
    }

    @And("Goto Basket")
    public void goto_basket(){
        hp.goto_basket_icon();
        logger.info("Going to basket");
    }

    @And("The amount of the product is increased by “1”")
    public void increase_by_1(){
        hp.increase_1();
        logger.info("Increasing book amount");
    }

    @And("Click the refresh basket button")
    public void click_refresh_button(){
        hp.refresh_basket();
        logger.info("Refreshing the basket");
    }

    @And("It is checked whether the message \"Səbət yeniləndi\" is displayed")
    public  void it_is_checked(){
        hp.basket_refreshed();
        logger.info("Checking basket refresh");
    }

    @And("Clear Basket")
    public void clearbaket(){
        hp.clear_basket();
        logger.info("Removing elements from basket");
    }

    @Then("Verify basket is empty")
    public void verify_basket_is_empty(){
        hp.checkBasket();
        logger.info("Checking basket is empty!");
    }
    @After
    public void afterScenario() {
        wd.close();
    }

}
