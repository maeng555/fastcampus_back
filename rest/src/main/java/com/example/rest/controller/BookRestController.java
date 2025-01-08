package com.example.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "User API", description = "User API 입니다.")


public class BookRestController {
    //rest->get - http:/localhost:8081/api/test
    @GetMapping("/test")
    @Tag(name = "User API")
    @Operation(summary = "User 조회", description = "User 정보를 조회합니다.")
    public String test(){
        return "hello word"; //응답 (json)
    }


}
