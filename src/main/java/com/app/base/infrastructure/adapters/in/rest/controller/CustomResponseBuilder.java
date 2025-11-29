package com.app.base.infrastructure.adapters.in.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.base.application.commons.providers.ApplicationContextProvider;
import com.app.base.domain.enums.ApplicationMessageEnum;
import com.app.base.infrastructure.adapters.in.rest.controller.response.BaseResponse;
import com.pagatodo.commons.messages.MessagesPort;

@Component
@RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CustomResponseBuilder {
	public static ResponseEntity<BaseResponse> getSuccess(final ApplicationMessageEnum catalogMessageCode,
			final Object content) {

		MessagesPort messagesPort = ApplicationContextProvider.getBean(MessagesPort.class);

		return ResponseEntity.ok(BaseResponse.builder().codeResponse(catalogMessageCode.getCode())
				.message(messagesPort.getMessage(catalogMessageCode.getLocalizedMessage())).content(content).build());
	}

	public static ResponseEntity<BaseResponse> noContent() {
		return ResponseEntity.noContent().build();
	}

	public static String getMessage(String messageKey) {
		MessagesPort messagesPort = ApplicationContextProvider.getBean(MessagesPort.class);
		return messagesPort.getMessage(CustomResponseBuilder.class.getName() + "." + messageKey);
	}

	public static String getMessage(ApplicationMessageEnum messageEnum) {
		MessagesPort messagesPort = ApplicationContextProvider.getBean(MessagesPort.class);
		return messagesPort.getMessage(messageEnum.getLocalizedMessage());
	}
}
