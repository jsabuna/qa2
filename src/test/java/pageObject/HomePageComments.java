package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageComments {
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class='article-title']");
    private BaseFunc commentPageBf;

    public HomePageComments(BaseFunc baseFunc) {
        //
        commentPageBf = baseFunc;

    }

    public void clickOnCommentsCount() {
        try {
            WebElement commentsCount = commentPageBf.findElement(COMMENTS_COUNT);
            commentPageBf.click(commentsCount);
        } catch (Exception e) {
            System.out.println("Failed to get comments element");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public String getCommentsPageTitle() {
        WebElement commentsPageTitle = commentPageBf.findElement(COMMENTS_PAGE_TITLE);
        return commentsPageTitle.getText();
    }
}
