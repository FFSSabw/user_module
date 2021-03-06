package com.ffssabcloud.module.user_module.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor
	implements Filter{
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	/**
	 * 拦截后调用doFilter
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);
		invoke(filterInvocation);
	}
	
	public void invoke(FilterInvocation filterInvocation) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
		
		try {
			filterInvocation.getChain().doFilter(filterInvocation.getRequest(),
					filterInvocation.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}
	
	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
