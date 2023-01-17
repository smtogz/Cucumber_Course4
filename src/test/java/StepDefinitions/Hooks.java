package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before
    public void before(){
        System.out.println("Scenario is started");
    }
    @After
    public void after(Scenario scenario){
        System.out.println("Scenario is closed");
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd_MM_yyHHmmss");
        ExcelUtility.writeToExcel("src/test/java/ApachePOI/Resources/ScenarioStatus.xlsx",scenario,GWD.getThreadBrowserName(),dateTime.format(dateTimeFormatter));
        if (scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot name");
            /*
            TakesScreenshot takesScreenshot=(TakesScreenshot) GWD.getDriver();
            File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
            LocalDateTime now=LocalDateTime.now();
            try {
                FileUtils.copyFile(file, new File("ScreenShots\\Img_" + now.format(DateTimeFormatter.ofPattern("MM-dd-yyyy_hh-mm-ss")) + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
             */
        }
        GWD.quitDriver();
    }
}
