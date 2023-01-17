package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;
    @FindBy(css = "span[class='nav-link-title']")
    private WebElement dashboard;
    @FindBy(xpath = "//*[text()='Accept all cookies']")
    private WebElement acceptAllCookies;
    @FindBy(xpath = "//ms-add-button[@table='true']//button")
    private WebElement addButton;
    @FindBy(css = "[formcontrolname='name']>input")
    private WebElement nameInput;
    @FindBy(css = "[formcontrolname='code']>input")
    private WebElement codeInput;
    @FindBy(css = "ms-save-button button")
    private WebElement saveButton;
    @FindBy(css = "div[class='ng-star-inserted']>span")
    private WebElement pageHead;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;
    @FindBy(css = "[formcontrolname='shortName']>input")
    private WebElement shortNameInput;
    @FindBy(css = "input[data-placeholder='Name']")
    private WebElement searchName;
    @FindBy(css = "input[data-placeholder='Short Name']")
    private WebElement searchShortName;
    @FindBy(css = "ms-search-button button")
    private WebElement searchButton;
    @FindBy(css = "ms-delete-button button")
    private WebElement deleteButton;
    @FindBy(css = "button[type='submit']")
    private WebElement deleteApprove;
    @FindBy(id = "mat-dialog-title-1")
    private WebElement approveMessage;
    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyMessage;
    @FindBy(css = "[formcontrolname='priority'] input")
    private WebElement priorityCode;
    @FindBy(css = "[formcontrolname='budgetAccountIntegrationCode'] input")
    private WebElement integrationCode;
    @FindBy(xpath="(//span[@class='mat-slide-toggle-thumb'])[11]")
    private WebElement  toggleBar;
    @FindBy(css="td[class='mat-cell cdk-cell cdk-column-name mat-column-name ng-tns-c336-52 ng-star-inserted']")
    public List<WebElement>  statesName;

    WebElement myElement;
    public void findAndSend(String element,String value){
        switch (element){
            case "username": myElement=username;break;
            case "nameInput": myElement=nameInput;break;
            case "codeInput": myElement=codeInput;break;
            case "password": myElement=password;break;
            case "shortNameInput": myElement=shortNameInput;break;
            case "searchName": myElement=searchName;break;
            case "searchShortName": myElement=searchShortName;break;
            case "priorityCode": myElement=priorityCode;break;
            case "integrationCode": myElement=integrationCode;break;
        }
        sendKeysFunction(myElement,value);
    }
    public void findAndClick(String element){
        switch (element){
            case "loginButton": myElement=loginButton;break;
            case "addButton": myElement=addButton;break;
            case "saveButton": myElement=saveButton;break;
            case "acceptAllCookies": myElement=acceptAllCookies;break;
            case "searchButton": myElement=searchButton;break;
            case "deleteButton": myElement=deleteButton;break;
            case "deleteApprove": myElement=deleteApprove;break;
            case "toggleBar": myElement=toggleBar;break;
        }
        clickFunction(myElement);
    }
    public void findAndContainsText(String element,String value){
        switch (element){
            case "dashboard": myElement=dashboard;break;
            case "pageHead": myElement=pageHead;break;
            case "successMessage": myElement=successMessage;break;
            case "alreadyMessage": myElement=alreadyMessage;break;
            case "approveMessage": myElement=approveMessage;break;
            case "searchResultCell": myElement=searchResultCell;break;
        }
        verifyContainsTextFunction(myElement,value);
    }
    public void findAndDelete(String searchText) {

        findAndSend("searchName", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas
        waitUntilLoading();
        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteApprove"); // dilogdaki silme butonuna bas

    }

}
