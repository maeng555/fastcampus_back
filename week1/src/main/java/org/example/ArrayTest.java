package org.example;

public class ArrayTest {
    public static void main(String[] args) {
        //실수 5개를 배열을생성해서 10씩 저장해라
        float[] f = new float[5];
        for (int i=0;i<f.length;i++){
            f[i]=10;
            System.out.println(f[i]);
        }
        // 정수 5개를 초기화하고 0번째와 3번재 인덱스 합
        int[] a={10,20,30,40,50}; //초기화
        for (int i=0;i<a.length;i++){

            System.out.println(a[i]);
        }
        int sum = a[0]+a[3];
        System.out.println("sum = " + sum);
        System.out.println(a.length);

        int[] b = new int[3];

        // 배열에 저장되어있는 APPLE를 소문자로 바꿔서 출력해보세요
        //여러개~ 는 배열 ex)int[]
        char[] c = {'A','P','P','L','E'};
        for (int i =0;i<c.length;i++){
            System.out.print((char)(c[i]+32)); //아스키코드 이용
        }

    }
}
