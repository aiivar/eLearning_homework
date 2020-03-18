package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

public class EndlessArrayNotInitializedException extends RuntimeException {
    public EndlessArrayNotInitializedException() {
        super();
    }

    public EndlessArrayNotInitializedException(String message) {
        super(message);
    }

    public EndlessArrayNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EndlessArrayNotInitializedException(Throwable cause) {
        super(cause);
    }

    protected EndlessArrayNotInitializedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
