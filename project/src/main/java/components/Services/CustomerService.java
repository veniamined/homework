package components.services;

import components.dto.CustomerDTO;
import components.entity.Customer;

public interface CustomerService extends AbstractService<CustomerDTO, Long> {

    boolean authenticate(String email, String password);
    Customer getByEmail(String email);

    void handleLogin(String email, String password);
}

