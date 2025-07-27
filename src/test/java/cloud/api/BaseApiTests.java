package cloud.api;

import org.config.ConfigHolder;

public class BaseApiTests {

    protected static final String BASE_URL = ConfigHolder.getInstance().applicationIp();
    protected static final String GATEWAY_URL = ConfigHolder.getInstance().gatewayUrl();
    protected static final String KEY = ConfigHolder.getInstance().accessKey();
}