package ecommerce.productservice.services;

import ecommerce.productservice.dtos.FakeStoreProductDto;
import ecommerce.productservice.models.Category;
import ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertToFakeProductDto(product);
        fakeStoreProductDto = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreProductDto, FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        throw new RuntimeException();
//        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertToFakeProductDto(product);
        fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto, FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
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

    public FakeStoreProductDto convertToFakeProductDto(Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory()!= null? product.getCategory().getTitle() : null);
        return dto;
    }
}
