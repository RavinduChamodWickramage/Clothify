package service.custom.impl;

import entity.StaffEntity;
import repository.custom.StaffDao;
import repository.custom.impl.StaffDaoImpl;
import service.custom.StaffService;

public class StaffServiceImpl implements StaffService {
    private final StaffDao staffDao = new StaffDaoImpl();

    @Override
    public boolean validateStaffLogin(String username, String password) {
        StaffEntity staff = staffDao.findByUsername(username);
        if (staff != null) {
            return staff.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public boolean usernameExists(String username) {
        StaffEntity staff = staffDao.findByUsername(username);
        return staff != null;
    }
}
