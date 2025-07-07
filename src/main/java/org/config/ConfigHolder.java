package org.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHolder {

    private static class LazyHolder {
        static final IProjectConfig INSTANCE = ConfigFactory.create(IProjectConfig.class);
    }

    public static IProjectConfig getInstance() {
        return LazyHolder.INSTANCE;
    }
}