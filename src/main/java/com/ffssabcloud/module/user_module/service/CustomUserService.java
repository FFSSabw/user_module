package com.ffssabcloud.module.user_module.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ffssabcloud.module.user_module.dao.UserDao;
import com.ffssabcloud.module.user_module.domain.Role;
import com.ffssabcloud.module.user_module.domain.User;

@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for(Role role:user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			System.out.println(role.getName());
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getHashedPassword(), authorities);
	}
}
