package util;

import entity.AdminEntity;

public class AdminSession {
    private static AdminSession instance;
    private AdminEntity admin;

    private AdminSession() {}

    public static AdminSession getInstance() {
        if (instance == null) {
            instance = new AdminSession();
        }
        return instance;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }

    public AdminEntity getAdmin() {
        return admin;
    }
}
