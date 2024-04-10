package components.services.impl;

import components.services.CustomerService;
import components.services.PasswordEncoderService;
import components.entity.Customer;
import components.dto.CustomerDTO;
import components.mappers.CustomerMapper;
import components.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoderService passwordEncoderService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoderService passwordEncoderService) {
        this.customerRepository = customerRepository;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getById(Long id) {
        return CustomerMapper.toDto(customerRepository.findById(id).orElseThrow());
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        customer.setPassword(passwordEncoderService.encode(customerDTO.getPassword()));
        return CustomerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoderService.encode(customerDTO.getPassword()));
        return CustomerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public boolean authenticate(String email, String password) {
        Customer user = getByEmail(email);
        return user != null && passwordEncoderService.matches(password, user.getPassword());
    }
    @Override
    public void handleLogin(String email, String password) {
        if (authenticate(email, password)) {

            System.out.println("Вход выполнен  " + email);
        } else {
            // Логика неудачного входа
            System.out.println("Неудачная попытка  " + email);

    }

    }
}
