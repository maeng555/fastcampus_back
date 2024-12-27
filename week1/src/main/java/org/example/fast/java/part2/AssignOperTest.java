package org.example.fast.java.part2;

public class AssignOperTest {
    public static void main(String[] args) {
        // 복합대입연산자
        int a=1;
        a++;
        ++a;
        a=a+1;
        a+=1;
        System.out.println("a = " + a);
        //관계연산자
        int b=4;
        System.out.println(b>5);
        System.out.println(b<5);
        System.out.println(b==6);
        System.out.println(b!=4);
        System.out.println(3>=b);
        System.out.println(b<=5+b);
        //instance of 자식 부모 상속관계인지 비교할때 사용하는 bool
    }
}
