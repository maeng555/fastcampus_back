package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class ifBasicTest {
    public static void main(String[] args) {
        int x=10;

        if(x>0){
            System.out.println("양수입니다");
        }
        System.out.println("종료");
        //정수1개를 받아 입력된 수가 7의배수인지확인 출력
        Scanner scan = new Scanner(System.in);
        System.out.println("정수를 입력");
        int num = scan.nextInt();
        if(num%7==0){
            System.out.println("num = " +num+"7의배수입니다");

        }else{
            System.out.println("배수가아님");
        }
        //정수1개입력을받아 짝수 홀수 판단
        Scanner scan2 = new Scanner(System.in);
        System.out.println("정수를 입력");
        int su = scan2.nextInt();
        if(su%2 ==0){
            System.out.println("짝수");
        }else{
            System.out.println("홀수");
        }

        //4의배수이면서 100배수해이거나 400배수 인해 , 29일이존재 == 윤년
        Scanner scan3 = new Scanner(System.in);
        System.out.println("년도를 입력하세요:");
        int year = scan3.nextInt();
        if((year%4==0&&year%100==0)||(year%400==0)){
            System.out.println("윤년입니다");
        }else{
            System.out.println("윤년이아닙니다");
        }




    }
}
