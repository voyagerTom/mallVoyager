package com.voyager.mallVoyager.service;

import com.voyager.mallVoyager.entity.Product;
import com.voyager.mallVoyager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductService {


    @Autowired
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public String deleteProduct(Long id){
        productRepo.deleteById(id);
        return "Product deleted successfully";
    }

    public Product getProductById(Long id) throws Exception{
        Optional<Product> opt = productRepo.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }
}