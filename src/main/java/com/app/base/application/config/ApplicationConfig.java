package com.app.base.application.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "request-mapping.mvc")
@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class ApplicationConfig {
	
	private Format format;

	@Getter
	@Setter
	public static class Format {
		private String date;
		private String dateTime;
		private String time;
	}
}
