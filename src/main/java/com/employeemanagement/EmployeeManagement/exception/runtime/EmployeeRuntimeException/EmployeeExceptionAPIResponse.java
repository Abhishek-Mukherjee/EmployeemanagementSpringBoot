package com.employeemanagement.EmployeeManagement.exception.runtime.EmployeeRuntimeException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeExceptionAPIResponse {
    HttpStatus httpStatus;
    String ExceptionMassage;
}
