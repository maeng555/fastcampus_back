package org.example.fast.java.part3;

//import org.example.Model.CarDAO;
//import org.example.Model.CarDTO;
import org.example.Model.*;
import java.util.Scanner;
import java.lang.*; //defalut package이다
public class PackageNameTest {
    public static void main(String[] args) {
        String str ="meng"; //java.lang.String
        Scanner scan = new Scanner(System.in); //java.lang.util
        System.out.println("Hellowold"); //java.lang.System

        CarDTO car = new CarDTO(); //import Model에서 끌고옴
        CarDAO dao = new CarDAO();

    }
}
