package com.raysi.springexceptionhandeling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<ErrorDetail> businessExceptionHandler(BussinessException bussinessException){
        ErrorDetail errorDetails = new ErrorDetail(bussinessException.getErrorCode(), bussinessException.getErrorMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ErrorDetail> resourcesNotFoundException(ResourcesNotFoundException resourcesNotFoundException){
        ErrorDetail errorDetail = new ErrorDetail(resourcesNotFoundException.getErrorCode(), resourcesNotFoundException.getErrorMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
