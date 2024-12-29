package org.example.fast.java.part3;

import org.example.Model.PersonVO;

public class ToStringPrint {
    public static void main(String[] args) {
        PersonVO p = new PersonVO("meng",12,"1232412");
        System.out.println(p.toString());
        System.out.println(p); //전체를 갖고오란말이 toString 이랑ㅇ똑같은기능
    }
}
