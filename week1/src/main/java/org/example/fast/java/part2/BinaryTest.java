package org.example.fast.java.part2;

public class BinaryTest {
    public static void main(String[] args) {
        int a=10;
        float f = 35.6f;
        boolean b = false;
        char c = 'A';
        //java.lang.String
        String s = "APPLE";
        // binary test 69
        int decimal = 69;
        System.out.println("decimal = " + decimal);
        int binary  = 0b01000101; //2 진수
        System.out.println("binary = " + binary);
        int octal = 0105; //8 진수
        System.out.println("octal = " + octal);
        int hexa = 0x45; //16진수
        System.out.println("hexa = " + hexa);
        //binary exam
        int data =123;
        String binary2 = java.lang.Integer.toBinaryString(data); //2진수
        System.out.println("binary2 = " + binary2);
        String octal2 = Integer.toOctalString(data); //8진수 0173
        System.out.println("octal2 = " + octal2);
        String hexa2 = Integer.toHexString(data); //16진수  0x7b
        System.out.println("octal2 = " + hexa2);


    }
}
