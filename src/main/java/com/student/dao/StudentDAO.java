package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Register a new student
    public boolean registerStudent(String name, String email, String course) {

        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, course);

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all students from the database
    public List<String[]> getAllStudents() {

        List<String[]> students = new ArrayList<>();

        String sql = "SELECT id, name, email, course FROM students";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String[] student = {
                    String.valueOf(resultSet.getInt("id")),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("course")
                };

                students.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    // Delete a student by ID
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update a student by ID
    public boolean updateStudent(int id, String name, String email, String course) {

        String sql = "UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, course);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}