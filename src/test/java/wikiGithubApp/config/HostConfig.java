package wikiGithubApp.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:host/${deviceHost}.properties"
})
public interface HostConfig extends Config {
    @Key("host.name")
    @DefaultValue("browserstack")
    String hostName();

    @Key("host.url")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String hostUrl();

    @Key("device.name")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("12.0")
    String platformVersion();

    @Key("app.url")
    @DefaultValue("bs://919e40b2f083d3c48da2a33cb04b3080c3c86327")
    String appUrl();
}