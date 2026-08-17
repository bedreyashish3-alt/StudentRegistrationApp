package com.student.dao;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("DATABASE CONNECTION TEST SUCCESSFUL!");
        } else {
            System.out.println("DATABASE CONNECTION TEST FAILED!");
        }
    }
}