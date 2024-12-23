package org.example;

public class MinMaxValue {
    public static void main(String[] args) {
        int a =10;
        int b =20;
        int min = (a<b)?a:b;
        System.out.println("min = " + min);
        
        int max =(a>b)? a:b;
        System.out.println("max = " + max);
    }
}