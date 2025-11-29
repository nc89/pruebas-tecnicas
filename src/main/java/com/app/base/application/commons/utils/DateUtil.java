package com.app.base.application.commons.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.app.base.application.config.ApplicationConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class DateUtil {
    /**
     * Application configuration to access date and time formats.
     */
    private final ApplicationConfig applicationConfig;
    

    /**
     * Formats a given LocalDateTime object into a string based on the application's date format configuration.
     */
    public String getFormattedDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(applicationConfig.getFormat().getDate()));
    }

    /**
     * Formats a given LocalDateTime object into a string based on the application's time format configuration.
     */
    public String getFormattedHour(LocalDateTime hour) {
        return hour.format(DateTimeFormatter.ofPattern(applicationConfig.getFormat().getTime()));
    }
    
    public String getFechaFormato(LocalDate date, String formato) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
		return date.format(dateTimeFormatter); 
	}
    
    public String getHora(LocalTime time, String formato) {
		return time.format(DateTimeFormatter.ofPattern(formato));
	}

	
}
