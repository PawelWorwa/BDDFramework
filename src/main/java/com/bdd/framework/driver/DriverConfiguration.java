package com.bdd.framework.driver;

public class DriverConfiguration {
    private DriverConfiguration() {
        throw new IllegalStateException("DriverConfiguration is utility class and should not be instantiated!");
    }

    public static final String BROWSER     = System.getProperty("maven.browser");
	public static final int TIMEOUT        = 5;  // Seconds
    public static final int PAGE_LOAD_TIME = 30; // Seconds
}