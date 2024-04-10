package components.services.impl;

import components.dto.RolePermissionDTO;
import components.services.RolePermissionService;
import components.entity.RolePermission;
import components.mappers.RolePermissionMapper;
import components.repositories.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepository, RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionRepository = rolePermissionRepository;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public RolePermissionDTO create(RolePermissionDTO dto) {
        RolePermission rolePermission = rolePermissionMapper.toEntity(dto);
        return rolePermissionMapper.toDto(rolePermissionRepository.save(rolePermission));
    }

    @Override
    public RolePermissionDTO getById(Long id) {
        return rolePermissionMapper.toDto(rolePermissionRepository.findById(id).orElse(null));
    }

    @Override
    public List<RolePermissionDTO> getAll() {
        return rolePermissionRepository.findAll().stream()
                .map(rolePermissionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolePermissionDTO update(Long id, RolePermissionDTO dto) {
        RolePermission existingRolePermission = rolePermissionRepository.findById(id).orElse(null);
        if (existingRolePermission == null) {
            return null;
        }
        RolePermission updatedRolePermission = rolePermissionMapper.toEntity(dto);
        updatedRolePermission.setId(existingRolePermission.getId());
        return rolePermissionMapper.toDto(rolePermissionRepository.save(updatedRolePermission));
    }

    @Override
    public void delete(Long id) {
        rolePermissionRepository.deleteById(id);
    }

    @Override
    public RolePermissionDTO getById(Long roleId, Long permissionId) {
        return null;
    }

    @Override
    public RolePermissionDTO update(Long roleId, Long permissionId, RolePermissionDTO dto) {
        return null;
    }

    @Override
    public void delete(Long roleId, Long permissionId) {

    }
}