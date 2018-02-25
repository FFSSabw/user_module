package com.ffssabcloud.module.user_module.configuration;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class MyBatisConfig {
	
	@Autowired
	private DataSource dataSource;
	
	// @Bean(name="sqlSessionFactory")
	// public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext)
	// 	throws Exception {
	// 	SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
	// 	ssfb.setDataSource(dataSource);
	// 	ssfb.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
		
	// 	return ssfb;
		
	// }
	@Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // sessionFactory.setPlugins(new Interceptor[]{new PageInterceptor()});
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
        return sessionFactory;
    }
}
