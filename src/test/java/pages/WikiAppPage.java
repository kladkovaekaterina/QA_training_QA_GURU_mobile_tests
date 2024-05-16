package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppPage {

    private final SelenideElement searchWikiString = $(accessibilityId("Search Wikipedia")),
                                  searchScrText = $(id("org.wikipedia.alpha:id/search_src_text")),
                                  textView = $(className("android.widget.TextView"));
    private final ElementsCollection titlesCollection = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Открытие поисковой строки")
    public WikiAppPage openSearchQueryString() {
        searchWikiString.click();

        return this;
    }

    @Step("Ввод данных в поисковую строку")
    public WikiAppPage setSearchQuery(String value) {
        searchScrText.sendKeys(value);

        return this;
    }

    @Step("Открытие статьи")
    public WikiAppPage openSearchedArticle(String value) {
        titlesCollection.find(text(value)).click();

        return this;
    }

    @Step("Проверка результатов поиска")
    public void checkResultPos() {
        titlesCollection.shouldHave(sizeGreaterThan(0));
    }

    @Step("Проверка результатов открытия статьи")
    public void checkPageDidntOpenWithText(String value) {
        textView.shouldNotHave(text(value));
    }
}