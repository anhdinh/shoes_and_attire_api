package com.andy.attire.controller;

import com.andy.attire.dto.ErrorDto;
import com.andy.attire.service.ErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final ErrorService errorService;

    public RestResponseEntityExceptionHandler(ErrorService errorService) {
        this.errorService = errorService;
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest webRequest) throws IOException {

        var request  =  ((ServletWebRequest)webRequest).getRequest();
        var url = request.getRequestURI()+ request.getQueryString();
        var body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        var exceptionMessage = ex.getMessage();
        var track = Arrays.toString(ex.getStackTrace());
        var errorDto =  new ErrorDto(url,body,exceptionMessage,track);
        errorDto = errorService.saveError(errorDto);

        return new ResponseEntity<Object>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
