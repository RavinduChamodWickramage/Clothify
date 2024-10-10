package repository.custom.impl;

import entity.StaffEntity;
import repository.custom.StaffDao;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDaoImpl implements StaffDao {
    @Override
    public StaffEntity findByUsername(String username) {
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM Staff WHERE username = ?", username);

            if (resultSet.next()) {
                return new StaffEntity(
                        resultSet.getString("staffId"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName"),
                        resultSet.getString("address"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("nic"),
                        resultSet.getDate("dob").toLocalDate(),
                        resultSet.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
