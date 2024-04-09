package components.CRUDservices;

import components.DTO.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAll();

    RoleDTO getById(Long id);

    RoleDTO create(RoleDTO roleDTO);

    RoleDTO update(Long id, RoleDTO roleDTO);

    void delete(Long id);

}
