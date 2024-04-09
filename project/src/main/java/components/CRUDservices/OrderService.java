package components.CRUDservices;

import components.DTO.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    OrderDTO getById(Long id);

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO update(Long id, OrderDTO orderDTO);

    void delete(Long id);

}
