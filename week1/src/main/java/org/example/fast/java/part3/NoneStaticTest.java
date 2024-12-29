package org.example.fast.java.part3;

public class NoneStaticTest {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        NoneStaticTest st = new NoneStaticTest();
        int sum =st.hap(a,b);
        System.out.println("sum = " + sum);
    }
    public int hap(int a, int b){ //원래는 스태틱을 자료형 옆에다붙히면 됌

        int v= a+b;
        return v;
    }
}
