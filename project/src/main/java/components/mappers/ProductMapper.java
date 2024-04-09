package components.mappers;

import components.DTO.ProductDTO;
import components.classes.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO toDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
