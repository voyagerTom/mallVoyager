package com.voyager.mallVoyager.controller;

import com.voyager.mallVoyager.entity.Product;
import com.voyager.mallVoyager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = null;
        createdProduct = productService.addProduct(product);
        if (createdProduct == null) {
            return new ResponseEntity<>(product, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {

        Product product=productService.getProductById(id);
        if (product == null) {
            product=new Product();
            product.setName("product sold out or not on s");
            product.setId(id);
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
}
