package com.student.controller;

import java.io.IOException;

import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        try {

            int id = Integer.parseInt(idParameter);

            StudentDAO studentDAO = new StudentDAO();

            boolean deleted = studentDAO.deleteStudent(id);

            if (deleted) {
                response.sendRedirect("viewStudents");
            } else {
                response.getWriter().println("Student not found or could not be deleted.");
            }

        } catch (NumberFormatException e) {

            response.getWriter().println("Invalid student ID.");

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error deleting student.");
        }
    }
}