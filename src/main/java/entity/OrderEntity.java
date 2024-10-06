package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {
    @Id
    private String orderId;
    private Double netTotal;
    private Double totalDiscount;
    private LocalDateTime dateAndTime;
    private String staffId;
    private String customerEmail;
    private String customerPhoneNumber;

    @OneToMany(mappedBy = "orderId")
    private List<OrderDetailEntity> orderDetails;
}
