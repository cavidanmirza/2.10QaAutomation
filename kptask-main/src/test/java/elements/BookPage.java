package elements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookPage {

    public BookPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='ts-search-by-category hidden-ipad']//following-sibling::input[1]")
    WebElement searchField;

    @FindBy(xpath = "//span[@class='cart-number']")
    WebElement basketCount;

    @FindBy(xpath = "//div[@class='products']")
    WebElement randomBook;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    WebElement addButton;

    @FindBy(css =".hidden-phone > .ts-tiny-cart-wrapper svg")
    WebElement hoverTheIcon;
    @FindBy(linkText = "Səbətə bax")
    WebElement gotoBasket;

    @FindBy(xpath = "//a[@href='https://kitabevim.az/cart/']")
    WebElement cart;

    @FindBy(css = ".woocommerce-cart-form__cart-item:nth-child(1) .plus")
    WebElement increaseButton;

    @FindBy(xpath = "//button[@name=\"update_cart\"]")
    WebElement refreshBasket;

    @FindBy(css = ".woocommerce-message")List<WebElement> basketRefreshed;

    @FindBy(linkText = "×")
    WebElement clearBasket;

    @FindBy(xpath = "//p[contains(.,'Səbətiniz hazırda boşdur.')]")
    WebElement basketIsEmpty;



    public WebElement cartIcon(){
        return cart;
    }
    public String readCsv() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/test/resources/Csv/Book1.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext()) {return sc.next().trim();}
        return sc.next().trim();
    }
    public void searchInField(WebDriver driver, String s) {
        String data = s.trim().replaceAll("[^\\x00-\\x7f]", "");;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].removeAttribute('value')", searchField);
        jse.executeScript("arguments[0].setAttribute('value', '"+data+"')", searchField);
        searchField.sendKeys(Keys.ENTER);

    }
    public String count(){
        String value = basketCount.getAttribute("innerHTML");
        return value;
    }

    public void selectRandom(WebDriver driver) throws InterruptedException {
        Random rand = new Random(); //instance of random class
        int upperbound = 8;
        int intRandom = rand.nextInt(upperbound);
        Thread.sleep(2000);
        WebElement button = randomBook.findElement(By.xpath("//following-sibling::section["+intRandom+"]//a"));
        button.click();
    }

    public void addToBasket(){
        addButton.click();
    }

    public void checkAgain(){
        String value = basketCount.getAttribute("innerHTML");
        if(value != "0"){
            System.out.println("Added Successfully!");
        }
        else{
            System.exit(0);
        }
    }
    public void setGotoBasket(WebDriver driver){
        {
            Actions builder = new Actions(driver);
            builder.moveToElement(hoverTheIcon).perform();
        }
    }

    public void goto_basket_icon(){
        gotoBasket.click();
    }

    public void increase_1(){
        increaseButton.click();
    }

    public void refresh_basket(){
        refreshBasket.click();
    }

    public void basket_refreshed(){
        {
            if(basketRefreshed.get(0).getAttribute("innerHTML").contains("Səbət yeniləndi")){
                System.out.println("OK");
            }
            else{
                System.out.println("Error");
            }
            assert(basketRefreshed.size() > 0);
        }
    }
    public void clear_basket(){
        clearBasket.click();
    }

    public void checkBasket(){
        assertThat(basketIsEmpty.getText(), is("Səbətiniz hazırda boşdur."));
    }

}
