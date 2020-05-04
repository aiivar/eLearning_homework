package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

public class NonExistentPathException extends Exception {
    public NonExistentPathException() {
        super();
    }

    public NonExistentPathException(String message) {
        super(message);
    }

    public NonExistentPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistentPathException(Throwable cause) {
        super(cause);
    }

    protected NonExistentPathException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
