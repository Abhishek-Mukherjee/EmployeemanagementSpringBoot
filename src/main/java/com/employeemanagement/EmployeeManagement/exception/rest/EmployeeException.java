package com.employeemanagement.EmployeeManagement.exception.rest;

import com.employeemanagement.EmployeeManagement.exception.runtime.EmployeeRuntimeException.EmployeeExceptionAPIResponse;
import com.employeemanagement.EmployeeManagement.exception.runtime.EmployeeRuntimeException.EmployeeRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class EmployeeException {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<EmployeeExceptionAPIResponse> BadURLException(Exception ex){
        EmployeeExceptionAPIResponse employeeExceptionAPIResponse = new EmployeeExceptionAPIResponse(HttpStatus.NOT_FOUND,"Resource Not Found, Please Check the URl");
        return new ResponseEntity<>(employeeExceptionAPIResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoSuchElementException.class,EmployeeRuntimeException.class})
    public ResponseEntity<EmployeeExceptionAPIResponse> InvalidCreds(Exception ex){
        EmployeeExceptionAPIResponse employeeExceptionAPIResponse = new EmployeeExceptionAPIResponse(HttpStatus.NOT_FOUND,ex.getMessage());
        return new ResponseEntity<>(employeeExceptionAPIResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeExceptionAPIResponse> validationForDTOExceptions(MethodArgumentNotValidException ex){
        EmployeeExceptionAPIResponse employeeExceptionAPIResponse = new EmployeeExceptionAPIResponse(HttpStatus.NOT_FOUND,ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(employeeExceptionAPIResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<EmployeeExceptionAPIResponse> duplicateEntryException(DataIntegrityViolationException ex){
        EmployeeExceptionAPIResponse employeeExceptionAPIResponse = new EmployeeExceptionAPIResponse(HttpStatus.NOT_FOUND,ex.getMostSpecificCause().getMessage());
        return new ResponseEntity<>(employeeExceptionAPIResponse,HttpStatus.BAD_REQUEST);
    }
}
