package components.CRUDcontrollers;

import components.CRUDservices.CustomerService;
import components.DTO.CustomerDTO;
import components.classes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoderService;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
        customerDTO.setPassword(passwordEncoderService.encode(customerDTO.getPassword()));
        return customerService.create(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setPassword(passwordEncoderService.encode(customerDTO.getPassword()));
        customerDTO.setId(id);
        return customerService.update(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

    @PostMapping("/login")
    public void login(@RequestParam String email, @RequestParam String password) {
        Customer user = customerService.getByEmail(email);
        if (user != null && passwordEncoderService.matches(password, user.getPassword())) {
            // ... логика успешного входа (например, создание сессии)
        } else {
            // ... логика неудачного входа
        }
    }
}
