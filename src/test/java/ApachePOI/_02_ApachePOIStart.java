package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class _02_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/Resources/ApacheExcel2.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("Sheet1");
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(0);
        System.out.println("cell = " + cell);

    }
}
