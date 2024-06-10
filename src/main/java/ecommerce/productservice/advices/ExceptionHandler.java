package ecommerce.productservice.advices;

import ecommerce.productservice.dtos.ExceptionDto;
import ecommerce.productservice.exceptions.ProductLimitExceedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException() {
        System.out.println("something went wrong");
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitExceedException.class)
    public ResponseEntity<ExceptionDto> handleProductLimitExceedException() {
        System.out.println("something went wrong");
        ExceptionDto exceptionDto = new ExceptionDto("beyond limit", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
