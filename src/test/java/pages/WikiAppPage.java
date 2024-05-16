package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppPage {

    private final SelenideElement searchWikiString = $(accessibilityId("Search Wikipedia")),
                                  searchScrText = $(id("org.wikipedia.alpha:id/search_src_text")),
                                  textView = $(className("android.widget.TextView"));
    private final ElementsCollection titlesCollection = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public WikiAppPage openSearchQueryString() {
        searchWikiString.click();

        return this;
    }

    public WikiAppPage setSearchQuery(String value) {
        searchScrText.sendKeys(value);

        return this;
    }

    public WikiAppPage openSearchedArticle(String value) {
        titlesCollection.find(text(value)).click();

        return this;
    }

    public void checkResultPos() {
        titlesCollection.shouldHave(sizeGreaterThan(0));
    }

    public void checkPageDidntOpenWithText(String value) {
        textView.shouldNotHave(text(value));
    }
}