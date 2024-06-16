package ecommerce.productservice.services;

import ecommerce.productservice.models.Category;
import ecommerce.productservice.models.Product;
import ecommerce.productservice.repositories.CategoryRepository;
import ecommerce.productservice.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService{

    ProductRepository productRepository;
    CategoryRepository productCategoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            category = productCategoryRepository.save(product.getCategory());
            product.setCategory(category);
        }
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new EntityNotFoundException("product not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }
}
