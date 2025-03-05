package com.mystore.app.rest;

import com.mystore.app.entity.Product;
import com.mystore.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product) {
        Product p = productService.addProduct(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product p = productService.getProduct(id);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @Valid @RequestBody Product product) {
        Product p = productService.updateProduct(id, product);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
        String message = productService.deleteProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // TODO: API to search products by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByProductName(@RequestParam("name") String name) {
        List<Product> products = productService.searchByProductName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /*
    // TODO: API to filter products by category
    @GetMapping("/filter/category")
    public ResponseEntity<List<Product>> filterByProductCategory(@RequestParam("category") String category) {
        List<Product> products = productService.filterByProductCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    */

    // TODO: API to filter products by price range
    @GetMapping("filter/price")
    public ResponseEntity<List<Product>> filterByProductPrice(@RequestParam("minPrice") Double minPrice, @RequestParam("maxPrice") Double maxPrice) {
        List<Product> products = productService.filterByProductPrice(minPrice, maxPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /*
    // TODO: API to filter products by stock quantity range
    @GetMapping("filter/stock")
    public ResponseEntity<List<Product>> filterByProductStockQuantity(@RequestParam("minStock") Integer minStock, @RequestParam("maxStock") Integer maxStock) {
        List<Product> products = productService.filterByProductStockQuantity(minStock, maxStock);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

     */

}
