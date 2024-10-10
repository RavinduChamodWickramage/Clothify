package service.custom;

import service.SuperService;

public interface StaffService extends SuperService {
    boolean validateStaffLogin(String username, String password);
    boolean usernameExists(String username);
}
