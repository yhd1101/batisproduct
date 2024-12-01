package com.example.spring2.product.repository;

import com.example.spring2.product.model.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO> findAll();

    //특정상품
    ProductDTO findById(long id);


    //상품저장
   void save(ProductDTO productDTO);

   int update(ProductDTO productDTO);

    int delete(Long id);
}
