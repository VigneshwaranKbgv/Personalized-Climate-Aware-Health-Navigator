package com.climatehealth.dao;

import com.climatehealth.model.HealthData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class HealthDataDAO {
	private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public HealthDataDAO() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            dbUrl = props.getProperty("mysql.url");
            dbUser = props.getProperty("mysql.user");
            dbPassword = props.getProperty("mysql.password");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
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
