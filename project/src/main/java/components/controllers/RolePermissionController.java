package components.controllers;

import components.dto.RolePermissionDTO;
import components.services.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role-permissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    public ResponseEntity<RolePermissionDTO> create(@RequestBody RolePermissionDTO dto) {
        return new ResponseEntity<>(rolePermissionService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePermissionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rolePermissionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RolePermissionDTO>> getAll() {
        return ResponseEntity.ok(rolePermissionService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolePermissionDTO> update(@PathVariable Long id, @RequestBody RolePermissionDTO dto) {
        return ResponseEntity.ok(rolePermissionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolePermissionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<RolePermissionDTO> getByRoleAndPermissionId(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return ResponseEntity.ok(rolePermissionService.getById(roleId, permissionId));
    }

    @PutMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<RolePermissionDTO> updateByRoleAndPermissionId(@PathVariable Long roleId, @PathVariable Long permissionId, @RequestBody RolePermissionDTO dto) {
        return ResponseEntity.ok(rolePermissionService.update(roleId, permissionId, dto));
    }

    @DeleteMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<Void> deleteByRoleAndPermissionId(@PathVariable Long roleId, @PathVariable Long permissionId) {
        rolePermissionService.delete(roleId, permissionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
