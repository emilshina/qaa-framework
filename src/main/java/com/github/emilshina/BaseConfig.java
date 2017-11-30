package com.github.emilshina;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * Base configuration for properties.
 */

@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config, Reloadable {
    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("explicit.wait.timeout")
    @DefaultValue("3")
    long waitTimeout();

    @Key("url")
    @DefaultValue("http://localhost")
    String url();
}
