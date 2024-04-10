package components.services.impl;

import components.dto.ProductDTO;
import components.services.ProductService;
import components.entity.Product;
import components.mappers.ProductMapper;
import components.repositories.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        return ProductMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found  " + id)));
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found  " + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());

        return ProductMapper.toDto(productRepository.save(existingProduct));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
