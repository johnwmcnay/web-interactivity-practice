package com.codeup.test.dao;

import com.codeup.test.models.User;

import java.sql.SQLException;

public interface Users {
    User findByUsername(String username) throws SQLException;
    Long insert (User user);
}
