package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInExel {
    public static void main(String[] args) throws IOException {
        // var olan exel e yazmak
        String path="src/test/java/ApachePOI/Resources/WriteInTheExcelFile.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row newRow= sheet.createRow(0);
        Cell newCell= newRow.createCell(0);
        newCell.setCellValue("Merhaba Dunya");
        fileInputStream.close();
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }
}
