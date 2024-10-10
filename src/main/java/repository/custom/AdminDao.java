package repository.custom;

import entity.AdminEntity;

public interface AdminDao {
    AdminEntity findByUsername(String username);
    boolean update(AdminEntity admin);
    AdminEntity findById(String adminId);
}
