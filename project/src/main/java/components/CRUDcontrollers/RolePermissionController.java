package components.CRUDcontrollers;

import components.CRUDservices.RolePermissionService;
import components.DTO.RolePermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role-permissions")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping
    public ResponseEntity<RolePermissionDTO> createRolePermission(@RequestBody RolePermissionDTO dto) {
        RolePermissionDTO createdDto = rolePermissionService.createRolePermission(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePermissionDTO> getRolePermissionById(@PathVariable Long id) {
        RolePermissionDTO dto = rolePermissionService.getRolePermissionById(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RolePermissionDTO>> getAllRolePermissions() {
        List<RolePermissionDTO> dtos = rolePermissionService.getAllRolePermissions();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RolePermissionDTO> updateRolePermission(@RequestBody RolePermissionDTO dto) {
        RolePermissionDTO updatedDto = rolePermissionService.updateRolePermission(dto);
        if (updatedDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolePermission(@PathVariable Long id) {
        rolePermissionService.deleteRolePermission(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
