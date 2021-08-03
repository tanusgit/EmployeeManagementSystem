package com.example.EmployeeManagement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//value = "/add-employee" is the html page
@WebServlet(name = "add", value = "/add")
public class Add extends HttpServlet {

    private EmployeeAddSQL emp;
    private Oraclecon emp1;

    public void init() {
        emp = new EmployeeAddSQL();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String department = request.getParameter("department");
        String id = request.getParameter("id");
        String salary = request.getParameter("salary");


        int id1 = Integer.valueOf(id);
        int salary1 = Integer.valueOf(salary);

        Employee employee = new Employee(id1, name, department, salary1);
        try {
            System.out.println(employee);
            emp.registerEmployee(employee);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println(name + " " + department + " " + id + " " + salary);
        out.close();

    }
    public void destroy() {
    }


}

