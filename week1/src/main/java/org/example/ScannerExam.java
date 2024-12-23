package org.example;
import java.util.Scanner;
public class ScannerExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("제목 :");
        String title=scan.nextLine();
        System.out.println("title = " + title);

        System.out.print("가격 :");
        int price=scan.nextInt();
        System.out.println("price = " + price);

        scan.nextLine();

        System.out.print("출판사 :");
        String company=scan.nextLine();
        System.out.println("company = " + company);

        System.out.print("저자 :");
        String author=scan.nextLine();
        System.out.println("author = " + author);

        System.out.print("page :");
        int page=scan.nextInt();
        System.out.println("page = " + page);

        scan.nextLine();

        System.out.print("isbn :");
        String isbn=scan.nextLine();
        System.out.println("isbn = " + isbn);

        scan.close();



    }
}
