package com.example.pastapp.service;

import com.example.pastapp.entity.Member;
import com.example.pastapp.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //이게 new homeserviceimpl 역할 컴포넌트스캔
public class HomeServiceimpl implements HomeService {
    public HomeServiceimpl(){
        System.out.println("HomeServiceimpl");
    }


    @Autowired
    private HomeRepository homeRepository;
    @Override
    public List<Member> memberList() {
        return homeRepository.findAll();
    }
}
