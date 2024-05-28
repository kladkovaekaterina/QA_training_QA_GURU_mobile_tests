package wikiSampleBrowserstackApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppSearchPage {

    private final SelenideElement searchScrText = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Ввод данных в поисковую строку")
    public void setSearchQuery(String value) {
        searchScrText.sendKeys(value);
    }
}