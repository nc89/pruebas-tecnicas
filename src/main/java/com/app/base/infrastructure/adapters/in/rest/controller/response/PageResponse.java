package com.app.base.infrastructure.adapters.in.rest.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageResponse {
	private boolean last;
    private int totalPages;
    private long totalElements;
    private int size;
    private int number;
    private boolean first;
    private int numberOfElements;
    private boolean empty;
}
