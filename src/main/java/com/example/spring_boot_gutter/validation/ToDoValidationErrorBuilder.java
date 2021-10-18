package com.example.spring_boot_gutter.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ToDoValidationErrorBuilder {

    public static ToDoValidationError fromBindingsError(Errors errors) {
        ToDoValidationError error = new ToDoValidationError(String.format("Validation failed. %s error(s)." + errors.getErrorCount()));
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }

}
