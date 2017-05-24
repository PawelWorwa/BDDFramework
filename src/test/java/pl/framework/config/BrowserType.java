package pl.framework.config;

public enum BrowserType {
	Firefox("firefox"),
	Chrome("chrome"),
	InternetExplorer("internet explorer")
	;
	
	private final String browser;

	private BrowserType(final String browser) {
		this.browser = browser;
	}

	public String toString() {
		return browser;
	}
}
