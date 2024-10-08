package entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplyEntity {
    @EmbeddedId
    private SupplyId id;
    private Double unitCost;
    private Integer qty;
    private Double total;
    private LocalDateTime dateAndTime;
}
