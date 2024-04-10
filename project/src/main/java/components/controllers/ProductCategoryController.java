package components.controllers;

import components.dto.ProductCategoryDTO;
import components.services.ProductCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> getAll() {
        List<ProductCategoryDTO> productCategories = productCategoryService.getAll();
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getById(@PathVariable Long id) {
        ProductCategoryDTO productCategory = productCategoryService.getById(id);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDTO> create(@Valid @RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategoryDTO createdProductCategory = productCategoryService.create(productCategoryDTO);
        return new ResponseEntity<>(createdProductCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> update(@PathVariable Long id, @Valid @RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategoryDTO updatedProductCategory = productCategoryService.update(id, productCategoryDTO);
        return new ResponseEntity<>(updatedProductCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
