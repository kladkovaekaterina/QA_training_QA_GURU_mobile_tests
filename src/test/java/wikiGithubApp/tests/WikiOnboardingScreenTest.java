package wikiGithubApp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import wikiGithubApp.pages.*;

@Tag("wikiApp")
public class WikiOnboardingScreenTest extends TestBaseWikiGithubApp {

    OnboardingScreen1Page onboardingScreen1Page = new OnboardingScreen1Page();
    OnboardingScreen2Page onboardingScreen2Page = new OnboardingScreen2Page();
    OnboardingScreen3Page onboardingScreen3Page = new OnboardingScreen3Page();
    OnboardingScreen4Page onboardingScreen4Page = new OnboardingScreen4Page();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка успешной загрузки onboarding экрана")
    void successfulGettingStartedPageTest() {
        onboardingScreen1Page.checkPageOpenedCorrectly("The Free Encyclopedia …in over 300 languages")
                             .clickContinueButton();
        onboardingScreen2Page.checkPageOpenedCorrectly("New ways to explore")
                             .clickContinueButton();
        onboardingScreen3Page.checkPageOpenedCorrectly("Reading lists with sync")
                             .clickContinueButton();
        onboardingScreen4Page.checkPageOpenedCorrectly("Data & Privacy")
                             .clickGetStartedButton();
        mainPage.checkPageOpenedCorrectly("Search Wikipedia");
    }
}