package com.app.base.domain.enums;

public enum TransactionStatusEnum {
	/**
	 * Indicates that the transaction has been completed successfully.
	 */
	FINALIZADA,
	
	/**
	 * Indicates that the transaction has been cancelled.
	 */
	CANCELADA,
	
	/**
	 * Indicates that the transaction is still pending from third part.
	 */
	PENDIENTE
	;
}
