package com.app.base.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DateFormatTypeEnum {
	DDMMYY("ddMMyy"),
    MMDDYY("MMddyy"),
    DDMMYYYY("ddMMyyyy"),
    MMDDYYYY("MMddyyyy");
	
	private String pattern;
	
	public String getPattern() {
        return pattern;
    }

    public static boolean isValid(String value) {
        try {
            DateFormatTypeEnum.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
