package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;


public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        StudentDAO studentDAO = new StudentDAO();

        boolean success = studentDAO.registerStudent(name, email, course);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (success) {

            out.println("<html>");
            out.println("<head><title>Registration Successful</title></head>");
            out.println("<body>");

            out.println("<h2>Student Registration Successful</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Course: " + course + "</p>");

            out.println("</body>");
            out.println("</html>");

        } else {

            out.println("<h2>Registration Failed</h2>");
            out.println("<p>Unable to save student details.</p>");
        }
    }
}