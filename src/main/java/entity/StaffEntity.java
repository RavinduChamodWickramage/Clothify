package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StaffEntity {
    @Id
    private String staffId;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String nic;
    private LocalDate dob;
    private Double salary;
}
