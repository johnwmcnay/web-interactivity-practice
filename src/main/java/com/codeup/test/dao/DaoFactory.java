package com.codeup.test.dao;

public class DaoFactory {
    private static Users usersDao;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new UsersDao();
        }
        return usersDao;
    }
}
