package ecommerce.productservice.controllers;

import ecommerce.productservice.models.Product;
import ecommerce.productservice.services.ProductService;
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
        return new ArrayList<Product>();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return new Product();
    }

    @PatchMapping("/id")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return new Product();
    }

    @PutMapping("/id")
    public Product replaceProduct(@RequestBody Product product, @PathVariable Long id) {
        return new Product();
    }

    @DeleteMapping("/id")
    public void deleteProduct(@PathVariable Long id) {

    }
}
