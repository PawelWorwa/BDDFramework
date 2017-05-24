package pl.framework.config;

public enum BrowserVersion {
	ANY(50.0f), // Marionette flag
	Firefox_53_0(53.0f)
	;

	private final float version;

	private BrowserVersion(final float version) {
		this.version = version;
	}

	public float toFloat() {
		return version;
	}
}
