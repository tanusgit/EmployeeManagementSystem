package com.example.EmployeeManagement;

import java.sql.*;

public class EmployeeAddSQL {
    public EmployeeAddSQL(){
    }

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        int result = 0;
        String INSERT_USERS_SQL = "insert into Employee "
                + " values (id, name , department, salary)";
        String INSERT_USERS_SQL1 = "INSERT into Employee (id, name , department, salary) VALUES (?,?,?,?)";
        System.out.println("printing from employeeadd " + employee);
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");

                //step2 create  the connection object
                Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");

                Statement myStmt = con.createStatement();

                // 3. Execute SQL query
                String sql = "insert into Employee "
                        + " values (employee.getId(), employee.getName() , employee.getDepartment(), employee.getSalary() )";

              //  myStmt.executeUpdate(sql);

                // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL1);

                    preparedStatement.setInt(1, employee.getId());//1 specifies the first parameter in the query
                    preparedStatement.setString(2, employee.getName());
                    preparedStatement.setString(3, employee.getDepartment());
                    preparedStatement.setInt(4, employee.getSalary());

                    System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                // process sql exception
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
/*
    public static void main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");

            PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?,?,?)");
            stmt.setInt(1,12);//1 specifies the first parameter in the query
            stmt.setString(2,"Ratan");
            stmt.setString(3,"sales");
            stmt.setInt(4,1200);

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }*/

}