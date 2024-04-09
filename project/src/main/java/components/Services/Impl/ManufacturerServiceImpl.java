package components.Services.Impl;

import components.DTO.ManufacturerDTO;
import components.Services.ManufacturerService;
import components.entity.Manufacturer;
import components.mappers.ManufacturerMapper;
import components.repositories.ManufacturerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerDTO> getAll() {
        return manufacturerRepository.findAll().stream()
                .map(ManufacturerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerDTO getById(Long id) {
        return ManufacturerMapper.toDto(manufacturerRepository.findById(id).orElseThrow());
    }

    @Override
    public ManufacturerDTO create(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = ManufacturerMapper.toEntity(manufacturerDTO);
        return ManufacturerMapper.toDto(manufacturerRepository.save(manufacturer));
    }

    @Override
    public ManufacturerDTO update(Long id, ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = ManufacturerMapper.toEntity(manufacturerDTO);
        manufacturer.setId(id);
        return ManufacturerMapper.toDto(manufacturerRepository.save(manufacturer));
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

}
