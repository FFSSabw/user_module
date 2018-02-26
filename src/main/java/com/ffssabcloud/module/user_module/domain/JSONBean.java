package com.ffssabcloud.module.user_module.domain;

public class JSONBean<T> {
	
	public static final String ERROR = "000";
	public static final String OK = "100";
	
	private String code;
	private String message;
	private T data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
