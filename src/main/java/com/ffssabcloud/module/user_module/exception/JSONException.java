package com.ffssabcloud.module.user_module.exception;

public class JSONException extends Exception{
	
	public JSONException() {
		super();
	}
	
	public JSONException(String message) {
		super(message);
	}
	
	public JSONException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public JSONException(Throwable cause) {
		super(cause);
	}
}
