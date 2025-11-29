package com.app.base.application.exceptions;

import com.pagatodo.commons.exceptions.ApiErrorCode;
import com.pagatodo.commons.exceptions.PagatodoRuntimeException;

import java.io.Serial;

public class AppException extends PagatodoRuntimeException{
	@Serial
	private static final long serialVersionUID = 1L;
	
	public AppException(ApiErrorCode code) {
		super(code);
	}
	
	public AppException(ApiErrorCode code, Throwable cause) {
		super(code, cause);
	}
}
