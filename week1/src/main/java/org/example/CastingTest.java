package org.example;

public class CastingTest {
    public static void main(String[] args) {
        float f1 = .10f;
        System.out.println("f1 = " + f1);
        float f2 =15f;
        System.out.println("f2 = " + f2);
        float f3 =3.14f;
        System.out.println("f3 = " + f3);
        double d1 = 123.456;
        System.out.println("d1 = " + d1);

        float x=15.6f;
        int y = (int)x;
        System.out.println("y = " + y); //타입이다르기때문에 강제형변환 (손실)
        char c = 'A';
        int cc = c;
        System.out.println("cc = " + cc); //자동형변환 큰바이트로 바꾸기에

        int dd = 5;
        double ddd= dd;
        System.out.println("ddd = " + ddd); //자동

        double dx =14.67;
        int dxx = (int)dx;
        System.out.println("dxx = " + dxx);

    }
}
