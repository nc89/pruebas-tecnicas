package com.app.base.infrastructure.adapters.components;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.base.application.commons.annotations.Sensitive;

import java.lang.reflect.Field;

@Aspect
public class SensitiveLoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(SensitiveLoggingAspect.class);

    @Before("execution(* org.slf4j.Logger.info(..))")
    public void maskSensitiveFields(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg != null) {
                for (Field field : arg.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Sensitive.class)) {
                        field.setAccessible(true);
                        try {
                            field.set(arg, "****");
                        } catch (IllegalAccessException ignored) {}
                    }
                }
            }
        }
    }
}
