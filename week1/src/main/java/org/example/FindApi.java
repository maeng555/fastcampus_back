package org.example;

public class FindApi {
    public static void main(String[] args) {
        int a=10; //기본자료형은 컴파일러가 찾음
        System.out.println("a = " + a);
        java.lang.String s; //컴파일러가 찾고 없으면 클래스들의집합 api 제공에서 찾아봄(external libary)
        s="apple";
        System.out.println("s = " + s);
        System.out.println(s.length()); //길이 메소드


    }
}
