package org.example.fast.java.part2;

public class VDATest {
    public static void main(String[] args) {
        int a=10; //변수선언 기억공간 만들기   및 초기화
        int b= a;
       int c= b*10; //c - 100
        System.out.println("c = " + c);
        //누적합
        int sum  =0 ; //main 안에서의 변수선언 = 지역변수 -> 초기화를 무조건해야됨
        sum += 1;
        sum += 2;
        sum += 3 ;
        sum += 4;
        sum += 5; //규칙 = sum = sum + i  => 반복문 사용 for문 while문
        System.out.println("sum = " + sum);
        //swap 값을교환
        int x =10;
        int y=20;
        System.out.println("x="+x+":"+ "y=" + y);
        //tmp 사용
        int tmp;
        tmp = y;
        y=x;
        x=tmp;
        System.out.println("x="+x+":"+ "y=" + y);


    }
}
