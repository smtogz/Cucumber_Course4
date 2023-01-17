package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsulateRelative extends JDBCParent {

    @Test
    public void test() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from film");
        resultSet.absolute(10);
        System.out.println(resultSet.getString("title"));
        resultSet.relative(5);
        System.out.println(resultSet.getString("title"));
        resultSet.absolute(15);
        System.out.println(resultSet.getString("title"));
        resultSet.absolute(-15);
        System.out.println(resultSet.getString("title"));
        resultSet.first();
        System.out.println(resultSet.getString("title"));
        resultSet.last();
        System.out.println(resultSet.getString("title"));
    }
}
