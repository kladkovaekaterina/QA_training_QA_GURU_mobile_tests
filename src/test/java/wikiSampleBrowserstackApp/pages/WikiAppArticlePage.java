package wikiSampleBrowserstackApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppArticlePage {

    private final SelenideElement textView = $(className("android.widget.TextView"));

    @Step("Проверка результатов открытия статьи")
    public void checkPageDidntOpenWithText(String value) {
        textView.shouldNotHave(text(value));
    }
}