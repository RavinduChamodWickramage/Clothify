package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
    @Id
    private String productId;
    private String name;
    private String category;
    private String size;
    private BigDecimal unitPrice;
    private Integer qtyOnHand;
}
