package com.climatehealth.dao;

import com.climatehealth.model.HealthData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HealthDataDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB NAME", "NAME", "PASSWORD");
    }

    public boolean saveHealthData(HealthData healthData) {
        String sql = "INSERT INTO health_data (location, weight, height, temperature) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, healthData.getLocation());
            statement.setFloat(2, healthData.getWeight());
            statement.setFloat(3, healthData.getHeight());
            statement.setFloat(4, healthData.getTemperature());
            return statement.executeUpdate() > 0; // Return true if a record was inserted
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false on error
        }
    }
}
