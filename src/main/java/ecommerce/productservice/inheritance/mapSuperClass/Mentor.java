package ecommerce.productservice.inheritance.mapSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_mentor")
public class Mentor extends User {
    private String companyName;
    private double avgRating;
}
