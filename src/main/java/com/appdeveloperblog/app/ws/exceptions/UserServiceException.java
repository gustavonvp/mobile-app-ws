package com.appdeveloperblog.app.ws.exceptions;

public class UserServiceException extends RuntimeException {


    private static final long serialVersionUID = 1389127381278931L;

    public UserServiceException( String message) {
        super(message);
    }
}
