package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablo=getListData("src/test/java/ApachePOI/Resources/ApacheExcel2.xlsx","testCitizen",4);
        System.out.println("tablo = " + tablo);
    }
    public static ArrayList<ArrayList<String>> getListData(String path,String sheetName,int colum){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();
        Workbook workbook;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheet(sheetName);
        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
            ArrayList<String> arrayList=new ArrayList<>();
            for (int j = 0; j <colum ; j++) {
                arrayList.add(sheet.getRow(i).getCell(j).toString());
            }
            tablo.add(arrayList);
        }
        return tablo;
    }
    public static void writeToExcel(String path, Scenario scenario, String browser, String date) {
        File file = new File(path);
        if (file.exists()) {
            Workbook workbook;
            try {
                FileInputStream fileInputStream=new FileInputStream(path);
                workbook = WorkbookFactory.create(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Sheet sheet=workbook.getSheetAt(0);
            Row row=sheet.createRow(sheet.getPhysicalNumberOfRows());
            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());
            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());
            cell = row.createCell(2);
            cell.setCellValue(browser);
            cell = row.createCell(3);
            cell.setCellValue(date);
            try {
                FileOutputStream fileOutputStream= new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());
            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());
            cell = row.createCell(2);
            cell.setCellValue(browser);
            cell = row.createCell(3);
            cell.setCellValue(date);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
