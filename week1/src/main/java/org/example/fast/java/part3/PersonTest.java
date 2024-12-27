package org.example.fast.java.part3;

public class PersonTest {
    public static void main(String[] args) {
        //한 사람의 데이터를 저장을 변수를 선언하세요
        // 선언한뒤 person클래스를 정의한걸 하나의 구조로 만들기위해 그리고 변수가 저 구조를 참조하기위해 객체생성(new)
        //이 변수가 구조를 할당하면 - 인스턴스변수가된다
        Person p = new Person();

        p.name="맹";
        p.age=24;
        p.phone="101-222-333";

        System.out.println("p.name = " + p.name);
        p.paly();
        p.walk();
        p.eat();

    }
}
