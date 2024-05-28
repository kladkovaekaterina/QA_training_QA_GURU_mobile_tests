package wikiGithubApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import wikiGithubApp.pages.components.PageResultComponent;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class OnboardingScreen2Page {

    PageResultComponent pageResultComponent = new PageResultComponent();

    private final SelenideElement
            page2Indicator = $(accessibilityId("Page 2 of 4"));

    @Step("Проверка результатов открытия второй страницы onboarding screen")
    public OnboardingScreen2Page checkPageOpenedCorrectly(String value) {
        pageResultComponent.checkPrimaryText(value);
        pageResultComponent.checkSkipButtonVisibility();
        pageResultComponent.checkIndicatorVisibility(page2Indicator);

        return this;
    }

    @Step("Нажатие кнопки Continue")
    public void clickContinueButton() {
        pageResultComponent.clickContinueButton();
    }
}