package org.example;

public class CharExam {
    public static void main(String[] args) {
        //한글을 표기하기위해 유니코드 utf-8을 쓴다
        char c = 'A';
        System.out.println("c = " + c);
        int a ='A';
        System.out.println("a = " + a); //수치 자료로 인식하기에 가능
        int b ='B'+1;
        System.out.println("(char)b = " + (char)b); //형변환 
        char han = '가';
        System.out.println("han = " + han);
        int hand = '가'; //44032 유니코드
        System.out.println(hand);
        int hanU = '\uAC00';
        System.out.println("hanU = " + hanU);
        char upper = 'A';
        char lower = (char)(upper+32);
        System.out.println("lower = " + lower);

        //'1' +'2' = 3 이 나오게 '0' =48
        char i ='1'; //49-48
        char j ='2'; //50-48
        int sum = (i-'0')+(j-'0'); //3
        System.out.println("sum = " + sum);
    }
}
