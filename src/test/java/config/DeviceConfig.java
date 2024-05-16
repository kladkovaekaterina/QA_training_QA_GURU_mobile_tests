package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})
public interface DeviceConfig extends Config {

    @Key("platform.name")
    @DefaultValue("android")
    String platformName();

    @Key("device.name")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @Key("platform.version")
    @DefaultValue("12.0")
    String platformVersion();

}