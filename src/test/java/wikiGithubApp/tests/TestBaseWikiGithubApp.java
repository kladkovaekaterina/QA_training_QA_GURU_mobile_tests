package wikiGithubApp.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import wikiGithubApp.config.HostConfig;
import wikiGithubApp.drivers.BrowserstackDriver;
import wikiGithubApp.drivers.EmulatorDriver;
import wikiGithubApp.drivers.RealDeviceDriver;
import wikiSampleBrowserstackApp.config.DeviceConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseWikiGithubApp {

    @BeforeAll
    static void beforeAll() {
        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if ("emulation".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = EmulatorDriver.class.getName();
        } else if ("real".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = RealDeviceDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());

    @BeforeEach
    void beforeEach() {
        System.out.println("Запуск тестов на " + hostConfig.hostName());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();

        if ("ios".equals(System.getProperty("platform"))) {
            System.out.println("Запуск тестов на платформе ios не реализован, тесты будут запущены на android");
        }
    }

    @AfterEach
    void addAttachments() {
        System.out.println("Тест выполнен на платформе " + deviceConfig.platformName() + " ("+ hostConfig.deviceName() + ")");
        String sessionId = Selenide.sessionId().toString();

        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            Attachments.pageSource();
            closeWebDriver();
            Attachments.addVideo(sessionId);
        } else if ("emulation".equals(System.getProperty("deviceHost")) || "real".equals(System.getProperty("deviceHost"))) {
            Attachments.pageSource();
            Attachments.screenshotAs("Last screenshot");
            closeWebDriver();
        } else {
            Attachments.pageSource();
            closeWebDriver();
            Attachments.addVideo(sessionId);
        }
    }
}