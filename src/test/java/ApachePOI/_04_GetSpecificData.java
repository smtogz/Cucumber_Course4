package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanınız.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _04_GetSpecificData {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Aranilan Deger : ");
        String value=scanner.nextLine();
        System.out.println(getData(value));
    }
    public static String getData(String value){
        String path="src/test/java/ApachePOI/Resources/LoginData.xlsx";
        StringBuilder returnValue= new StringBuilder();
        Workbook workbook=null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
                if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(value)) {
                    for (int j = 1; j <sheet.getRow(i).getPhysicalNumberOfCells() ; j++) {
                        returnValue.append(sheet.getRow(i).getCell(j).toString());
                    }
                    return returnValue.toString();
                }
        }
        return "It couldn't be found";
    }
}
