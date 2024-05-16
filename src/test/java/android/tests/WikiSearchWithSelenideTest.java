package android.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WikiAppPage;

public class WikiSearchWithSelenideTest extends TestBase {

    WikiAppPage wikiAppPage = new WikiAppPage();

    @Test
    @DisplayName("Проверка успешного поиска в приложении")
    void successfulSearchTest() {
        wikiAppPage.openSearchQueryString()
                   .setSearchQuery("Appium")
                   .checkResultPos();
    }

    @Test
    @DisplayName("Проверка неуспешного открытия статьи в приложении")
    //статья не открывается - нормальное поведение стандартного приложения bs
    void openArticleTest() {
        wikiAppPage.openSearchQueryString()
                   .setSearchQuery("Java")
                   .openSearchedArticle("Java (programming language)")
                   .checkPageDidntOpenWithText("Object-oriented programming language");
    }
}