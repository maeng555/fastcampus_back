package org.example;

public class TwoArrayTest {
    public static void main(String[] args) {
        int[][] a = new int[2][4];
        a[0][0] = 10;
        a[0][1] = 20;
        a[0][2] = 30;
        a[0][3] = 40;
        a[1][0] = 50;
        a[1][1] = 60;
        a[1][2] = 70;
        a[1][3] = 80;
        System.out.println(a[0][1]);

        //실습2
        int[][] b = {
                {1, 2, 3, 4},{5,6,7,8}
        };
        for (int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println(); //줄바꿈
        }
        int[][] c =new int[5][]; //가변만들기
        c[0]=new int[1];
        c[1]=new int[2];
        c[2]=new int[3];
        c[3]=new int[4];
        c[4]=new int[5];
        for (int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                c[i][j]='&';
                System.out.print((char)(c[i][j])+"\t");
            }
            System.out.println(); //줄바꿈
        }

    }
}
