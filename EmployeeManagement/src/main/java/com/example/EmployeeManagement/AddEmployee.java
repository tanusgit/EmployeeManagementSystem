package com.example.EmployeeManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//value = "/add-employee" is the html page
@WebServlet(name = "addemployee", value = "/add-employee")
public class AddEmployee extends HttpServlet{
        private String message;
        private String message2;

        public void init() {
            message = "Adding an employee";
            message2 = "another employee";
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            // then write the data of the response
            out.println("<html>"+ "<head><title>Servlet Hello</title></head>");
            // then write the data of the response
            out.println("<body bgcolor=\"#ffffff\">"+
                    "<img src=\"data:image/png;base64,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\" alt=\"Welcome to employee management system\">"+
                    "<h2>Welcome to employee management system</h2>"+
                    "<form method=\"get\">"+ "Name " +
                    "<input type=\"text\" name=\"username\" size=\"25\">"+
                    "Department " +
                    "<input type=\"text\" name=\"department\" size=\"25\">"+
                    "Id " +
                    "<input type=\"text\" name=\"id\" size=\"25\">"+
                    "Salary " +
                    "<input type=\"text\" name=\"salary\" size=\"25\">"+
                    "<p></p>"+ "<input type=\"submit\" value=\"Submit\">"+
                    "<input type=\"reset\" value=\"Reset\">"+ "</form>");
            String name = request.getParameter("username");
            String department = request.getParameter("department");
            String id= request.getParameter("id");
            String salary = request.getParameter("salary");
            //out.println(name + " " + department + " " + id + " " + salary);


            try{
                //step1 load the driver class
                Class.forName("oracle.jdbc.driver.OracleDriver");

                //step2 create  the connection object
                Connection con= DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");

                //step3 create the statement object
                Statement stmt=con.createStatement();

                // 2. Create a statement
                Statement  myStmt = con.createStatement();

                // 3. Execute SQL query
                String sql = "insert into Employee "
                        + " values (id, name , department, salary)";

                myStmt.executeUpdate(sql);


                //step5 close the connection object
                con.close();

            }catch(Exception e)
            {
                System.out.println(e);
            }

            if (name != null && name.length() > 0) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response");
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
            out.close();
        }

            // Hello
          /*  PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<div>" + message2 + "</div>");

            out.println("<h2>" + message + "</h2>");
            out.println("</body></html>");

           */


        public void destroy() {
        }
    }

