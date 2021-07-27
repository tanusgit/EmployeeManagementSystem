package com.example.EmployeeManagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "view", value = "/view")
public class EmployeeServlet extends HttpServlet {
    private EmployeeView emp;

    public void init() throws ServletException {
        emp = new EmployeeView();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch(action)
        {
            case "/add": break;
            case "/view":
                try {
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete": break;
            default: break;
        }
    }


    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        try{
            List<Employee> listEmployee = emp.selectAllUsers();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
