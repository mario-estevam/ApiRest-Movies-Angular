package com.example.api.excpetions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timeStamp, Integer status, String error) {
        super(timeStamp, status, error);
    }

    public List<FieldMessage> getListErrors() {
        return errors;
    }

    public void addErrors(String fieldname, String message) {
        this.errors.add(new FieldMessage(fieldname, message));
    }
}
