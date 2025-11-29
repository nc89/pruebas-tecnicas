package com.app.base.application.commons.utils;

import org.springframework.stereotype.Component;

import com.app.base.domain.enums.ApplicationMessageEnum;
import com.pagatodo.commons.messages.MessagesPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageUtil {
private final MessagesPort messageOutputPort;
	
	public String getMessage(final ApplicationMessageEnum messageCode, final Object... args) {
		return messageOutputPort.getMessage(messageCode.name(), args);
	}
}
