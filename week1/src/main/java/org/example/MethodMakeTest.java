package org.example;

public class MethodMakeTest {
    public static void main(String[] args) {
        //add 메소드 호출 
        int a=3;
        int b=5;
        int result =0;
        result = add(a,b);
        System.out.println("result = " + result);
    }
    //별도의메소드 이제부터 만들기
    //매개변수로 2개의 정수를 받아서 총합을 구하는 리턴 메소드정의 하세요 
    public static int add(int a, int b){ // Static은 같은 스태틱이 있어야 호출 반환이가능하다
        int sum = a+b;
        return sum;
    }
}
