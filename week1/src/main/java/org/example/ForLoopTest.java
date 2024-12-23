package org.example;

public class ForLoopTest {
    public static void main(String[] args) {
        //반복문을 이용하여 알파벳 대문자와 아스키코드값을 출력하세요
        for (int i=1;i<=10;i++){
            System.out.println(i);
        }
        for (char c='A';c<='Z';c++){
            System.out.println(c+":"+(int)c);
        }
        for (char c='a';c<='z';c++){
            System.out.println(c+":"+(int)c);
        }
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        for (int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
        //foreach
        for(int su:numbers){
            System.out.println(su);
        }
    }
}
