package com.ffssabcloud.module.user_module.dao;

import com.ffssabcloud.module.user_module.domain.User;

public interface UserDao {
	public User findByUsername(String username);
}
