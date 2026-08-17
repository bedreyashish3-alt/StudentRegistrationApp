package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        try {

            int id = Integer.parseInt(idParameter);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Student</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h1>Edit Student</h1>");

            out.println("<form action='updateStudent' method='post'>");

            out.println("<input type='hidden' name='id' value='" + id + "'>");

            out.println("Name:<br>");
            out.println("<input type='text' name='name' required><br><br>");

            out.println("Email:<br>");
            out.println("<input type='email' name='email' required><br><br>");

            out.println("Course:<br>");
            out.println("<input type='text' name='course' required><br><br>");

            out.println("<input type='submit' value='Update Student'>");

            out.println("</form>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {

            response.getWriter().println("Invalid student ID.");

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error opening edit page.");
        }
    }
}