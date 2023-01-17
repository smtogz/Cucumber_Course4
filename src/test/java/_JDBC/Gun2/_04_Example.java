package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.*;

public class _04_Example extends JDBCParent {

    @Test
    public void test() throws SQLException, IOException {
        writeData("select * from actor");
    }
    public static void writeData(String sorgu) throws SQLException, IOException {
        ResultSet resultSet= statement.executeQuery(sorgu);
        ResultSetMetaData metaData=resultSet.getMetaData();
        String path="src/test/java/_JDBC/Gun2/_04_Example.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        Row newRow= sheet.createRow(0);
        Cell newCell;
        int count=1;
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-20s",metaData.getColumnName(i));
            newCell = newRow.createCell(i-1);
            newCell.setCellValue(metaData.getColumnName(i));
        }
        System.out.println();
        while (resultSet.next()){
            newRow = sheet.createRow(count);
            count++;
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-20s",resultSet.getString(i));
                newCell = newRow.createCell(i-1);
                newCell.setCellValue(resultSet.getString(i));
            }
            System.out.println();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }
}
