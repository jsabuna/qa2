
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SecondHomework {

    //private final By ALL_ARTICLES = By.xpath("(.//h1[@class])[contains(@class,'text-size') and (substring(@class,11,2)>=15)]");
    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class='article-title']");

    @Test
    public void DelfiSecondTest() {
        int articleNumber = 2;
        System.setProperty("webdriver.chrome.driver", "c:/Users/Sergei/Desktop/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://delfi.lv");

        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        if (articles.get(articleNumber - 1).getText().length() != 0) {
            WebElement articleOfInterest = articles.get(articleNumber - 1);
            System.out.println(1 + ": " + articleOfInterest.getText()+ ".");

            String homePageArticleofInterest = articleOfInterest.getText();
            articleOfInterest.click();
            WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);
            System.out.println(2 + ": " + articlePageTitle.getText().replaceAll("[^0-9()]]","") + ".");

            String articlePageTitleText = articlePageTitle.getText().replaceAll("[^0-9()]]","");
            //WebElement commentsPageLink = driver.findElement(COMMENTS_COUNT);
            try{
                WebElement commentsPageLink = driver.findElement(COMMENTS_COUNT);
                commentsPageLink.click();
            }
            catch (Exception e){
                System.out.println("Comments not found...Exiting code");
                System.exit(0);
            }

            WebElement commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE);
            String commentsPageTitleText = commentsPageTitle.getText();
            System.out.println(3 + ": " + commentsPageTitle.getText() + ".");

           Assertions.assertEquals(homePageArticleofInterest, articlePageTitleText, "Titles are not equal");
           Assertions.assertEquals(homePageArticleofInterest, commentsPageTitleText, "Titles are not equal");

        }

    }
}
