package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _07_JDBCSteps {
    DialogContent dc=new DialogContent();
    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {
        ArrayList<ArrayList<String>> dblist=DBUtility.getListData(query);
        List<WebElement> list=dc.statesName;
        for (int i = 0; i < list.size() ; i++) {
            Assert.assertEquals(list.get(i).getText(),dblist.get(i).get(1),"Uyusmadi");
        }
    }
}
