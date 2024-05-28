package wikiGithubApp.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class PageResultComponent {

    private final SelenideElement
            textView = $(id("org.wikipedia.alpha:id/primaryTextView")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    public void checkPrimaryText(String value) {
        textView.shouldHave(text(value));
    }

    public void checkSkipButtonVisibility() {
        skipButton.shouldBe(visible);
    }

    public void checkIndicatorVisibility(SelenideElement indicator) {
        indicator.shouldBe(visible);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}