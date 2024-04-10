package components.mappers;

import components.dto.ProductCategoryDTO;
import components.entity.ProductCategory;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductCategoryDTO toDto(ProductCategory productCategory) {
        return modelMapper.map(productCategory, ProductCategoryDTO.class);
    }

    public static ProductCategory toEntity(ProductCategoryDTO productCategoryDTO) {
        return modelMapper.map(productCategoryDTO, ProductCategory.class);
    }
}
