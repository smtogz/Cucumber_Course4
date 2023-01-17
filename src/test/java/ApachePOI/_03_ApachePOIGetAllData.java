package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/Resources/ApacheExcel2.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
            for (int j = 0; j <sheet.getRow(i).getPhysicalNumberOfCells() ; j++) {
                Cell cell=sheet.getRow(i).getCell(j);
                System.out.print(cell+"\t");
            }
            System.out.println();
        }
    }
}
