package com.capgemini.exceptions;

public class ServerDowntimeException extends Exception {

    private String message = null;

    public ServerDowntimeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
