package org.example;

public class ObjectArrayTest {
    public static void main(String[] args) {
        Book[] b = new Book[3]; //객체배열
        b[0]= new Book();
        b[0].title = "자바";
        b[0].price=3000;
        b[0].author="한빛";
        b[0].company="fastcampus";
        b[0].page=40;
        b[0].isbn="119211";
        //System.out.println(b[0].title+"\t"+b[0].price+"\t"+b[0].company);
        b[1]=new Book();
        b[1]= new Book();
        b[1].title = "인공지능";
        b[1].price=555500;
        b[1].author="박그";
        b[1].company="fastcampus";
        b[1].page=40;
        b[1].isbn="119211";
        //System.out.println(b[1].title+"\t"+b[1].price+"\t"+b[1].company);
        b[2]=new Book();
        b[2]= new Book();
        b[2].title = "세번쨎ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ";
        b[2].price=3000;
        b[2].author="한빛";
        b[2].company="fastcampus";
        b[2].page=40;
        b[2].isbn="119211";
       // System.out.println(b[0].title+"\t"+b[0].price+"\t"+b[0].company);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i].title+"\t"+b[i].price+"\t"+b[i].company);
        }

    }
}
