package org.example.fast.java.part3;

import org.example.Model.PersonVO;

public class SetterGetterTest {
    public static void main(String[] args) {
        PersonVO p =new PersonVO();
        p.setName("meng");
        p.setAge(10);
        p.setPhone("0101111111");
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getPhone());
    }
}
