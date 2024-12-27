package org.example.fast.java.part3;

import org.example.Model.CarDTO;
import org.example.Model.CarUtil;

public class CarUtiltyTest {
    public static void main(String[] args) {
        int carSn = 123;
        String carName ="meng";
        int carPrice = 1233444;
        String carOwner ="dzzdda";
        int carYear=123454536;
        String carType="g";

        CarDTO car = new CarDTO();
        car.carName = carName;
        car.carSn = carSn;
        car.carPrice=carPrice;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;
        CarUtil util = new CarUtil();
        util.carPrint(car);
        //carPrint(car);


    }



}
