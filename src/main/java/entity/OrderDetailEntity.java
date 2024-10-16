package entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailId id;
    private BigDecimal unitPrice;
    private Integer qty;
    private BigDecimal discount;
    private BigDecimal total;

    @ManyToOne
    private OrderEntity order;

    public OrderDetailEntity(OrderDetailId id, BigDecimal unitPrice, Integer qty, BigDecimal discount, BigDecimal total) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.discount = discount;
        this.total = total;
    }
}
