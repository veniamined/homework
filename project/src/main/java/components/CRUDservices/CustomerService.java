package components.CRUDservices;

import components.DTO.CustomerDTO;
import components.classes.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAll();

    CustomerDTO getById(Long id);

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);

    void delete(Long id);

    Customer getByEmail(String email);
}
