package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_NewExcelCreate {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sheet1");
        Row newRow= sheet.createRow(0);
        Cell newCell= newRow.createCell(0);
        newCell.setCellValue("Merhaba Dunya");
        String path="src/test/java/ApachePOI/Resources/newExcel.xlsx";
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }
}
