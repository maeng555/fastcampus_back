package org.example;

public class ApiOverloading {
    public static void main(String[] args) {
        int max =maxValue(7,9);
        System.out.println("max = " + max);

        int min =minValue(3,8);
        System.out.println("min = " + min);
    }
    public  static  int maxValue(int a, int b){
        return (a>b)?a:b;
    }
    public  static  int minValue(int a, int b){
        return (a<b)?a:b;
    }
}
