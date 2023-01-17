package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test() throws SQLException {
        ResultSet resultSet= statement.executeQuery("select * from language");
        ResultSetMetaData metaData= resultSet.getMetaData();
        System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());

        for (int i = 1; i <= metaData.getColumnCount() ; i++) {
            System.out.print("metaData = " + metaData.getColumnName(i));
            System.out.println(" metaData.getColumnType(i) = " + metaData.getColumnTypeName(i));
        }
    }
    @Test
    public void test1() throws SQLException{
        ResultSet resultSet= statement.executeQuery("select * from language");
        ResultSetMetaData metaData=resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(metaData.getColumnName(i) + "\t\t");
        }
        System.out.println();
        while (resultSet.next()){
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print("\t"+resultSet.getString(i)+ "\t\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() throws SQLException{
        ResultSet resultSet= statement.executeQuery("select * from language");
        ResultSetMetaData metaData=resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-20s",metaData.getColumnName(i));
        }
        System.out.println();
        while (resultSet.next()){
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-20s",resultSet.getString(i));
            }
            System.out.println();
        }
    }
    @Test
    public void test3() throws SQLException{
        writeData("select * from customer");
    }
    public static void writeData(String sorgu) throws SQLException {
        ResultSet resultSet= statement.executeQuery(sorgu);
        ResultSetMetaData metaData=resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-20s",metaData.getColumnName(i));
        }
        System.out.println();
        while (resultSet.next()){
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-20s",resultSet.getString(i));
            }
            System.out.println();
        }
    }
}
