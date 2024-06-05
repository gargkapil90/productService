package ecommerce.productservice.services;

import ecommerce.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProductById(Long id);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Product product);
}
