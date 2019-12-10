package com.brent.comparison.models;

public class NoKeyOnArrayException extends RuntimeException {
    public NoKeyOnArrayException() {
    }

    public NoKeyOnArrayException(Class clazz) {
        super("No key for list of object: " + clazz.toString());
    }

    public NoKeyOnArrayException(String message) {
        super(message);
    }

    public NoKeyOnArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoKeyOnArrayException(Throwable cause) {
        super(cause);
    }

    public NoKeyOnArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
