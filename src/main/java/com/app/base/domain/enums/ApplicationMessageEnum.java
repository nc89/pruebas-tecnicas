package com.app.base.domain.enums;

import com.pagatodo.commons.exceptions.ApiErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationMessageEnum implements ApiErrorCode{
	/**
     * Códigos de éxito.
     * Estos códigos indican que la operación se ha realizado correctamente.
     * <br/>
     * <br/>
     * - <b>Código:</b> 000<br/>
     * - <b>Mensaje:</b> com.app.base.domain.enums.message.OK<br/>
     */
    OK("000", "com.app.base.domain.enums.message.OK"),

    /**
     * Códigos de creación.
     * Estos códigos indican que un recurso ha sido creado exitosamente.
     * <br/>
     * <br/>
     * - <b>Código:</b> 001<br/>
     * - <b>Mensaje:</b> com.app.base.domain.enums.message.CREATED<br/>
     */
    CREATED("001", "com.app.base.domain.enums.message.CREATED"),

    /**
     * Indica que los datos se guardaron correctamente.
     * <br/>
     * <br/>
     * - <b>Código:</b> 002<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.SAVED<br/>
     */
    SAVED("002", "com.app.base.domain.enums.message.SAVED"),

    /**
     * Indica que los datos se actualizaron correctamente.
     * <br/>
     * <br/>
     * - <b>Código:</b> 003<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.UPDATE<br/>
     */
    UPDATE("003", "com.app.base.domain.enums.message.UPDATE"),

    /**
     * Indica que los datos están duplicados.
     * <br/>
     * <br/>
     * - <b>Código:</b> 004<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.DUPLICATE<br/>
     */
    DUPLICATE("004", "com.app.base.domain.enums.message.DUPLICATE"),

    /**
     * Indica que se encontró un archivo.
     * <br/>
     * <br/>
     * - <b>Código:</b> 005<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.FIND<br/>
     */
    FIND("005", "com.app.base.domain.enums.message.FIND"),

    /**
     * Indica que la venta falló debido a problemas de integridad de datos.
     * <br/>
     * <br/>
     * - <b>Código:</b> 006<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.SALE_FAILED_DATA_INTEGRITY<br/>
     */
    SALE_FAILED_DATA_INTEGRITY("006", "com.app.base.domain.enums.message.SALE_FAILED_DATA_INTEGRITY"),

    /**
     * Indica que no se encontró la papelería solicitada.
     * <br/>
     * <br/>
     * - <b>Código:</b> 007<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.STATIONERY_NOT_FOUND<br/>
     */
    STATIONERY_NOT_FOUND("007", "com.app.base.domain.enums.message.STATIONERY_NOT_FOUND"),

    /**
     * Indica que la información del terminal está vacía.
     * <br/>
     * <br/>
     * - <b>Código:</b> 008<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.EMPTY_TERMINAL_INFO_EXCEPTION<br/>
     */
    EMPTY_TERMINAL_INFO_EXCEPTION("008", "com.app.base.domain.enums.message.EMPTY_TERMINAL_INFO_EXCEPTION"),

    /**
     * Indica un error desconocido.
     * <br/>
     * <br/>
     * - <b>Código:</b> 993<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.UNKNOWN_ERROR<br/>
     */
    UNKNOWN("993", "com.app.base.domain.enums.message.UNKNOWN"),

    /**
     * Indica una solicitud incorrecta.
     * <br/>
     * <br/>
     * - <b>Código:</b> 994<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.BAD_REQUEST<br/>
     */
    BAD_REQUEST("994", "com.app.base.domain.enums.message.BAD_REQUEST"),

    /**
     * Indica un error de conexión.
     * <br/>
     * <br/>
     * - <b>Código:</b> 995<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.CONNECTION_ERROR<br/>
     */
    CONNECTION_ERROR("995", "com.app.base.domain.enums.message.CONNECTION_ERROR"),

    /**
     * Indica que no se encontraron datos.
     * <br/>
     * <br/>
     * - <b>Código:</b> 996<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.NOT_FOUND<br/>
     */
    NOT_FOUND("996", "com.app.base.domain.enums.message.NOT_FOUND"),

    /**
     * Indica un error en la base de datos.
     * <br/>
     * <br/>
     * - <b>Código:</b> 997<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.enums.message.DB_ERROR<br/>
     */
    DB_ERROR("997", "com.app.base.domain.enums.message.DB_ERROR"),
    
    /**
	 * Indica un error de validación.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 009<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.domain.services.RulesHandlerBussinessService.RULE_VIOLATION<br/>
	 */
    RULE_VIOLATION("009", "com.app.base.domain.services.RulesHandlerBussinessService.RULE_VIOLATION"),
    
    /**
     * Indica que no se encontró la propiedad solicitada.
     * <br/>
     * <br/>
     * - <b>Código:</b> 010<br/>
     * - <b>Mensaje:</b>
     * com.app.base.domain.services.RulesHandlerBussinessService.PROPERTY_NOT_FOUND<br/>
     */
    PROPERTY_NOT_FOUND("010", "com.app.base.domain.services.RulesHandlerBussinessService.PROPERTY_NOT_FOUND"),
    
    /**
	 * Indica un error al recargar las políticas.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 011<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.domain.enums.message.ERROR_RELOAD_POLICIES<br/>
	 */
    ERROR_RELOAD_POLICIES("011", "com.app.base.application.services.RuleService.ERROR_RELOAD_POLICIES"),
    
    /**
	 * Indica que no se encontró el archivo en S3.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 012<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.domain.enums.message.S3_ERROR_FILE_NOT_FOUND<br/>
	 */
    S3_ERROR_FILE_NOT_FOUND("012", "com.app.base.domain.enums.message.S3_ERROR_FILE_NOT_FOUND"),
    
    /**
	 * Indica un error durante la venta.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 013<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.application.services.SALE_ERROR<br/>
	 * */
    SALE_ERROR("013", "com.app.base.application.services.SALE_ERROR"),

    /**
     * Indica que los números de categoría de venta son inválidos.
     * <br/>
     * <br/>
     * - <b>Código:</b> 014<br/>
     * - <b>Mensaje:</b>
     * com.app.base.application.services.SALE_CATEGORY_NUMBERS_INVALID<br/>
     */
    SALE_CATEGORY_NUMBERS_INVALID("014", "com.app.base.application.services.SALE_CATEGORY_NUMBERS_INVALID"),
    
    /**
	 * Indica que el sorteo de venta es inválido.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 015<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.application.services.SALE_DRAW_INVALID<br/>
	 */
    SALE_DRAW_INVALID("015", "com.app.base.application.services.SALE_DRAW_INVALID"),
    
    /**
	 * Indica que el parámetro de factor de premio es nulo.
	 * <br/>
	 * <br/>
	 * - <b>Código:</b> 016<br/>
	 * - <b>Mensaje:</b>
	 * com.app.base.domain.enums.message.PRIZE_PARAM_FACTOR_NULL<br/>
	 * */
    PRIZE_PARAM_FACTOR_NULL("016", "com.app.base.domain.enums.message.PRIZE_PARAM_FACTOR_NULL"),
    /**
     * Indica que el usuario no está autorizado.
     * <br/>
     * <br/>
     * - <b>Code:</b> 014<br/>
     * - <b>Message:</b> com.app.base.domain.enums.message.UNAUTHORIZED<br/>
     */
    UNAUTHORIZED("017", "com.app.base.domain.enums.message.UNAUTHORIZED"),
    
    MIN_MAX_INVALID("018", "com.app.base.domain.enums.message.MIN_MAX_INVALID"),
    MIN_MAX_BETWEEN_INVALID("019", "com.app.base.domain.enums.message.MIN_MAX_BETWEEN_INVALID"),
   
    SALE_PARAM_RANDOM_NULL("020", "com.app.base.domain.enums.message.SALE_PARAM_RANDOM_NULL"),
    ;

    private final String code;
    private final String localizedMessage;
    private final String prefix = "SCJ ";
}
