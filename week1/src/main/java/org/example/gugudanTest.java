package org.example;

public class gugudanTest {
    public static void main(String[] args) {
        //구구단

        for (int i=2; i<=9; i++){
            System.out.print(i+"단"+"\t");
        }
        System.out.println();
        for(int i=1; i<=9; i++){
            for (int j=2; j<=9 ;j++ ){
                System.out.print(j+"x"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }

    }
}
