package org.example.fast.java.part2;

public class SwitchTest {
    public static void main(String[] args) {
        //요일에 해당하는 운동 스위치문
        String day = "ㅇ";
        switch (day){
            case "Sunday":
                System.out.println("야구하기");
                break;

            case "Monday":
                System.out.println("농구하기");
                break;
            default:
                System.out.println("휴식");


        }
    }
}
