package org.example.fast.java.part3;

public class PersonAccessTest {
    public static void main(String[] args) {
        Person p =new Person();
        p.name = "홍길동";
        p.age = 1000;
        p.phone="01033233";
        System.out.println(p.name+"\t"+p.age+"\t"+p.phone);

    }
}
