package com.example.User.controller;




import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleConflict(NullPointerException noSuchFieldException) {

        return new  ResponseEntity<String>("Check the input provided",HttpStatus.NOT_ACCEPTABLE);
    }
}

