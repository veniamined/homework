package components.Services.Impl;

import components.DTO.OrderDTO;
import components.Services.OrderService;
import components.entity.Order;
import components.mappers.OrderMapper;
import components.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getById(Long id) {
        return OrderMapper.toDto(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        order.setId(id);
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

}
