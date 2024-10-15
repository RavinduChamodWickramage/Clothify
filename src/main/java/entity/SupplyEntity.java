package entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplyEntity {
    @EmbeddedId
    private SupplyId id;
    private BigDecimal unitCost;
    private Integer qty;
    private BigDecimal total;
    private LocalDateTime dateAndTime;
}
