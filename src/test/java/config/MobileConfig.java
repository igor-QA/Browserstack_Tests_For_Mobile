package config;

import org.aeonbits.owner.Config;
import utils.Platform;


@Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:config.properties",
            "classpath:mobile.${platform}.properties"
    })

    public interface MobileConfig extends Config {

        @Key("browserstack.user")
        String username();

        @Key("browserstack.key")
        String key();

        @Key("browserstack.app")
        String app();

        @Key("browserstack.platform")
        Platform platform();

        @Key("browserstack.url")
        String browserstackURL();
}

