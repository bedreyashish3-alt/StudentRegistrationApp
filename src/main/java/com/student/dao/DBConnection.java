package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_registration";

    private static final String USER =
            System.getenv().getOrDefault("DB_USER", "root");

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            if (PASSWORD == null || PASSWORD.isBlank()) {
                throw new IllegalStateException(
                    "DB_PASSWORD environment variable is not set."
                );
            }

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("MySQL Database Connected Successfully!");

            return connection;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}