package components.services.impl;

import components.dto.OrderDTO;
import components.services.OrderService;
import components.entity.Order;
import components.mappers.OrderMapper;
import components.repositories.OrderRepository;
import components.repositories.CustomerRepository;
import components.repositories.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getById(Long id) {
        return OrderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found  " + id)));
    }

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    @Transactional
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found " + id));

        existingOrder.setOrderDate(orderDTO.getOrderDate());
        existingOrder.setStatus(orderDTO.getStatus());
        existingOrder.setQuantity(orderDTO.getQuantity());

        if (orderDTO.getCustomerId() != null) {
            existingOrder.setCustomer(customerRepository.findById(orderDTO.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found" + orderDTO.getCustomerId())));
        }

        if (orderDTO.getProductId() != null) {
            existingOrder.setProduct(productRepository.findById(orderDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found  " + orderDTO.getProductId())));
        }

        return OrderMapper.toDto(orderRepository.save(existingOrder));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
