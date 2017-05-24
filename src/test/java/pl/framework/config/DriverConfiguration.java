package pl.framework.config;

public class DriverConfiguration {
	public static final BrowserType    browser = BrowserType.Firefox;
	public static final BrowserVersion version = BrowserVersion.ANY;
	public static final int            timeout = 5; // Seconds
	
	public static final boolean		   isGrid  = false;
	public static final String         hubUrl  = "http://127.0.0.1:4444/wd/hub";
}
