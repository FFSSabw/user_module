package com.ffssabcloud.module.user_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import static org.springframework.boot.SpringApplication.run;
/**
 * Create the main application
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args)
    {	
    	System.out.println(new StandardPasswordEncoder().encode("12345678"));
        SpringApplication.run(App.class, args);
//    	ConfigurableApplicationContext run = run(App.class, args);
    }
}
