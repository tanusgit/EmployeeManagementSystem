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

    //tanu's insert fcn
    public void registerEmployee(Employee employee) throws SQLException {
        String s = "INSERT INTO EMPLOYEE (NAME, DEPARTMENT, SALARY) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SYSTEM.EMPLOYEE (ID, NAME, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?)");) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setInt(4, employee.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }


    }

    public Employee selectUser(int id) {
        Employee user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from EMPLOYEE where ID =?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");
                user = new Employee(id, name, department, salary);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public boolean updateUser(Employee user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("update EMPLOYEE set NAME = ?,DEPARTMENT= ?, SALARY =? where ID = ?")){
            System.out.println("updated USer:"+statement);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    //kevin's view fcn
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

    //Ngan's delete fcn
    boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("Delete from EMPLOYEE where ID=?")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


}
