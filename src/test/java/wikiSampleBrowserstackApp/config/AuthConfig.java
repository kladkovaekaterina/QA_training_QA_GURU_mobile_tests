package wikiSampleBrowserstackApp.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:testing.properties"
})
public interface AuthConfig extends Config {

    @Key("auth.userName")
    String username();

    @Key("auth.authKey")
    String authkey();

    @Key("auth.url")
    String url();

}