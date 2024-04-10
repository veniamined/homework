package components.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerDTO {

    private String password;
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private Long roleId; // Внешний ключ для Role



}
