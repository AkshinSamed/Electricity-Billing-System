package electricity_billing_system.dao;

import java.sql.*;
/*
Step1:
create a class for provide connection to database
 */
public class Conn {
    public Connection connection;
    public Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "02030607");
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
