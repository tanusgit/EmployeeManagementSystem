package com.example.EmployeeManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeView {
    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private String jdbcUsername = "system";
    private String jdbcPsssword = "oracle";
    private String jdbcDriver = "oracle.jdbc.OracleDriver";

    private String query1 = "select * from EMPLOYEE";
    private static final String DELETE_USERS_SQL = "delete from EMPLOYEE where ID = ?;";
    private static final String UPDATE_USERS_SQL = "update EMPLOYEE set NAME = ?,DEPARTMENT= ?, SALARY =? where ID = ?;";


    protected Connection getConnection(){
        Connection connection = null;
        try {Class.forName (jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPsssword);
        }catch (SQLException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Error loading driver: ");
        }
        return connection;
    }

    public List<Employee> selectAllUsers(){
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(query1)){
            System.out.println(preparedStatement);
            ResultSet r = preparedStatement.executeQuery();
            while (r.next()){
                int id = r.getInt("id");
                String name = r.getString("name");
                String department = r.getString("department");
                int salary = r.getInt("salary");
                employees.add(new Employee(id, name, department, salary));
            }
        } catch(SQLException e){
            printSQLException(e);
        }
        return employees;
    }

    private void printSQLException(SQLException ex){
        for (Throwable e: ex) {
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

    boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("Delete from EMPLOYEE where ID=?");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


}
