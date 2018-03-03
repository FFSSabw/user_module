package com.ffssabcloud.module.user_module.security;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffssabcloud.module.user_module.AuthenticationBean;

public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	/* 
	 * 拦截登录request并处理
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
		if(MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType())
				|| MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {

			ObjectMapper mapper = new ObjectMapper();
			UsernamePasswordAuthenticationToken authRequest = null;
			
			try(InputStream is = request.getInputStream()) {
				AuthenticationBean authenticationBean = mapper.readValue(is, AuthenticationBean.class);
				authRequest = new UsernamePasswordAuthenticationToken(
						authenticationBean.getUsername(), authenticationBean.getPassword());
			} catch(IOException e) {
				e.printStackTrace();
				authRequest = new UsernamePasswordAuthenticationToken("", "");
			} finally {
				setDetails(request, authRequest);
			}
			return this.getAuthenticationManager().authenticate(authRequest);
			
		} else {
			return super.attemptAuthentication(request, response);
		}
	}	

}
