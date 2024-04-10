package components.controllers;

import components.dto.RolePermissionDTO;
import components.services.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role-permissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    public ResponseEntity<RolePermissionDTO> createRolePermission(@RequestBody RolePermissionDTO dto) {
        RolePermissionDTO createdDto = rolePermissionService.create(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePermissionDTO> getRolePermissionById(@PathVariable Long id) {
        RolePermissionDTO dto = rolePermissionService.getById(id);
        return new ResponseEntity<>(dto, dto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<RolePermissionDTO>> getAllRolePermissions() {
        List<RolePermissionDTO> dtos = rolePermissionService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolePermissionDTO> updateRolePermission(@PathVariable Long id, @RequestBody RolePermissionDTO dto) {
        RolePermissionDTO updatedDto = rolePermissionService.update(id, dto);
        return new ResponseEntity<>(updatedDto, updatedDto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolePermission(@PathVariable Long id) {
        rolePermissionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
