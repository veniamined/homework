package components.DTO;

import lombok.Setter;

public class ManufacturerDTO {

    @Setter
    private Long id;
    private String name;
    private String country;


    public void SetId(Long id) {

    }
}
