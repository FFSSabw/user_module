package com.ffssabcloud.module.user_module.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	
//	private static 
	/**
	 * Tomcat启动时会实例化一次该类
	 */
	public CustomInvocationSecurityMetadataSource() {}
	
	/**
	 * 获取request的url然后返回url对应可访问的权限,以此来实现动态权限管理
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation)object;
		String url = fi.getRequestUrl();
		String httpMethod = fi.getRequest().getMethod();
		List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();

		// Lookup your database (or other source) using this information and populate the
		// list of attributes

		return attributes;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
