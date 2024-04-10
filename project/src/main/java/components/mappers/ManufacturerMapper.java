package components.mappers;

import components.dto.ManufacturerDTO;
import components.entity.Manufacturer;
import org.modelmapper.ModelMapper;

public class ManufacturerMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ManufacturerDTO toDto(Manufacturer manufacturer) {
        return modelMapper.map(manufacturer, ManufacturerDTO.class);
    }

    public static Manufacturer toEntity(ManufacturerDTO manufacturerDTO) {
        return modelMapper.map(manufacturerDTO, Manufacturer.class);
    }
}
