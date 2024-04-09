package components.CRUDservices;

import components.DTO.ManufacturerDTO;

import java.util.List;

public interface ManufacturerService {

    List<ManufacturerDTO> getAll();

    ManufacturerDTO getById(Long id);

    ManufacturerDTO create(ManufacturerDTO manufacturerDTO);

    ManufacturerDTO update(Long id, ManufacturerDTO manufacturerDTO);

    void delete(Long id);

}
