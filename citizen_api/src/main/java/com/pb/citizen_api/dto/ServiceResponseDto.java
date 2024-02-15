package com.pb.citizen_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponseDto<T> {

    private HttpStatus status;
    private T response;
    private List<ErrorDto> error;

    public ServiceResponseDto(HttpStatus status, T response) {
        this.status = status;
        this.response = response;
    }
}