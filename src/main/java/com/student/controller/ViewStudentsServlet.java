package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewStudentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();

        List<String[]> students = studentDAO.getAllStudents();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registered Students</title>");

        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println("h1 { margin-bottom: 20px; }");
        out.println("table { border-collapse: collapse; width: 100%; }");
        out.println("th, td { border: 1px solid black; padding: 10px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");

        out.println(".edit-btn {");
        out.println("background-color: blue;");
        out.println("color: white;");
        out.println("padding: 6px 10px;");
        out.println("text-decoration: none;");
        out.println("border-radius: 4px;");
        out.println("margin-right: 5px;");
        out.println("}");

        out.println(".delete-btn {");
        out.println("background-color: red;");
        out.println("color: white;");
        out.println("padding: 6px 10px;");
        out.println("text-decoration: none;");
        out.println("border-radius: 4px;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Registered Students</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Course</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");

        for (String[] student : students) {

            out.println("<tr>");

            out.println("<td>" + student[0] + "</td>");
            out.println("<td>" + student[1] + "</td>");
            out.println("<td>" + student[2] + "</td>");
            out.println("<td>" + student[3] + "</td>");

            out.println("<td>");

            // Edit button
            out.println("<a class='edit-btn' href='editStudent?id="
                    + student[0] + "'>Edit</a>");

            // Delete button
            out.println("<a class='delete-btn' href='deleteStudent?id="
                    + student[0] + "'>Delete</a>");

            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");

        out.println("<a href='index.jsp'>Back to Registration</a>");

        out.println("</body>");
        out.println("</html>");
    }
}