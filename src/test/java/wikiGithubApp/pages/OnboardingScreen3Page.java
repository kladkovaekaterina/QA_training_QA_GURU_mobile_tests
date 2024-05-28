package wikiGithubApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import wikiGithubApp.pages.components.PageResultComponent;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class OnboardingScreen3Page {

    PageResultComponent pageResultComponent = new PageResultComponent();

    private final SelenideElement
            page3Indicator = $(accessibilityId("Page 3 of 4"));

    @Step("Проверка результатов открытия третьей страницы onboarding screen")
    public OnboardingScreen3Page checkPageOpenedCorrectly(String value) {
        pageResultComponent.checkPrimaryText(value);
        pageResultComponent.checkSkipButtonVisibility();
        pageResultComponent.checkIndicatorVisibility(page3Indicator);

        return this;
    }

    @Step("Нажатие кнопки Continue")
    public void clickContinueButton() {
        pageResultComponent.clickContinueButton();
    }
}