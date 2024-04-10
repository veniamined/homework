package components.mappers;

import components.dto.CustomerDTO;
import components.entity.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CustomerDTO toDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
