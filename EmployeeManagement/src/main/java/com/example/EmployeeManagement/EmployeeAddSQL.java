package com.example.EmployeeManagement;

import java.sql.*;

public class EmployeeAddSQL {
    public EmployeeAddSQL(){
    }

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        int result = 0;
        String s = "INSERT INTO SYSTEM.Employee (ID, NAME, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?)";

            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");
                 PreparedStatement preparedStatement = con.prepareStatement(s);

                    preparedStatement.setInt(1, employee.getId());//1 specifies the first parameter in the query
                    preparedStatement.setString(2, employee.getName());
                    preparedStatement.setString(3, employee.getDepartment());
                    preparedStatement.setInt(4, employee.getSalary());

                    System.out.println(preparedStatement);
                    result = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                printSQLException(e);
            }
            return result;
        }

        private void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
}