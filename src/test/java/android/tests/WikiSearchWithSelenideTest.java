package android.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WikiAppArticlePage;
import pages.WikiAppMainPage;
import pages.WikiAppSearchPage;
import pages.WikiAppSearchResultPage;

public class WikiSearchWithSelenideTest extends TestBase {

    WikiAppMainPage wikiAppMainPage = new WikiAppMainPage();
    WikiAppSearchPage wikiAppSearchPage = new WikiAppSearchPage();
    WikiAppSearchResultPage wikiAppSearchResultPage = new WikiAppSearchResultPage();
    WikiAppArticlePage wikiAppArticlePage = new WikiAppArticlePage();

    @Test
    @DisplayName("Проверка успешного поиска в приложении")
    void successfulSearchTest() {
        wikiAppMainPage.openSearchQueryString();
        wikiAppSearchPage.setSearchQuery("Appium");
        wikiAppSearchResultPage.checkResultPos();
    }

    @Test
    @DisplayName("Проверка неуспешного открытия статьи в приложении")
    //статья не открывается - нормальное поведение стандартного приложения bs
    void openArticleTest() {
        wikiAppMainPage.openSearchQueryString();
        wikiAppSearchPage.setSearchQuery("Java");
        wikiAppSearchResultPage.openSearchedArticle("Java (programming language)");
        wikiAppArticlePage.checkPageDidntOpenWithText("Object-oriented programming language");
    }
}