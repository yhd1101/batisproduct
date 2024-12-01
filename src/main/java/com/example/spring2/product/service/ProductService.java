package com.example.spring2.product.service;

import com.example.spring2.common.Result;
import com.example.spring2.common.ResultCode;
import com.example.spring2.product.model.ProductDTO;
import com.example.spring2.product.repository.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;


    public Result getAllProducts() {
        try {
            List<ProductDTO> product  = productMapper.findAll();
            return  new Result(ResultCode.SUCCESS, product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  new Result(ResultCode.DB_ERROR);
        }
    }

    public Result insertProduct(ProductDTO productDTO) {
        try{
            productMapper.save(productDTO);
            return new Result(ResultCode.SUCCESS, productDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(ResultCode.FAIL_TO_SAVE_PRODUCT);
        }
    }

    public Result getByIdProduct(long id) {
        try {
            ProductDTO productDTO = productMapper.findById(id);
            if (productDTO == null) {
                return new Result(ResultCode.PRODUCT_NOT_FOUND);
            }
            return new Result(ResultCode.SUCCESS, productDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(ResultCode.DB_ERROR, e.getMessage());
        }
    }

    public Result updateByProduct(long id, ProductDTO productDTO) {
        try {
            productDTO.setId(id);

            int updatedRows = productMapper.update(productDTO);

            if (updatedRows == 0) {
                return new Result(ResultCode.PRODUCT_NOT_FOUND);
            }

            return new Result(ResultCode.SUCCESS, productDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(ResultCode.DB_ERROR);
        }

    }

    public Result deleteByProduct(long id) {
        try{
            int delete = productMapper.delete(id);
            if (delete == 0) {
                return  new Result(ResultCode.PRODUCT_NOT_FOUND);
            }
            return  new Result(ResultCode.SUCCESS, "Product delete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(ResultCode.DB_ERROR);
        }
    }

//    public Result getByIdProduct(long id) {
//        try{
//            Optional<ProductDTO> optionalProductDTO = productMapper.findById(id);
//            if(optionalProductDTO.isEmpty()) {
//                return new Result(ResultCode.PRODUCT_NOT_FOUND);
//            }
//            ProductDTO productDTO = optionalProductDTO.get();
//            return new Result(ResultCode.SUCCESS, productDTO);
//
//        } catch (Exception e) {
//            return  new Result(ResultCode.DB_ERROR);
//        }
//    }


    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        try {
            // MyBatis를 통해 모든 상품 조회
            List<ProductDTO> products = productMapper.findAll();

            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // HTTP 204
            }

            return ResponseEntity.ok(products); // HTTP 200 + 데이터 반환
        } catch (Exception e) {
            // 예외 발생 시 에러 응답
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // HTTP 500
        }
    }


}
