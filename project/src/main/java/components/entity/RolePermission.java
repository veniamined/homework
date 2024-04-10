package components.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Role_Permissions")
public class RolePermission {

    @EmbeddedId
    private RolePermissionId id;

    // Конструкторы, геттеры и сеттеры, если нужно

    @Embeddable
    public static class RolePermissionId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "role_id", nullable = false)
        private Role role;

        @ManyToOne
        @JoinColumn(name = "permission_id", nullable = false)
        private Permission permission;


    }
}
