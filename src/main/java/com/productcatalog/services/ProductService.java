package com.productcatalog.services;

import com.productcatalog.model.Product;
import com.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv1")
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping("/products")
        public List<Product> getAllProducts() {
                return productRepository.findAll();
        }

        @GetMapping("/products/{code}")
        public Product getProductByCode(@PathVariable("code") String code) {
                return productRepository.findByCode(code);
        }

        @PostMapping("/products/add")
        public List<Product> addProducts(@RequestBody List<Product> products) {
                return productRepository.saveAll(products);
        }

        @PutMapping("/products/update/{code}")
        public ResponseEntity<String> updateProduct(@PathVariable("code") String code, @RequestBody Product product) {

                Product isProductExist = productRepository.findByCode(code);

                if(isProductExist == null) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Product with code " + code + " does not exist.");
                }

                int updateProduct =  productRepository.updateByCode(code, product.getCode(), product.getName(), product.getCategory(), product.getBrand(), product.getType(), product.getDescription());

                if (updateProduct == 0) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Failed to update product with code " + code);
                } else {
                        return ResponseEntity.ok("Product with code " + code + " updated successfully.");
                }

        }

        @DeleteMapping("/products/delete/{code}")
        public ResponseEntity<String> deleteProduct(@PathVariable("code") String code) {

                Product isProductExist = productRepository.findByCode(code);

                if(isProductExist == null) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Product with code " + code + " does not exist.");
                }

                productRepository.deleteByCode(code);

                return ResponseEntity.ok("Product with code " + code + " deleted successfully.");

        }

}
