package com.dalen.vetAppDalen.shared.mapper;

import org.springframework.data.domain.Page;

import com.dalen.vetAppDalen.shared.response.PageResponse;

public class PageMapper {

    public static <T> PageResponse<T> map(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
