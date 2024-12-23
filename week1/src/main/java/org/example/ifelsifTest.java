package org.example;

public class ifelsifTest {
    public static void main(String[] args) {
        int jumsu =198;
        if (jumsu>=0 && jumsu<=100) {
            if (jumsu >= 90) {
                System.out.println("a반");
            } else if (jumsu >= 85) {
                System.out.println("b반");
            } else if(jumsu>=80) {
                System.out.println("c반");
            }else {
                System.out.println("불합격");
            }
        }else {
            System.out.println("유효한 점수 아닙니다");
        }

    }
}
