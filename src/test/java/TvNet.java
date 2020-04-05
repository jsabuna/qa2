import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TvNet {

    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//a[@class='list-article__url']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'article-headline')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath("(.//a[contains(@class, 'article-share__item--comments')])[1]");
    private final By HOMEPAGE_ARTICLE_COMMENTS = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    @Test
    public void tvNetTest() {
        String homePageCommentCount = new String();
        int articleNo = 1;
        System.setProperty("webdriver.chrome.driver", "c:/Users/Sergei/Desktop/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.elementToBeClickable(ALL_ARTICLES));

        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        if (!articles.isEmpty()) {
            WebElement homePageArticleOfInterest = articles.get(articleNo);
            String articleOfInterestText = homePageArticleOfInterest.findElement(ARTICLE_TITLE).getText().replaceAll("\\(.*\\)", "");
            articleOfInterestText = articleOfInterestText.trim();
            System.out.println(articleOfInterestText + ".");

            try {
                homePageCommentCount = homePageArticleOfInterest.findElement(HOMEPAGE_ARTICLE_COMMENTS).getText().replaceAll("[()]", "");
                System.out.println(homePageCommentCount + ".");
            } catch (Exception e) {
                System.out.println("Comments not found...Exiting code");
                System.exit(0);
            }
            homePageArticleOfInterest.click();

            WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);
            String articlePageTitleText = articlePageTitle.getText();
            System.out.println(articlePageTitleText + ".");

            WebElement articlePageComments = driver.findElement(ARTICLE_PAGE_COMMENTS);
            String articlePageCommentCount = articlePageComments.getText();
            System.out.println(articlePageCommentCount + ".");

            Assertions.assertEquals(articleOfInterestText, articlePageTitleText, "Titles are not equal");
            Assertions.assertEquals(homePageCommentCount, articlePageComments, "Comment count is not equal");

        }


    }

}
