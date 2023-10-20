package com.company;

public class Main {

    public static void main(String[] args) {
        int gradeBook = 1324;
        int C2 = gradeBook%2;
        int C3 = gradeBook%3;
        int C5 = gradeBook%5;
        int C7 = gradeBook%7;
        int C = C3;
        short a =4;
        short b =6;
        short n= 8;
        short m = 11;
        System.out.println("C2="+C2+", C3="+ C3+", C5="+C5+", C7="+C7);
        try {
            Calculator calculator = new Calculator(C, a, b,n,m);
            System.out.println("Result: "+calculator.calculator());
        }catch (NumberFormatException e){
            System.out.println( e.getMessage());
        }

    }
}
