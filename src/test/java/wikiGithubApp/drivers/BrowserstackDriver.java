package wikiGithubApp.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiGithubApp.config.HostConfig;
import wikiSampleBrowserstackApp.config.AuthConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        caps.setCapability("browserstack.user", authConfig.username());
        caps.setCapability("browserstack.key", authConfig.authkey());

        HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());
        caps.setCapability("app", hostConfig.appUrl());
        System.out.println("Запуск тестов в приложении Wiki App From Github");

        caps.setCapability("device", hostConfig.deviceName());
        caps.setCapability("os_version", hostConfig.platformVersion());

        caps.setCapability("project", "BrowserStack Sample");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}