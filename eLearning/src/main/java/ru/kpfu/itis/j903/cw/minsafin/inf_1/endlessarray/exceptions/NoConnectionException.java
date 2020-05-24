package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

public class NoConnectionException extends Exception {
    public NoConnectionException() {
        super();
    }

    public NoConnectionException(String message) {
        super(message);
    }

    public NoConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoConnectionException(Throwable cause) {
        super(cause);
    }

    protected NoConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
