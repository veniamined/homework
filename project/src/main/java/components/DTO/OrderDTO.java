package components.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private String status;
    private Long customerId; // Внешний ключ для Customer
    private Long productId; // Внешний ключ для Product
    private Integer quantity;

    public void setId(Long id) {
    }

}

