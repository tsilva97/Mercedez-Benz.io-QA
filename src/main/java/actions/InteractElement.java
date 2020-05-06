package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractElement {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public InteractElement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 25);
    }

    public void navigateTo(String url) throws TimeoutException{
        this.driver.navigate().to(url);
        this.wait.until(ExpectedConditions.urlToBe(url));
    }

    public void click (String xpath) throws TimeoutException {
        WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void write(String xpath, String toWrite){
        WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        Actions act = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        act.sendKeys(element, toWrite).perform();
    }

    public void write(String xpath, Keys toWrite){
        WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        Actions act = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        act.sendKeys(element, toWrite).perform();
    }
}
