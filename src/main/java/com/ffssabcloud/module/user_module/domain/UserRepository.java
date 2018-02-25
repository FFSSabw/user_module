package com.ffssabcloud.module.user_module.domain;

import org.springframework.stereotype.Repository;

import com.ffssabcloud.module.user_module.domain.User;

public interface UserRepository {
	public User findByUsername(String username);
}
