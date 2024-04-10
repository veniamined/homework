package components.mappers;

import components.dto.RolePermissionDTO;
import components.entity.RolePermission;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public RolePermissionDTO toDto(RolePermission entity) {
        return modelMapper.map(entity, RolePermissionDTO.class);
    }

    public static RolePermission toEntity(RolePermissionDTO dto) {
        return modelMapper.map(dto, RolePermission.class);
    }
}
