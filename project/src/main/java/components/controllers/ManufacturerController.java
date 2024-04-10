package components.controllers;

import components.dto.ManufacturerDTO;
import components.services.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerDTO>> getAll() {
        List<ManufacturerDTO> manufacturers = manufacturerService.getAll();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> getById(@PathVariable Long id) {
        ManufacturerDTO manufacturer = manufacturerService.getById(id);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ManufacturerDTO> create(@Valid @RequestBody ManufacturerDTO manufacturerDTO) {
        ManufacturerDTO createdManufacturer = manufacturerService.create(manufacturerDTO);
        return new ResponseEntity<>(createdManufacturer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> update(@PathVariable Long id, @Valid @RequestBody ManufacturerDTO manufacturerDTO) {
        ManufacturerDTO updatedManufacturer = manufacturerService.update(id, manufacturerDTO);
        return new ResponseEntity<>(updatedManufacturer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        manufacturerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
