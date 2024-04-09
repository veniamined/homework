package components.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductCategories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
