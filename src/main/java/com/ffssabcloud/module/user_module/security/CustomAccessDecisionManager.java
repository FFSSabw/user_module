package com.ffssabcloud.module.user_module.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomAccessDecisionManager implements AccessDecisionManager{

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		//自定义策略，通过策略来判断用户是否有权限访问资源
		//authentication参数是从全局缓存SecurityContextHolder中获取的
		//configAttributes为需要的权限集合
		if(configAttributes == null) {
			return;
		}
		
		for(ConfigAttribute ca : configAttributes) {
			String needRole = ((SecurityConfig)ca).getAttribute();
			for(GrantedAuthority ga : authentication.getAuthorities()) {
				if(needRole.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		//没有相应权限，抛出异常，跳转到对应的access-denied-page页面
		throw new AccessDeniedException("AccessDenied");
		
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
