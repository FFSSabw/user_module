package com.ffssabcloud.module.user_module.configuration;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisScannerConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mscf = new MapperScannerConfigurer();
		mscf.setBasePackage("com.ffssabcloud.module.user_model.dao");
		mscf.setSqlSessionFactoryBeanName("sqlSessionFactory");
		
		return mscf;
	}
}
