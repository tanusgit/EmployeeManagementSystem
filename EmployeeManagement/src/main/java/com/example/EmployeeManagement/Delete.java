package com.example.EmployeeManagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Servlet2", value = "/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");
                PreparedStatement stmt =con.prepareStatement("delete from employee where id=?");
                String id = request.getParameter("id");
                int id1 = Integer.valueOf(id);
                stmt.setInt(1, id1);
                stmt.executeUpdate();
                out.println("deleted employee");
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
