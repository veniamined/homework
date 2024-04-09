package components.Services.Impl;

import components.DTO.ProductCategoryDTO;
import components.Services.ProductCategoryService;
import components.entity.ProductCategory;
import components.mappers.ProductCategoryMapper;
import components.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryDTO> getAll() {
        return productCategoryRepository.findAll().stream()
                .map(ProductCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO getById(Long id) {
        return ProductCategoryMapper.toDto(productCategoryRepository.findById(id).orElseThrow());
    }

    @Override
    public ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = ProductCategoryMapper.toEntity(productCategoryDTO);
        return ProductCategoryMapper.toDto(productCategoryRepository.save(productCategory));
    }

    @Override
    public ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = ProductCategoryMapper.toEntity(productCategoryDTO);
        productCategory.setId(id);
        return ProductCategoryMapper.toDto(productCategoryRepository.save(productCategory));
    }

    @Override
    public void delete(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
