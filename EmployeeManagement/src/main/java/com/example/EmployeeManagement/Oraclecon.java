package com.example.EmployeeManagement;

import java.sql.*;
class Oraclecon{
    public static void main(String args[]){
        try{
            Employee employee = new Employee(3 , "adi", "tech", 2356455);
            int id1 = employee.getId();
            String name1 = employee.getName();
            String dep1 = employee.getDepartment();
            int sal1= employee.getSalary();

            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            // 2. Create a statement
            Statement  myStmt = con.createStatement();

            // 3. Execute SQL query
            String sql = "insert into Employee "
                        + " values (1, 'name1' , 'dep1', 1254)";

            String sql1 = "INSERT INTO Employee (ID, NAME, DEPARTMENT, SALARY) VALUES(5, 'Adi','San jose',145)";


            myStmt.executeUpdate(sql1);

            //step4 execute query
            ResultSet rs=stmt.executeQuery("select * from Employee");
            //System.out.println(rs);
            while(rs.next()) {
               // System.out.println("inside while");
                System.out.println(rs.getInt(1) + " " + rs.getString(2)
                        + " " + rs.getString(3)
                        + " " + rs.getInt(4));
            }

            //step5 close the connection object
            con.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //
    public static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (id, name, department, salary) VALUES "
            + " (?, ?, ?, ?);";

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(Employee user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getDepartment());
            preparedStatement.setInt(4, user.getSalary());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException e) {
        System.out.println(e);
    }
}
