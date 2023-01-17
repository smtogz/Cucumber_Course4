package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;

public class _06_ApachePOISteps {
    DialogContent dc=new DialogContent();
    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo=ExcelUtility.getListData("src/test/java/ApachePOI/Resources/ApacheExcel2.xlsx","testCitizen",2);
        for (ArrayList<String> strings:tablo){
            dc.findAndContainsText("pageHead","Citizenships");
            dc.findAndClick("addButton");
            dc.findAndSend("nameInput",strings.get(0));
            dc.findAndSend("shortNameInput",strings.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage","successfully");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
    }

    @When("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo=ExcelUtility.getListData("src/test/java/ApachePOI/Resources/ApacheExcel2.xlsx","testCitizen",1);
        for (ArrayList<String> strings:tablo){
            dc.findAndContainsText("pageHead","Citizenships");
            dc.findAndDelete(strings.get(0));
            dc.findAndContainsText("successMessage","successfully");
        }
    }
}
