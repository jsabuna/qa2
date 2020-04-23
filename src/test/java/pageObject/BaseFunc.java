package pageObject;

import io.cucumber.java.sl.Ter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private  WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc(String url) {
        System.setProperty("webdriver.chrome.driver", "c:/Users/Sergei/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 60);

        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> findElements (By locator) {
        //
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void click(WebElement webElement) {
       // wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }
}
