package components.DTO;

import lombok.Getter;
import lombok.Setter;

public class CustomerDTO {
    @Getter
    @Setter
    private String password;
    @Setter
    private Long id;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String address;
    @Getter
    private String email;
    @Getter
    private String phone;
    @Getter
    private Long roleId; // Внешний ключ для Role



}
