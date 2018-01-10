package com.bdd.framework.exceptions;

public class UnsupportedBrowserException extends RuntimeException {
	private static final long serialVersionUID = -8571747258737437854L;

	public UnsupportedBrowserException(String message) {
        super(message);
    }
}