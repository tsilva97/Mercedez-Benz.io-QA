package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {

    public static ChromeDriver chrome() {

        WebDriverManager.chromedriver().version("81.0.4044.20").setup();
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    public static FirefoxDriver firefox() {

        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }

    public static EdgeDriver edge() {

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        return driver;
    }
}

