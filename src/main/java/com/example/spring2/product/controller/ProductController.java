package com.example.spring2.product.controller;

import com.example.spring2.common.Result;
import com.example.spring2.product.model.ProductDTO;
import com.example.spring2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Result getAllProducts() {
        return productService.getAllProducts();
    }



    @PostMapping
    public Result insertProduct(@RequestBody ProductDTO productDTO) {
        return productService.insertProduct(productDTO);
    }

    @GetMapping("{id}")
    public Result getbyIdProduct(@PathVariable long id) {
        return productService.getByIdProduct(id);
    }

    @PutMapping("{id}")
    public Result updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return productService.updateByProduct(id, productDTO);
    }

    @DeleteMapping("{id}")
    public Result deleteProduct(@PathVariable long id) {
        return productService.deleteByProduct(id);
    }


    // 모든 상품 조회
    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return productService.getAllProduct();
    }
}
