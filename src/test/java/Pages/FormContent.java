package Pages;

import Utilities.GWD;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {
    public FormContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }
    WebElement myElement;
    @FindBy(css = "[formgroupname='academicPeriod']")
    private WebElement academicPeriod;
    @FindBy(css = "[formgroupname='gradeLevel']")
    private WebElement gradeLevel;

    public void findAndSelect(String element,int line){
        switch (element){
            case "academicPeriod": myElement=academicPeriod;break;
            case "gradeLevel": myElement=gradeLevel;break;
        }
        clickFunction(myElement);
        Actions actions=new Actions(GWD.getDriver());
        for (int i = 0; i <line ; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }
}
