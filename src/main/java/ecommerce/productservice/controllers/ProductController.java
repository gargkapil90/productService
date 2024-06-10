package ecommerce.productservice.controllers;

import ecommerce.productservice.exceptions.ProductLimitExceedException;
import ecommerce.productservice.models.Product;
import ecommerce.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductLimitExceedException {
        if(id > 100){
            throw new ProductLimitExceedException("id is beyond limtis");
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/id")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/id")
    public Product replaceProduct(@RequestBody Product product, @PathVariable Long id) {
        return new Product();
    }

    @DeleteMapping("/id")
    public void deleteProduct(@PathVariable Long id) {

    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException() {
//        System.out.println("something went wrong");
//        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
