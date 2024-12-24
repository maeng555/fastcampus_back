package org.example;

public class overloading {
    public static void main(String[] args) {
        float f= add(35.6f,37.6f);
        System.out.println("f = " + f);
    }
    // 정수 add
    public static int add(int a, int b){
        int sum = a+b;
        return sum;
    }
    //실수 add
    public static float add(float a, float b){
        float sum = a+b;
        return sum;
    }
}
