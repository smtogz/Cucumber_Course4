package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Example extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from city");
        resultSet.last();
        int lastRow=resultSet.getRow();
        resultSet.first();
        for (int i = 1; i <=lastRow ; i++) {
            System.out.println(resultSet.getString("city"));
            resultSet.next();
        }
    }
    @Test
    public void test2() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from city");
        resultSet.last();
        int lastRow=resultSet.getRow();
        for (int i = 1; i <=lastRow ; i++) {
            resultSet.absolute(i);
            System.out.println(resultSet.getString("city"));
        }
    }
    @Test
    public void test3() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from city");
        resultSet.last();
        int lastRow=resultSet.getRow();
        resultSet.first();
        for (int i = 1; i <=lastRow ; i++) {
            System.out.println(resultSet.getString("city"));
            resultSet.relative(1);
        }
    }
}
