package com.app.base.application.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionLog {
	/**
	 * Operation name/description for the transaction.
	 * If empty, the request URI will be used as the operation name.
	 * 
	 * @return the operation name
	 */
	String operation() default "";
	
	/**
	 * Whether to persist the transaction to the database.
	 * 
	 * @return true to persist, false otherwise
	 */
	boolean persist() default true;
	
	/**
	 * Whether to store transaction information in MDC context.
	 * When enabled, the following keys are available:
	 * <ul>
	 *   <li>transactionId</li>
	 *   <li>transactionOperation</li>
	 *   <li>transactionStatus</li>
	 * </ul>
	 * 
	 * @return true to store in MDC, false otherwise
	 */
	boolean storeMdc() default true;
}
