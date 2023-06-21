package com.example.sportmarket.controller.product;

import com.example.sportmarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("all")
    public Page<ProductDTO> productList(Pageable pageable){
        return service.getAllProducts(pageable);
    }

    @GetMapping("search")
    public Page<ProductDTO> productList(@RequestParam String name, Pageable pageable){
        return service.search(name, pageable);
    }

}
