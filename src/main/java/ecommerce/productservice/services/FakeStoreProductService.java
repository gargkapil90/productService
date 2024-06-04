package ecommerce.productservice.services;

import ecommerce.productservice.dtos.FakeStoreProductDto;
import ecommerce.productservice.models.Category;
import ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    private Product convertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setDescription(fakeStoreProductDto.getDescription());
        return product;
    }
}
