package com.dalen.vetAppDalen.shared.util;

import java.time.LocalDateTime;

import com.dalen.vetAppDalen.shared.response.ApiResponse;

public class ResponseUtils {

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .success(true)
                .data(data)
                .build();
    }
}
