package org.example;
import java.util.*; //스캐너 객체를 쓰겟다 스트링도물론
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int num = scan.nextInt(); //블록상태
        System.out.println("num = " + num);

        System.out.print("실수 입력하세요:");
        float f = scan.nextFloat();
        System.out.println("f = " + f);

        System.out.print("문자 입력:");
        String str = scan.next(); //공백 전까지
        System.out.println("str = " + str);

        scan.nextLine(); //버퍼비우기

        System.out.print("문자 입력:");
        String str1 = scan.nextLine(); //공백 전까지
        System.out.println("str = " + str1);
        scan.close();

    }
}
