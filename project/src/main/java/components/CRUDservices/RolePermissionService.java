package components.CRUDservices;

import components.DTO.RolePermissionDTO;

import java.util.List;

public interface RolePermissionService {

    RolePermissionDTO createRolePermission(RolePermissionDTO dto);
    RolePermissionDTO getRolePermissionById(Long id);
    List<RolePermissionDTO> getAllRolePermissions();
    RolePermissionDTO updateRolePermission(RolePermissionDTO dto);
    void deleteRolePermission(Long id);
}
