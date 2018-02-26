package com.ffssabcloud.module.user_module.fliter;

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

/**
 * RestAuthenticationFilter that supports rest login(json login) and form login
 * @author fssaw
 *
 */
public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
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
