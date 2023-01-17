package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    static Connection connection;
    static Statement statement;

    public static ArrayList<ArrayList<String>> getListData(String query) {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                ArrayList<String> list=new ArrayList<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    list.add(resultSet.getString(i));
                }
                table.add(list);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return table;
    }
//
//    public static void main(String[] args) {
//        ArrayList<ArrayList<String>> table =getListData("select * from actor");
//        for (ArrayList<String> a:table) {
//            for (String s : a)
//                System.out.printf("%-15s",s);
//            System.out.println();
//        }
//    }
}
