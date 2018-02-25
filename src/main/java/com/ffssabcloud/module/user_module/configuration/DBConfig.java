package com.ffssabcloud.module.user_module.configuration;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DBConfig {
	
//	Get property From application.properties
	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		ds.setDriverClass(env.getProperty("fs.db.driverClassName"));
		ds.setJdbcUrl(env.getProperty("fs.db.url"));
		ds.setUser(env.getProperty("fs.db.username"));
		ds.setPassword(env.getProperty("fs.db.password"));
		ds.setMaxPoolSize(20);
		ds.setMinPoolSize(5);
		ds.setInitialPoolSize(10);
		ds.setMaxIdleTime(300);
		ds.setAcquireIncrement(5);
		ds.setIdleConnectionTestPeriod(60);
		
		System.out.println(env.getProperty("fs.db.user"));
		System.out.println(env.getProperty("fs.db.password"));
		System.out.println(env.getProperty("fs.db.url"));
		return ds;
	}
	
}
