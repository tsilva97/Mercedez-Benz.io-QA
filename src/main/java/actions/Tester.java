package actions;

import Exceptions.DataElementNotFound;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class Tester {

    private final ExtentReports report;
    private final InteractElement interactElement;
    private final Fetcher elementFetcher = new Fetcher("elements.data");
    private final Fetcher dataFetcher = new Fetcher("data.data");
    private ExtentTest test;

    public Tester(WebDriver driver , ExtentReports report) {
        this.interactElement = new InteractElement(driver);
        this.report = report;
    }

    public void startTest(String testName){
        this.test = report.startTest(testName);
    }

    public void endTest() {
        this.report.endTest(test);
    }

    public void testNavigate(String url) {
        try {
            this.interactElement.navigateTo(this.dataFetcher.fetch(url));
            test.log(LogStatus.PASS, "Navigated to " + url);
        } catch (TimeoutException exception){
            this.test.log(LogStatus.FAIL, "Failed to reach " + url);
        } catch (DataElementNotFound | FileNotFoundException exception){
            this.test.log(LogStatus.FAIL, "Test Failed: " + exception.getMessage());
        }
    }

    public void testClick(String element){
        try {
            this.interactElement.click(this.elementFetcher.fetch(element));
            this.test.log(LogStatus.PASS, "Clicked on " + element);
        } catch (TimeoutException exception){
            this.test.log(LogStatus.FAIL, "Failed to click on " + element);
        } catch (DataElementNotFound | FileNotFoundException exception){
            this.test.log(LogStatus.FAIL, "Test Failed: " + exception.getMessage());
        }
    }

    public void testWrite(String element, String data){
        try{
            this.interactElement.write(this.elementFetcher.fetch(element), this.dataFetcher.fetch(data));
            this.test.log(LogStatus.PASS, "Wrote \"" + this.dataFetcher.fetch(data) +"\" in " + element );
        } catch (TimeoutException exception){
            this.test.log(LogStatus.FAIL, "Failed to write on \"" + data +"\" in " + element);
        } catch (DataElementNotFound | FileNotFoundException exception){
            this.test.log(LogStatus.FAIL, "Test Failed: " + exception.getMessage());
        }
    }

    public void testWrite(String element, Keys toWrite){
        try{
            this.interactElement.write(this.elementFetcher.fetch(element), toWrite);
            this.test.log(LogStatus.PASS, "Pressed a key in " + element);
        } catch (TimeoutException exception){
            this.test.log(LogStatus.FAIL, "Failed to press a key in " + element);
        } catch (DataElementNotFound | FileNotFoundException exception){
            this.test.log(LogStatus.FAIL, "Test Failed: " + exception.getMessage());
        }
    }
}
