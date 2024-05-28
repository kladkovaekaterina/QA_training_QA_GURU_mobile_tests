package wikiGithubApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import wikiGithubApp.pages.components.PageResultComponent;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen4Page {

    PageResultComponent pageResultComponent = new PageResultComponent();

    private final SelenideElement
            page4Indicator = $(accessibilityId("Page 4 of 4")),
            getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверка результатов открытия четвертой страницы onboarding screen")
    public OnboardingScreen4Page checkPageOpenedCorrectly(String value) {
        pageResultComponent.checkPrimaryText(value);
        pageResultComponent.checkIndicatorVisibility(page4Indicator);

        return this;
    }

    @Step("Нажатие кнопки Get started")
    public void clickGetStartedButton() {
        getStartedButton.click();
    }
}