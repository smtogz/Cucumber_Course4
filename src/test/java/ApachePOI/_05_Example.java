package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _05_Example {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Aranilan Sutun : ");
        int value= scanner.nextInt();
        System.out.println(getData(value));
    }
    public static String getData(int value){
        String path="src/test/java/ApachePOI/Resources/LoginData.xlsx";
        StringBuilder returnValue= new StringBuilder();
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(path); // dosya acma
            workbook= WorkbookFactory.create(fileInputStream); //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
            if (sheet.getRow(i).getCell(value)==null){
                continue;
            }
            returnValue.append(sheet.getRow(i).getCell(value).toString());
            returnValue.append("\n");
        }
        return returnValue.toString();
    }
}
