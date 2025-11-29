package com.app.base.infrastructure.adapters.in.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.app.base.domain.model.PageModel;

@Mapper(componentModel = "spring")
public interface PageableMapper {
	
	Logger log = LoggerFactory.getLogger(PageableMapper.class);

    default Pageable toPageable(PageModel pageModel) {
        int page = Math.max(0, pageModel.getPage());
        int size = Math.max(1, pageModel.getSize());
        return PageRequest.of(page, size, Sort.by(parseSortParams(pageModel.getSort())));
    }

    private List<Sort.Order> parseSortParams(List<String> sortParams) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortParams == null) {
            return orders;
        }
        for (String param : sortParams) {
            if (param == null || param.isBlank()) continue;
            orders.add(parseSort(param));
        }
        return orders;
    }

    private Sort.Order parseSort(String sortParam) {
        String[] parts = sortParam.split(",");
        String property = parts[0].trim();
        Sort.Direction direction = Sort.Direction.ASC;
        if (parts.length > 1) {
            try {
                direction = Sort.Direction.fromString(parts[1].trim());
            } catch (IllegalArgumentException e) {
            	log.warn("Dirección de orden no válida '{}', usando ASC por defecto", parts[1].trim());
                direction = Sort.Direction.ASC;
            }
        }
        return new Sort.Order(direction, property);
    }
    
}
