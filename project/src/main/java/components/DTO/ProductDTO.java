package components.DTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Long categoryId; // Внешний ключ для ProductCategory
    private Long manufacturerId; // Внешний ключ для Manufacturer

    public ProductDTO(Long id, String name, BigDecimal price, String description, ProductCategoryDTO dto, ManufacturerDTO dto1) {
    }

}
