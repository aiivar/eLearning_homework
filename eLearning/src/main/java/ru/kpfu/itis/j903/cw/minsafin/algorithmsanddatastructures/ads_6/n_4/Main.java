package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_6.n_4;

public class Main {
    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        long n1 = 12345678;
        long n2 = 98765432;
        System.out.println(karatsuba.multiply(n1, n2));
    }
}
