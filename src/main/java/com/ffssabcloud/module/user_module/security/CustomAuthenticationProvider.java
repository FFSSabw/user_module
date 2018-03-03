package com.ffssabcloud.module.user_module.security;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider{
	public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
		super();
		//这里必须设置UserDetaulService
		setUserDetailsService(userDetailsService);
	}
	
	/* 该方法实现密码比较
	 * 不抛出错误表示密码比较成功
	 * @see org.springframework.security.authentication.dao.DaoAuthenticationProvider#additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) {
		Object salt = null;
		
		if(this.getSaltSource() != null) {
			salt = this.getSaltSource().getSalt(userDetails);
		}
		
		if(authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");
			
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}
		
		String presentedPassword = authentication.getCredentials().toString();
		
		if(!getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
			logger.debug("Authentication failed: password does not match stored value");  
			  
            throw new BadCredentialsException("Bad credentials:" + userDetails); 
		}
	}
}
