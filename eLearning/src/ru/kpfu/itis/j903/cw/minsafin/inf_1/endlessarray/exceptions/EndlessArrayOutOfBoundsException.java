package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions;

//UNCHECKED
public class EndlessArrayOutOfBoundsException extends ArrayIndexOutOfBoundsException {
    public EndlessArrayOutOfBoundsException() {
    }

    public EndlessArrayOutOfBoundsException(int index) {
        super(index);
    }

    public EndlessArrayOutOfBoundsException(String s) {
        super(s);
    }

}
