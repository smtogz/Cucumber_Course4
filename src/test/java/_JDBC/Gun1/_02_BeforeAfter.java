package _JDBC.Gun1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
public class _02_BeforeAfter {
    public static Connection connection;
    public static Statement statement;

    @BeforeTest
    public void DBConnectionOpen() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet=statement.executeQuery("select * from language");
        resultSet.next();
        System.out.println(resultSet.getString(2));
        resultSet.next();
        System.out.println(resultSet.getString(2));
        resultSet.previous();
        System.out.println(resultSet.getString(2));
    }
}
