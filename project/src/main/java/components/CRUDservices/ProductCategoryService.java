package components.CRUDservices;

import components.DTO.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryDTO> getAll();

    ProductCategoryDTO getById(Long id);

    ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO);

    ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO);

    void delete(Long id);

}
