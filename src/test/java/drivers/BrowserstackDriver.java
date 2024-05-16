package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        caps.setCapability("browserstack.user", authConfig.username());
        caps.setCapability("browserstack.key", authConfig.authkey());

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
        caps.setCapability("device", deviceConfig.deviceName());
        caps.setCapability("os_version", deviceConfig.platformVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "BrowserStack Sample");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(authConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}