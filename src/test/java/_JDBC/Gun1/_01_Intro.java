package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        Connection connection= DriverManager.getConnection(url,username,password);
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from actor");
        resultSet.next();
        String firstname=resultSet.getString("first_name");
        String lasttname=resultSet.getString("last_name");
        System.out.print("firstname = " + firstname);
        System.out.println(" lasttname = " + lasttname);
        resultSet.next();
        firstname=resultSet.getString("first_name");
        lasttname=resultSet.getString("last_name");
        System.out.print("firstname = " + firstname);
        System.out.println(" lasttname = " + lasttname);
        connection.close();
    }
}
