package ecommerce.productservice.exceptions;

public class ProductLimitExceedException extends Exception {

    public ProductLimitExceedException(String message) {
        super(message);
    }
}
