package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {
    @Id
    private String orderId;
    private BigDecimal netTotal;
    private BigDecimal totalDiscount;
    private LocalDateTime dateAndTime;
    private String staffId;
    private String customerEmail;
    private String customerPhoneNumber;

    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> orderDetails;

    public OrderEntity(String orderId, BigDecimal netTotal, BigDecimal totalDiscount,
                       LocalDateTime dateAndTime, String staffId,
                       String customerEmail, String customerPhoneNumber) {
        this.orderId = orderId;
        this.netTotal = netTotal;
        this.totalDiscount = totalDiscount;
        this.dateAndTime = dateAndTime;
        this.staffId = staffId;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
