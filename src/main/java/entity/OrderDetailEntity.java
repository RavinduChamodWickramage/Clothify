package entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailId id;
    private Double unitPrice;
    private Integer qty;
    private Double discount;
    private Double total;

    @ManyToOne
    private OrderEntity order;
}
