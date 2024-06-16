package ecommerce.productservice.inheritance.mapSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_ta")
public class TA extends User {
    private int number_of_session;
    private float rating;
}
