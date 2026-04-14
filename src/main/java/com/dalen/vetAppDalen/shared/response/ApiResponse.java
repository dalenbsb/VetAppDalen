package com.dalen.vetAppDalen.shared.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private boolean success;
    private T data;
}
