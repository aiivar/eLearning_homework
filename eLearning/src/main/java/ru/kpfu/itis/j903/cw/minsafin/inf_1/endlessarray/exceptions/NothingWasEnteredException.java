package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

public class NothingWasEnteredException extends Exception {
    public NothingWasEnteredException() {
        super();
    }

    public NothingWasEnteredException(String message) {
        super(message);
    }

    public NothingWasEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public NothingWasEnteredException(Throwable cause) {
        super(cause);
    }

    protected NothingWasEnteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
