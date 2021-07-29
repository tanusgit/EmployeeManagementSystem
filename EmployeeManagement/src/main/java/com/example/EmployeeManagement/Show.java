package com.example.EmployeeManagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Servlet", value = "/show")
public class Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
            res.setContentType("text/html");
            out.println("<html><body>");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee department</th><th>Salary</th><tr>");
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dep = rs.getString(3);
                int sal= rs.getInt(4);
                System.out.println(rs.getInt(1) + " " + rs.getString(2)
                        + " " + rs.getString(3)
                        + " " + rs.getInt(4));
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + dep + "</td><td>" + sal +"</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
