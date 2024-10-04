package com.climatehealth.dao;

import com.climatehealth.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DB NAME";
    private static final String USER = "NAME";
    private static final String PASS = "PASSWORD";

    // Method to get database connection
    private Connection getConnection() throws SQLException {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Method to register a new user
    public void registerUser(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword()); // Password should already be hashed
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error occurred while registering user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to log in a user
    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error occurred during login: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Invalid credentials
    }
}
