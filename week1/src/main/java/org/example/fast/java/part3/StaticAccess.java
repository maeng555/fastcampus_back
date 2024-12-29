package org.example.fast.java.part3;

import org.example.Model.MyUtil;

public class StaticAccess {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int sum =MyUtil.hap(a,b);
        System.out.println("sum = " + sum); //myutil은 스태틱 메소드이므로 클래스호출로 가능 객체생성없이
    }
}
