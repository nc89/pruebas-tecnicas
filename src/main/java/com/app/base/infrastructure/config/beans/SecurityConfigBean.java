package com.app.base.infrastructure.config.beans;

import com.pagatodo.commons.rest.servlet.CorsWebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigBean {
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new CorsWebMvcConfigurer();
	}
}
