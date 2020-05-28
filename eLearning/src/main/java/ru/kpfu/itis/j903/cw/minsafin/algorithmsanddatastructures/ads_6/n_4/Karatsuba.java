package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_6.n_4;

public class Karatsuba {

    private int numberSize(long number) {
        return String.valueOf(number).length();
    }

    public long multiply(long n1, long n2) {
        int n = Math.min(numberSize(n1), numberSize(n2));
        if (n < 4) {
            return n1 * n2;
        }
        n = n / 2;
        long x = (long) Math.pow(10, n);
        long k1, k2, k3, k4;
        // Первое число
        k1 = n1 / x;
        k2 = n1 % x;
        // Второе число
        k3 = n2 / x;
        k4 = n2 % x;
        long ml1, ml2, ml3;
        ml1 = multiply(k1, k3);
        ml2 = multiply(k1 + k2, k3 + k4);
        ml3 = multiply(k2, k4);
        return ml1 * x * x + (ml2-ml1-ml3) * x + ml3;
    }
}
