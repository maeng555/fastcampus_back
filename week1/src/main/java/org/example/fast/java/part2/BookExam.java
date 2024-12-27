package org.example.fast.java.part2;

public class BookExam {
    public static void main(String[] args) {
        Book b = new Book();  //객체 즉 인스턴트변수 생성 이거는 인스턴스를 가리키는 참조변수
        b.title ="자바";
        b.price=3000;
        b.company="패스트캠퍼스";
        b.author="male";
        b.page=300;
        b.isbn="119110";
        System.out.println(b.title+"\t"+b.price+"\t"+b.company);

    }
}
