package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private BaseFunc homePageBf;

    public HomePage(BaseFunc baseFunc) {
        //
        homePageBf = baseFunc;
    }

    public String getTitleById(int id) {
        String title = "";
        try {
            List<WebElement> titles = homePageBf.findElements(HOME_PAGE_TITLE);
            title = titles.get(id - 1).getText();
        } catch (Exception e) {
            System.out.println("Failed to get titles");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return title;
    }

    public void goToArticleById(int id) {
        List<WebElement> titles = homePageBf.findElements(HOME_PAGE_TITLE);
        homePageBf.click(titles.get(id - 1));
    }

}
