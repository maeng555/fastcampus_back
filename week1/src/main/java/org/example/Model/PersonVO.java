package org.example.Model;

import org.example.fast.java.part3.Person;

public class PersonVO {
    private String name;
    private int age;
    private String phone;

    public PersonVO(){
        //디폴트 생성자 메소드
        this.name = "meng";
        this.age =10;
        this.phone="01034774747";
    }
    public PersonVO(String name, int age, String phone){
        this.name=name;
        this.age =age;
        this.phone=phone;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    //getter
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPhone(){
        return phone; //this.phone
    }

    public String toString(){
        return name+"\t"+this.age+"\t"+this.phone;
    }

}
