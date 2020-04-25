package pageObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TitleTests {
    private BaseFunc baseFunc = new BaseFunc("delfi.lv");

    @Test
    public void titleCheck() {

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(2);
        System.out.println(homePageTitle + ".");
        homePage.goToArticleById(2);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();
        System.out.println(articlePageTitle + ".");

        HomePageComments homePageComments = new HomePageComments(baseFunc);
        homePageComments.clickOnCommentsCount();
        String commentsPageTitle = homePageComments.getCommentsPageTitle();
        System.out.println(commentsPageTitle + ".");

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Titles 1 and 2 are not equal");
        Assertions.assertEquals(articlePageTitle, commentsPageTitle, "Titles 2 and 3 are not equal");
    }
}
