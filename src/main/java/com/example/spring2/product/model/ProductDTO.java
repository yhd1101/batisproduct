package com.example.spring2.product.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Alias(value = "product")
@Getter
public class ProductDTO {
    private long id;                // PK
    private String name;            // 상품 이름
    private String content;         // 상품 설명
    private int price;              // 가격
    private String productImg;      // 상품 이미지
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public void setId(long id) {
        this.id = id;
    }
}