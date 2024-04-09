package components.mappers;

import components.DTO.OrderDTO;
import components.classes.Order;
import org.modelmapper.ModelMapper;

public class OrderMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static OrderDTO toDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public static Order toEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }
}
