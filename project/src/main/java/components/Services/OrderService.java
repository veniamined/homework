package components.services;

import components.dto.OrderDTO;

public interface OrderService extends AbstractService<OrderDTO, Long> {
    OrderDTO create(OrderDTO orderDTO);
    OrderDTO update(Long id, OrderDTO orderDTO);
}
