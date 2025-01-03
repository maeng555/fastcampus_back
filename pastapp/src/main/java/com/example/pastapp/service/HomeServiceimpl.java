package com.example.pastapp.service;

import org.springframework.stereotype.Service;

@Service //이게 new homeserviceimpl 역할 컴포넌트스캔
public class HomeServiceimpl implements HomeService {
    public HomeServiceimpl(){
        System.out.println("HomeServiceimpl");
    }
}
