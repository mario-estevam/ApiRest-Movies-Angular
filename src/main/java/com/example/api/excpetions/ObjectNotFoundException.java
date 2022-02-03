package com.example.api.excpetions;


public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID= 1L;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundException(String s) {
    }
}
