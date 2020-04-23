package pageObject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ArticlePage {
    private BaseFunc articlePAgeBf;
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");

    public ArticlePage(BaseFunc baseFunc) {

        articlePAgeBf = baseFunc;
    }

    public String getTitle() {
        return articlePAgeBf.findElement(TITLE).getText();

    }

}

