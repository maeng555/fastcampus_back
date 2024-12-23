package org.example;

public class LoopLoopTest {
    public static void main(String[] args) {
        int index =1;
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                System.out.println(index);
                index++;
            }
        }
        int[][] a ={{1,2,3,4,5},{1,2,3,4,5}};

        for (int i=0;i<a.length;i++){ //행
            for (int j=0;j<a[i].length;j++){ //열
                System.out.print(a[i][j]+"\t");
            }
            System.out.println(); //줄바꿈
        }
    }
}
