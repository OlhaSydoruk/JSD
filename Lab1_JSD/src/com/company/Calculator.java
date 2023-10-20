package com.company;

public class Calculator {
    private int C;
    private short a;
    private short b;
    private short n;
    private short m;
    private int result=0;
    public Calculator( int c, short a, short b, short n, short m) {
        C = c;
        this.a = a;
        this.b = b;
        this.n = n;
        this.m = m;
    }

    public int calculator() {
        if (n < a || m < b || a < 0 || b < 0 || n < 0 || m < 0) {
            return result;
        } else if ( a > -C || n < -C) {

            for (short i =  a; i <=  n; i++) {
                int num =i + C;
                for (short j =  b; j <= m; j++) {
                    result += (short) ((i - j) / num);
                }
            }
            return result;
        } else {
            throw new NumberFormatException();
        }

    }
}
