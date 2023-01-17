package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    FormContent fc = new FormContent();

    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elements) {
        List<String> stringList = elements.asList(String.class);
        for (String s : stringList)
            ln.findAndClick(s);
    }

    @And("Click on the element in the dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> stringList = elements.asList(String.class);
        for (String s : stringList)
            dc.findAndClick(s);
    }

    @And("User sending the keys in dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listList = elements.asLists(String.class);
        for (List<String> stringList : listList)
            dc.findAndSend(stringList.get(0), stringList.get(1));
    }

    @And("User delete item from dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<String> stringList = elements.asList(String.class);
        for (String s : stringList)
            dc.findAndDelete(s);
    }

    @And("Select on the element in form content")
    public void selectOnTheElementInFormContent(DataTable elements) {
        List<String> stringList = elements.asList(String.class);
        fc.findAndSelect(stringList.get(0), Integer.parseInt(stringList.get(1)));
        fc.findAndSelect(stringList.get(2), Integer.parseInt(stringList.get(3)));
    }
}
