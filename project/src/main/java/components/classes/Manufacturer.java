package components.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

}
