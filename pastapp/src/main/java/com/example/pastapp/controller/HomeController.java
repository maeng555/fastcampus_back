package com.example.pastapp.controller;

import com.example.pastapp.entity.Member;
import com.example.pastapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired //서비스가필요해서! homeservie.~~
    private HomeService homeService;
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/memberList")
    public String memberList(Model model){
        List<Member> member= homeService.memberList();
        model.addAttribute("member",member); //포워딩할때 가져가기위해
        return "memberList";//view page(memberlist.html)
    }
}
