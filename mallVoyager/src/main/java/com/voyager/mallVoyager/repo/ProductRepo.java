package com.voyager.mallVoyager.repo;

import com.voyager.mallVoyager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);
}
