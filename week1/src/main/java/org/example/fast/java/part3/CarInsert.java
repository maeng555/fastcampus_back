package org.example.fast.java.part3;

import org.example.Model.CarDAO;
import org.example.Model.CarDTO;

import java.util.Scanner;

public class CarInsert {
    public static void main(String[] args) {
        //자동차 정보를 키보드를 부터 입력받아 저장 하세요
        //키보드로 입력받앙서 다른메소드로 이동
        Scanner scan = new Scanner(System.in); //입력스트림
        System.out.println("자동차일련번호");
        int carSn = scan.nextInt();
        scan.nextLine();
        System.out.println("자동차이름");
        String carName= scan.nextLine();
        System.out.println("자동차가격");
        int carPrice= scan.nextInt();
        scan.nextLine();
        System.out.println("자동차소요자");
        String carOwner= scan.nextLine();
        System.out.println("자동차년식");
        int carYear= scan.nextInt();
        scan.nextLine();
        System.out.println("자동차타입");
        String carType= scan.nextLine();

        //System.out.println(carSn+"\t"+carName+"\t"+carPrice+"\t"+carOwner+"\t"+carYear+"\t"+carType);

        //

        // carInfoPrint( carSn, carName, carPrice, carOwner, carYear, carType);
        CarDTO car = new CarDTO();
        car.carName = carName;
        car.carSn = carSn;
        car.carPrice=carPrice;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;

        CarDAO dao = new CarDAO();
        dao.carInsert(car);
    }
}
