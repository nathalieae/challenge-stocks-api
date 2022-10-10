package com.cg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exceptions.StockDetailsNotFoundException;

@ControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(value = StockDetailsNotFoundException.class)
    public ResponseEntity<String> handelStockDetailsNotFound(StockDetailsNotFoundException e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
