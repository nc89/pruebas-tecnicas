package com.app.base.infrastructure.adapters.components;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.app.base.application.commons.annotations.LogHeader;
import com.app.base.application.commons.annotations.Sensitive;
import com.pagatodo.commons.logging.LogginMdcContextUtil;
import com.pagatodo.commons.messages.MessagesPort;
import com.pagatodo.commons.security.SecurityConstants;
import com.pagatodo.commons.utils.JsonMapperUtils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LogHeaderAspect {
private final MessagesPort messagesPort;
	
	@Around("@annotation(logHeader)")
	public Object logHedaer(ProceedingJoinPoint joinPoint, LogHeader logHeader) throws Throwable {
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
	            .getRequest();
	
	    String body = null;
	    if (request instanceof ContentCachingRequestWrapper cachingRequest) {
	        byte[] buf = cachingRequest.getContentAsByteArray();
	        if (buf.length > 0) {
	            body = (new String(buf, 0, buf.length, cachingRequest.getCharacterEncoding()))
	                    .replaceAll("[\\r\\n\\t]+", "")
	                    .replaceAll("\\{ +", "{")
	                    .replaceAll(" +\\}", "}")
	                    .replaceAll(", +\"", ", \"")
	                    .replaceAll("\\[ +", "[")
	                    .replaceAll(" +\\]", "]");
	        }
	    }
	
	    // Obtén el objeto de la solicitud si está disponible
	    Object[] args = joinPoint.getArgs();
	    Object requestObj = args.length > 0 ? args[0] : null;
	    body = maskSensitiveFields(requestObj, body);
	
	    log.info("{} :: SOLICITUD :: METHOD:{} - PATH:{} - BODY:{}",
	            messagesPort.getMessage(logHeader.header().getLocalizedMessage()),
	            request.getMethod(),
	            request.getRequestURI(), body);
	
	    Object response = joinPoint.proceed();
	
	    log.info("{} :: RESPUESTA :: METHOD:{} - PATH:{} - RESPONSE:{} - TRANSACTION_ID:{}",
	            messagesPort.getMessage(logHeader.header().getLocalizedMessage()),
	            request.getMethod(),
	            request.getRequestURI(),
	            JsonMapperUtils.toJson(response).orElse(""),
	            LogginMdcContextUtil.get(SecurityConstants.HTTP_HEADER_TRANSACTION_ID).orElse(""));
	
	    return response;
	}

	private String maskSensitiveFields(Object requestObj, String bodyJson) {
	    if (requestObj == null || bodyJson == null) return bodyJson;
	    try {
	        Class<?> clazz = requestObj.getClass();
	        var mapper = new com.fasterxml.jackson.databind.ObjectMapper();
	        var node = mapper.readTree(bodyJson);

	        for (var field : clazz.getDeclaredFields()) {
	            if (field.isAnnotationPresent(
	                Sensitive.class)) {
	                String fieldName = field.getName();
	                if (node.has(fieldName)) {
	                    ((com.fasterxml.jackson.databind.node.ObjectNode) node).put(fieldName, "****");
	                }
	            }
	        }
	        return mapper.writeValueAsString(node);
	    } catch (Exception e) {
	        return bodyJson;
	    }
	}
}
