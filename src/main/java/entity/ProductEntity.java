package entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
    private String productId;
    private String productName;
    private String category;
    private String size;
    private Double unitPrice;
    private Integer qtyOnHand;
}
