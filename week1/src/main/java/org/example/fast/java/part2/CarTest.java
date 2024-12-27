package org.example.fast.java.part2;

public class CarTest {
    public static void main(String[] args) { //java Se
        String model = "bmw528i";
        System.out.println("model =" + model);
        //string은 기본자료형이 아닌 사용자저의 객체클래스 자료형이다 External libraries 가 기본적 자바api제공해주는 역할 여기에 string도포함
        long distance = 100000L;
        System.out.println("distance = " + distance);
        int price = 9000000;
        System.out.println("price = " + price);
        char type ='A';
        System.out.println("type = " + type);
        boolean auto = true;
        System.out.println("auto = " + auto);
        int year =2000;
        System.out.println("year = " + year);
        float gasmi =12.5f;
        System.out.println("gasmi+\"l\" = " + gasmi+"l");
        // 이렇게 차하나에 독립적입 변수가 필요한가? car class 를따로만든다


    }
}
