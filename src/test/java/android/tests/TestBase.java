package android.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DeviceConfig;
import drivers.BrowserstackDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        System.out.println("Тест выполнен на платформе " + deviceConfig.platformName() + " ("+ deviceConfig.deviceName() + ")");
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        //Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();

        closeWebDriver();

        Attachments.addVideo(sessionId);
    }
}