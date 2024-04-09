package components.Services.Impl;

import components.DTO.ProductDTO;
import components.Services.ProductService;
import components.entity.Product;
import components.mappers.ProductMapper;
import components.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return ProductMapper.toDto(productRepository.findById(id).orElseThrow());
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        product.setId(id);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
