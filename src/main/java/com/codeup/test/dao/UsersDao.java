package com.codeup.test.dao;

import com.codeup.test.models.User;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class UsersDao implements Users {

    private Connection connection;

    public UsersDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            User user = new User(rs.getString("username"));

            return user;
        } else {
            return null;
        }
    }

    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = createInsertQuery(user);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();

            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private PreparedStatement createInsertQuery(User user) throws SQLException {
        String sql = "INSERT INTO users (username) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());

        return stmt;
    }
}
