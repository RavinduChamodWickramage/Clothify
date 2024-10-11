package repository.custom;

import entity.StaffEntity;

import java.util.List;
import java.util.Optional;

public interface StaffDao {
    StaffEntity findByUsername(String username);
    boolean add(StaffEntity staff);
    boolean update(StaffEntity staff);
    boolean delete(String staffId);
    StaffEntity findById(String staffId);
    Optional<String> getLastStaffId();
    List<StaffEntity> findAll();
}
