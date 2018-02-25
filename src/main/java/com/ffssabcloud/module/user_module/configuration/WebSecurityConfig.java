package com.ffssabcloud.module.user_module.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ffssabcloud.module.user_module.fliter.RestAuthenticationFilter;
import com.ffssabcloud.module.user_module.handler.LoginFailureHandler;
import com.ffssabcloud.module.user_module.handler.LoginSuccessHandler;
import com.ffssabcloud.module.user_module.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	UserDetailsService customUserService() {
		return new CustomUserService();
	}
	
	@Bean
	RestAuthenticationFilter restAuthenticationFilter() throws Exception {
		RestAuthenticationFilter raf = new RestAuthenticationFilter();
		raf.setAuthenticationSuccessHandler(new LoginSuccessHandler());
		raf.setAuthenticationFailureHandler(new LoginFailureHandler());
		raf.setFilterProcessesUrl("/login/self");	
		raf.setAuthenticationManager(authenticationManagerBean());
		
		return raf;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(new StandardPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .cors().and()
        .antMatcher("/**").authorizeRequests()
        .antMatchers("/", "/login**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/")
        .and().csrf().disable();
		
		http.addFilterAt(restAuthenticationFilter(), 
				UsernamePasswordAuthenticationFilter.class);
	}

}
