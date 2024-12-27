package org.example.fast.java.part2;

public class ArrayMake {
    public static void main(String[] args) {
        //정수5개 들어갈 배열을 생성
        int[] a = new int[5];
        for (int i=0;i<a.length;i++){
            a[i]=10;
            System.out.println(a[i]);
        }

        float[] f = new float[5];  // 배열은 데이터메모리 한정
        Book[] b = new Book[3];// 이건 책이 ㅇ여러권을 표현
    }
}
