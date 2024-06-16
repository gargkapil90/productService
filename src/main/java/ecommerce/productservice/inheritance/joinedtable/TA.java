package ecommerce.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@Entity(name = "jt_ta")
public class TA extends User {
    private int number_of_session;
    private float rating;
}
