package com.alex_kozlov.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException e) {

        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(e.getMessage());

        ResponseEntity<EmployeeIncorrectData>  responseEntity =
                new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);

        return responseEntity;
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleAllException(Exception e) {

        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(e.getMessage());

        ResponseEntity<EmployeeIncorrectData> responseEntity =
                new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);

        return responseEntity;

    }
}
