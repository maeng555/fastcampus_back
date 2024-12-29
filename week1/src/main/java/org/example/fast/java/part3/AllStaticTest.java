package org.example.fast.java.part3;

import org.example.Model.AllStatic;

public class AllStaticTest {
    public static void main(String[] args) {
       // AllStatic st = new AllStatic();
       // System.out.println(st.hap(10,20)); 스태틱이므로 좀 권고
        System.out.println(AllStatic.max(10,20));
        System.out.println(AllStatic.min(10,20));
        //아싸리 저 위에 주석을 못쓰게하려면 생성자를 private으로 인위적으로
    }
}
