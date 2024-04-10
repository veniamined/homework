package components.services;

import components.dto.RolePermissionDTO;

public interface RolePermissionService extends AbstractService<RolePermissionDTO, Long> {
    RolePermissionDTO getById(Long roleId, Long permissionId);

    RolePermissionDTO update(Long roleId, Long permissionId, RolePermissionDTO dto);

    void delete(Long roleId, Long permissionId);
}
