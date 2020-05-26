package ru.kpfu.itis.j903.cw.minsafin.inf_2.numberwithgenerics;

import java.util.Objects;

public class ComplexNumber implements Number<ComplexNumber> {
    private double re;
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public ComplexNumber sum(ComplexNumber num) {
        return new ComplexNumber(this.re + num.re, this.im + num.im);
    }

    @Override
    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.re - num.re, this.im - num.im);
    }

    @Override
    public ComplexNumber div(ComplexNumber num) {
        return new ComplexNumber((this.re * num.re + this.im * num.im) / (num.re * num.re + num.im + num.im), this.im + num.im);
    }

    @Override
    public ComplexNumber mult(ComplexNumber num) {
        return new ComplexNumber(this.re * num.re - this.im * num.im, this.re * num.im + this.im * num.re);
    }

    @Override
    public ComplexNumber getValue() {
        return this;
    }

    private double absComplex(){
        return Math.sqrt(re*re+im*im);
    }

    @Override
    public int compareTo(ComplexNumber o) {
        return (int) (absComplex()-o.absComplex());
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
