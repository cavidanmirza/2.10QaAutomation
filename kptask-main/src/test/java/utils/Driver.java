package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return wd;
    }
}
