package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

//UNCHECKED
public class EndlessArrayNonExistentValueException extends RuntimeException {
    public EndlessArrayNonExistentValueException() {
    }

    public EndlessArrayNonExistentValueException(String message) {
        super(message);
    }

    public EndlessArrayNonExistentValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public EndlessArrayNonExistentValueException(Throwable cause) {
        super(cause);
    }

    public EndlessArrayNonExistentValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
