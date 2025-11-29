package com.app.base.application.commons.providers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		setContext(applicationContext);
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	private static void setContext(ApplicationContext context) {
		ApplicationContextProvider.context = context;
	}
	
	public static <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}
}
