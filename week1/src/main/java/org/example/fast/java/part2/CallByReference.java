package org.example.fast.java.part2;

public class CallByReference {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int result=add(a);
        System.out.println("result = " + result);
    }
    public static int add(int[] x){
        // 번지전달 배열 ,객체는 번지전달 핵심
        int sum=0;
        for (int i=0; i<x.length; i++){
            sum +=x[i];

        }
        return sum;
    }
}
