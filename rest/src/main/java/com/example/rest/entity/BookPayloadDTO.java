package com.example.rest.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookPayloadDTO {
    @NotBlank //유효성검사 필수로들어와야한다
    //필수입력항목
    @Schema(description = "book이름",example = "java의신 ",requiredMode = Schema.RequiredMode.REQUIRED)
    private String subject;
    @NotBlank
    private int price;
    @NotBlank
    private String author;
    @NotBlank
    private int page;

}
