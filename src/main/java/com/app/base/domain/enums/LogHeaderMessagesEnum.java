package com.app.base.domain.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogHeaderMessagesEnum {
	NO_MESSAGE("com.app.base.application.commons.annotations.LogHeader.NO_MESSAGE"),
	SAVE_SALE("com.app.base.infraestructure.adapters.in.rest.controller.SaleControllerAdapter.SAVE_SALE"),
	FIND_RULES("com.app.base.infraestructure.adapters.in.rest.controller.SaleControllerAdapter.FIND_RULES"),
	FIND_DRAW_GAMES("com.app.base.infraestructure.adapters.in.rest.controller.SaleControllerAdapter.FIND_DRAW_GAMES"),
	RANDOM_NUMBER("com.app.base.infraestructure.adapters.in.rest.controller.SaleControllerAdapter.RANDOM_NUMBER"),
	
	SIMULATE("com.app.base.infraestructure.adapters.in.rest.controller.PrizeControllerAdapter.SIMULATE"),
	CHECK("com.app.base.infraestructure.adapters.in.rest.controller.PrizeControllerAdapter.CHECK"),
	PAY("com.app.base.infraestructure.adapters.in.rest.controller.PrizeControllerAdapter.PAY"),
	PARAMETER("com.app.base.infraestructure.adapters.in.rest.controller.GeneralControllerAdapter.PARAMETER"),
	DRAW("com.app.base.infraestructure.adapters.in.rest.controller.GeneralControllerAdapter.DRAW"),
	
	;
	
	
	
	private String localizedMessage;
}
