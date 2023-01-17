package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_CarpimTablosu {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/Resources/CarpimTablosu.xlsx";
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet();
        int index=1;
        int deger=1;
        for (int i = 0; index<6 ; i++) {
            Row row= sheet.createRow(i);
            Cell cell= row.createCell(0);
            cell.setCellValue(index+" * "+deger);
            cell= row.createCell(1);
            cell.setCellValue("=");
            cell= row.createCell(2);
            cell.setCellValue(index*deger);
            deger++;
            if (deger==11){
                row= sheet.createRow(sheet.getPhysicalNumberOfRows());
                i++;
                deger=1;
                index++;
            }
        }
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }
}
