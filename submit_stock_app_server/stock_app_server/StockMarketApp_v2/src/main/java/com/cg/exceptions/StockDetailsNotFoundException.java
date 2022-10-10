package com.cg.exceptions;

public class StockDetailsNotFoundException extends Exception {
    public StockDetailsNotFoundException() {
        super();
    }

    public StockDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StockDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockDetailsNotFoundException(String message) {
        super(message);
    }

    public StockDetailsNotFoundException(Throwable cause) {
        super(cause);
    }
}
