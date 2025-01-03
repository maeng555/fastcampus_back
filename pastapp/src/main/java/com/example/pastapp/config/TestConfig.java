package com.example.pastapp.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링어플리케이션을 실행하면 이런두가지 컨피그 , 빈은 자동객체생성 메모리로딩역할
public class TestConfig { // new testconfig 자동객체생성
    public TestConfig(){
        System.out.println("TestConfig");
    }
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
