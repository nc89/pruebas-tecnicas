package com.app.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.pagatodo.commons.CommonsSpringBootConfig;

@EnableFeignClients
@SpringBootApplication
@EnableAspectJAutoProxy
@EntityScan
@Import({CommonsSpringBootConfig.class})
public class BackendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAppApplication.class, args);
	}

}
