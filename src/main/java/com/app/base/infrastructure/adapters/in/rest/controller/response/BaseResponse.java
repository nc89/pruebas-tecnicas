package com.app.base.infrastructure.adapters.in.rest.controller.response;
import com.app.base.application.commons.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
	
    @Schema(description = "Fecha de la transacción", example = "2025-11-05")
    private String transactionDate;
	
    @Schema(description = "Hora de la transacción", example = "15:30:45")
    private String transactionTime;
	
    @Schema(description = "Código de respuesta de la operación", example = "00")
    private String codeResponse;
    
    @Schema(description = "Mensaje descriptivo de la operación", example = "operación exitosa")
    private String message;
    
    @Schema(description = "Contenido adicional de la respuesta", example = "{}")
    private Object content;
    
    @Schema(description = "Identificador de la transacción de respuesta", example = "123456789")
    private Long idTransactionResponse;
    
    
    private PageResponse page;
    
    @Override
	public String toString() {
		return JsonUtil.toJsonString(this);
	}
}
