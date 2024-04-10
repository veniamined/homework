package components.mappers;

import components.dto.RoleDTO;
import components.entity.Role;
import org.modelmapper.ModelMapper;

public class RoleMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static RoleDTO toDto(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    public static Role toEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}
