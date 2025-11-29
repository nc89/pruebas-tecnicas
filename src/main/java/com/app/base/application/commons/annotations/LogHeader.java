package com.app.base.application.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.app.base.domain.enums.LogHeaderMessagesEnum;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogHeader {

	LogHeaderMessagesEnum header() default LogHeaderMessagesEnum.NO_MESSAGE;
}
