package com.example.SpringBootProjectPart3Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/product/{name}")
    public List<Product> getProductByName(@PathVariable("name") String pName) {
        return service.getProductByName(pName);
    }

    @PostMapping("/productByName")
    public List<Product> getProductByNameBody(@RequestBody Product p) {
        return service.getProductByName(p.getName());
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product p) {
        service.addProduct(p);
        return new ResponseEntity<>("Request was successful", HttpStatus.OK);
    }
}
