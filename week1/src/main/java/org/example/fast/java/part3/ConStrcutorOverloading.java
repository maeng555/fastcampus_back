package org.example.fast.java.part3;

import org.example.Model.PersonVO;

public class ConStrcutorOverloading {
    public static void main(String[] args) {
        PersonVO p =new PersonVO();
        PersonVO p1= new PersonVO("mengjin",11,"010");
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getPhone());
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
        System.out.println(p1.getPhone());
    }
}
