package components.mappers;

import components.DTO.RolePermissionDTO;
import components.classes.RolePermission;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionMapper {

    private final ModelMapper modelMapper;

    public RolePermissionMapper() {
        this.modelMapper = new ModelMapper();

    }

    public RolePermissionDTO toDto(RolePermission entity) {
        return modelMapper.map(entity, RolePermissionDTO.class);
    }

    public RolePermission toEntity(RolePermissionDTO dto) {
        return modelMapper.map(dto, RolePermission.class);
    }
}


