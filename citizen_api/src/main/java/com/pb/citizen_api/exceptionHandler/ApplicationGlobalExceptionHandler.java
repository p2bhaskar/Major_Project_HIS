package com.pb.citizen_api.exceptionHandler;

import com.pb.citizen_api.dto.ErrorDto;
import com.pb.citizen_api.dto.ServiceResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceResponseDto<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        ServiceResponseDto<?> serviceResponse = new ServiceResponseDto<>();
        List<ErrorDto> errorDTOList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorDto errorDTO = new ErrorDto(error.getField()+" : "+error.getDefaultMessage());
                    errorDTOList.add(errorDTO);
                });
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setError(errorDTOList);
        return serviceResponse;
    }
}
