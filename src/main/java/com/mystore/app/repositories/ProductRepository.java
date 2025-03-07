package com.mystore.app.repositories;

import com.mystore.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByNameContainsIgnoreCase(String name);

    public List<Product> findByCategoryContainsIgnoreCase(String name);

    public List<Product> findByPriceBetween(Double min, Double max);

    public List<Product> findByStockQuantityBetween(Integer min, Integer max);
}
