package com.ffssabcloud.module.user_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.Banner;
/**
 * Create the main application
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args)
    {	
//    	System.out.println(new StandardPasswordEncoder().encode("12345678"));
//        SpringApplication.run(App.class, args);
    	SpringApplication app = new SpringApplication(App.class);
    	app.setBannerMode(Banner.Mode.OFF);
    	app.run(args);
    }
}
