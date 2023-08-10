package com.kavinduakash.springs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
public class SpringsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringsApplication.class, args);
	}

}
