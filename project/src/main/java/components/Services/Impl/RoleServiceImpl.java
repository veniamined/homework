package components.services.impl;

import components.dto.RoleDTO;
import components.services.RoleService;
import components.entity.Role;
import components.mappers.RoleMapper;
import components.repositories.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleRepository.findAll().stream()
                .map(RoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getById(Long id) {
        return RoleMapper.toDto(roleRepository.findById(id).orElseThrow());
    }

    @Override
    public RoleDTO create(RoleDTO roleDTO) {
        Role role = RoleMapper.toEntity(roleDTO);
        return RoleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public RoleDTO update(Long id, RoleDTO roleDTO) {
        Role role = RoleMapper.toEntity(roleDTO);
        role.setId(id);
        return RoleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
