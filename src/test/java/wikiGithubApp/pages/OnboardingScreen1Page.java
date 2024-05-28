package wikiGithubApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import wikiGithubApp.pages.components.PageResultComponent;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class OnboardingScreen1Page {

    PageResultComponent pageResultComponent = new PageResultComponent();

    private final SelenideElement
            page1Indicator = $(accessibilityId("Page 1 of 4"));

    @Step("Проверка результатов открытия первой страницы onboarding screen")
    public OnboardingScreen1Page checkPageOpenedCorrectly(String value) {
        pageResultComponent.checkPrimaryText(value);
        pageResultComponent.checkSkipButtonVisibility();
        pageResultComponent.checkIndicatorVisibility(page1Indicator);

        return this;
    }

    @Step("Нажатие кнопки Continue")
    public void clickContinueButton() {
        pageResultComponent.clickContinueButton();
    }
}