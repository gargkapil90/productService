package ecommerce.productservice.repositories;

import ecommerce.productservice.models.Product;
import ecommerce.productservice.projections.ProductTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductTitleAndDescription SomeRandomQuery(@Param("id") Long id);
}
