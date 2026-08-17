package com.student.controller;

import java.io.IOException;

import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");

            StudentDAO studentDAO = new StudentDAO();

            boolean updated = studentDAO.updateStudent(id, name, email, course);

            if (updated) {

                response.sendRedirect("viewStudents");

            } else {

                response.getWriter().println("Student not found or update failed.");
            }

        } catch (NumberFormatException e) {

            response.getWriter().println("Invalid student ID.");

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error updating student.");
        }
    }
}