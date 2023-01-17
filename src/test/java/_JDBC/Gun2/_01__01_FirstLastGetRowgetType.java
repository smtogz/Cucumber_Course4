package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01__01_FirstLastGetRowgetType extends JDBCParent {
    @Test
    public void test() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select city_id, city, country_id from city");

        resultSet.last();
        System.out.println("city_id string:"+resultSet.getString(1));
        System.out.println("city_id int:"+resultSet.getInt(1));
        System.out.println("city_id satir sayisi :"+resultSet.getRow());
        resultSet.first();
        System.out.println("city_id string:"+resultSet.getString(1));
        System.out.println("city_id int:"+resultSet.getInt(1));
        System.out.println("city_id satir sayisi :"+resultSet.getRow());
    }
}
