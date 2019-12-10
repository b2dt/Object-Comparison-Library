package com.brent.comparison.models;

public class NotSameObjectException extends RuntimeException {
    public NotSameObjectException() {
        super();
    }

    public NotSameObjectException(String message) {
        super(message);
    }

    public NotSameObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSameObjectException(Throwable cause) {
        super(cause);
    }

    protected NotSameObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
