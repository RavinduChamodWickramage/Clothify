package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplierEntity {
    @Id
    private String supplierId;
    private String supplierName;
    private String company;
    private String email;
    private String phoneNumber;
}
