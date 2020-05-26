package ru.kpfu.itis.j903.cw.minsafin.inf_1;

import java.util.Objects;

public class TwoVariablesContainer<T1, T2> {
    private final T1 var1;
    private final  T2 var2;

    public TwoVariablesContainer(T1 var1, T2 var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public T1 getVar1Value() {
        return var1;
    }

    public T2 getVar2Value() {
        return var2;
    }

    public Class getVar1Type(){
        return var1.getClass();
    }

    public Class getVar2Type(){
        return var2.getClass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoVariablesContainer<?, ?> that = (TwoVariablesContainer<?, ?>) o;
        return Objects.equals(var1, that.var1) &&
                Objects.equals(var2, that.var2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(var1, var2);
    }
}
