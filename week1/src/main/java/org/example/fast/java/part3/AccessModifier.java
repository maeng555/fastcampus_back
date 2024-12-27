package org.example.fast.java.part3;

import org.example.Model.Member2DTO;

public class AccessModifier {
    public static void main(String[] args) {
        Member2DTO dto =new Member2DTO();
        dto.name =" ??";
        dto.phone="0104128410";
        //age는 정보은닉 private 접근제한불가
    }
}
