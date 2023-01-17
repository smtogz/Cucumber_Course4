package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_Example {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resources/Example_07_.xlsx";
        File file = new File(path);
        if (!file.exists()) {
            dosyaYaz(path);
        } else {
            dosyaEkle(path);
        }
    }

    public static void dosyaYaz(String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        Row newRow = sheet.createRow(0);
        Cell newCell = newRow.createCell(0);
        newCell.setCellValue("Merhaba Dunya 1");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }

    public static void dosyaEkle(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
        Cell cell = row.createCell(0);
        cell.setCellValue("Merhaba Dunya "+sheet.getPhysicalNumberOfRows());
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }
}
