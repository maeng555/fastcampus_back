package com.example.restful2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("str","hello spring boot");
        return "index";//index.html -> ${str}
    }
}
