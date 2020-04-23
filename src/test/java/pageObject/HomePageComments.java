package pageObject;

import org.openqa.selenium.By;

public class HomePageComments {
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class='article-title']");
    private BaseFunc commentPageBf;

    public HomePageComments(BaseFunc baseFunc) {
        //
        commentPageBf = baseFunc;
}
