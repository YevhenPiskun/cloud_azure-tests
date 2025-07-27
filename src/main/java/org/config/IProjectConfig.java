package org.config;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties", "system:env", "classpath:env.properties"})
public interface IProjectConfig extends Accessible {

    @Key("application.ip")
    String applicationIp();

    @Key("gateway.url")
    String gatewayUrl();

    @Key("access.key")
    String accessKey();
}