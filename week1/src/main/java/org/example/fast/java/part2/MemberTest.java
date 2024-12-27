package org.example.fast.java.part2;

public class MemberTest {
    public static void main(String[] args) {
        Member m =new Member();
        m.name="홍길동";
        m.age= 24;
        m.tel="010-111-1111";
        m.email="mjy5188@naver,com";
        m.addr="seoul";
        m.weight=57.6f;
        System.out.println(m.name+"\t"+m.age+"\t"+m.tel+"\t"+m.email+"\t"+m.addr+"\t"+m.weight);


    }
}
