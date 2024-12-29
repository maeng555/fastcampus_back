package org.example.Model;

public class AllStatic {
    private AllStatic(){} //이렇게하면 객체생성을 막음 system math 함수도 이런 원리
    public static int hap(int a, int b){
        int v= a+b;
        return v;
    }
    public static int max(int a, int b){
        return a>b?a:b;
    }
    public static int min(int a, int b){
        return a<b?a:b;
    }
}
