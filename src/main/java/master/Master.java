package master;

import actions.Setup;
import actions.Tester;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Master {

    private WebDriver driver;
    private final int browser;
    private Tester tester;
    private final ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");

    public Master(int browser){
        this.browser = browser;
    }

    public void setupBrowser(int browser) {
        if (browser == 1){
            this.driver = Setup.chrome();
        }
        else if (browser == 2){
            this.driver = Setup.firefox();
        }
        this.tester = new Tester(this.driver, this.report);
    }

    public void flushReport(){
        this.report.flush();
    }

    public void workflow1() {

        //Setting up the test
        this.setupBrowser(this.browser);
        this.tester.startTest("workflow1");

        //Opening the page
        this.tester.testNavigate("url");

        //Clicking the "agree" button;
        this.tester.testClick("agreeButton");

        //Click the man section
        this.tester.testClick("categoryMen");

        //Click the bomber jacket
        this.tester.testClick("bomberJacket");

        //Add to basket
        this.tester.testClick("addToBasket");

        //Go to shopping basket
        this.tester.testClick("goToBasket");

        //Continue to address and delivery
        this.tester.testClick("addressAndDelivery");

        //Write the email and press enter
        this.tester.testWrite("guestUserMail", "email");
        this.tester.testWrite("guestUserMail", Keys.ENTER);

        //Choose Mr
        this.tester.testClick("mrButton");

        //Write the first name
        this.tester.testWrite("firstNameSubmit", "firstName");

        //Write the last name
        this.tester.testWrite("lastNameSubmit", "lastName");

        //Write the street name
        this.tester.testWrite("streetName", "streetName");

        //Write the street number
        this.tester.testWrite("streetNumber", "streetNumber");

        //Write the post code
        this.tester.testWrite("postalCode", "postCode");

        //Write the town name
        this.tester.testWrite("townName", "townName");

        //Fill in the date of birth
        this.tester.testWrite("day", "day");
        this.tester.testWrite("month", "month");
        this.tester.testWrite("year", "year");

        //Continue to payment type
        this.tester.testClick("paymentType");

        //Pay with Paypal
        this.tester.testClick("paypal");

        //Continue to verification and placement
        this.tester.testClick("verificationAndPlacement");

        //End the test
        this.tester.endTest();
        this.driver.quit();

    }

    public void workflow2() {

        //setting up the test
        this.setupBrowser(this.browser);
        this.tester.startTest("workflow2");

        //Opening the page
        this.tester.testNavigate("url");

        //Clicking the "agree" button;
        this.tester.testClick("agreeButton");

        //Click the women section
        this.tester.testClick("categoryWomen");

        //Click the crystal bracelet
        this.tester.testClick("crystalBracelet");

        //Add to basket
        this.tester.testClick("addToBasket");

        //Click in continue shopping
        this.tester.testClick("continueShopping");

        //Go back o the women section
        this.tester.testClick("goBack");

        //Click the AMG cap
        this.tester.testClick("amgCap");

        //Add to basket
        this.tester.testClick("addToBasket");

        //Go to shopping basket
        this.tester.testClick("goToBasket");

        //Continue to address and delivery
        this.tester.testClick("addressAndDelivery");

        //Write the email and press enter
        this.tester.testWrite("guestUserMail", "email2");
        this.tester.testWrite("guestUserMail", Keys.ENTER);

        //Choose Ms
        this.tester.testClick("msButton");

        //Write the first name
        this.tester.testWrite("firstNameSubmit", "firstName2");

        //Write the last name
        this.tester.testWrite("lastNameSubmit", "lastName2");

        //Write the street name
        this.tester.testWrite("streetName", "streetName2");

        //Write the street number
        this.tester.testWrite("streetNumber", "streetNumber2");

        //Write the post code
        this.tester.testWrite("postalCode", "postCode");

        //Write the town name
        this.tester.testWrite("townName", "townName2");

        //Fill in the date of birth
        this.tester.testWrite("day", "day2");
        this.tester.testWrite("month", "month2");
        this.tester.testWrite("year", "year2");

        //Select Spain the country selector
        this.tester.testClick("countrySelector");
        this.tester.testClick("spain");

        //Continue to payment type
        this.tester.testClick("paymentType");

        //Pay with credit card
        this.tester.testClick("creditCard");

        //Select Visa
        this.tester.testClick("visa");

        //Continue to verification and placement
        this.tester.testClick("verificationAndPlacement");

        //End the test
        this.tester.endTest();
        this.driver.quit();


    }
}
