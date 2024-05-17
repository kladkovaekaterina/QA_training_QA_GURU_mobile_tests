package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppMainPage {

    private final SelenideElement searchWikiString = $(accessibilityId("Search Wikipedia"));

    @Step("Открытие поисковой строки")
    public void openSearchQueryString() {
        searchWikiString.click();
    }
}