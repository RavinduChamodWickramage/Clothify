package repository.custom;

import entity.StaffEntity;

public interface StaffDao {
    StaffEntity findByUsername(String username);
}
