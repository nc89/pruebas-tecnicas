package com.app.base.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageModel {
    @Builder.Default
    private int page = 0; // Default to 0
    @Builder.Default
    private int size = 10; // Default to 10
    @Builder.Default
    private List<String> sort = new ArrayList<>();
}
