package com.example.EmployeeManagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
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
            case "/new":
                showNewForm(request, response);
                break;
            case "/add":
                try {
                    registerEmployee(request, response);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;


            default:
                try {
                    listEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = emp.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        request.setAttribute("employee", existingUser);
        dispatcher.forward(request, response);

    }

    private void registerEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException, ServletException {
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        int id = Integer.parseInt(request.getParameter("id"));
        int salary = Integer.parseInt(request.getParameter("salary"));

        Employee employee = new Employee(id, name, department, salary);
        emp.registerEmployee(employee);
        response.sendRedirect("view");
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

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        int salary = Integer.parseInt(request.getParameter("salary"));

        Employee book = new Employee(id, name, department, salary);
        emp.updateUser(book);
        response.sendRedirect("list");
    }

    private void list2Employee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        try{
            List<Employee> listEmployee = emp.selectAllUsers();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        emp.deleteEmployee(id);
        response.sendRedirect("view");

    }

}
