package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;
    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;
    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    private WebElement countries;
    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    private WebElement citizenships;
    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement feesSetup;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;

    @FindBy(xpath = "(//span[text()='States'])[1]")
    private WebElement states;

    WebElement myElement;
    public void findAndClick(String element){
        switch (element) {
            case "setupOne": myElement = setupOne;break;
            case "parameters": myElement = parameters;break;
            case "countries": myElement = countries;break;
            case "citizenships": myElement = citizenships;break;
            case "feesSetup": myElement = feesSetup;break;
            case "entranceExamsOne": myElement = entranceExamsOne;break;
            case "setupTwo": myElement = setupTwo;break;
            case "entranceExamsTwo": myElement = entranceExamsTwo;break;
            case "states": myElement = states;break;
        }
        clickFunction(myElement);
    }
}
