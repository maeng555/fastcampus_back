package org.example.fast.java.part3;

import org.example.Model.CarDTO;

import java.util.Scanner;
public class CarTest {
    public static void main(String[] args) {
        //키보드로 입력받앙서 다른메소드로 이동
        Scanner  scan = new Scanner(System.in); //입력스트림
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
        carInfoPrint(car);


    }

    private static void carInfoPrint(CarDTO car) {
        System.out.println(car.carSn+"\t"+car.carName+"\t"+car.carPrice+"\t"+car.carOwner+"\t"+car.carYear+"\t"+car.carType);
    }

    //매게변수로 자동ㅇ차정보를 받아서 출력하는 메소드를 정의
    //public static void carInfoPrint(int carSn,String carName,int carPrice,String carOwner,int carYear,String carType){
       // System.out.println(carSn+"\t"+carName+"\t"+carPrice+"\t"+carOwner+"\t"+carYear+"\t"+carType);
    //} //이런 귀찮음을방지하기위해 모델 dto를 씀
}