package hrm.common;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browserName){
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        DriverManager.setDriver(driver);//Set giá trị driver vào trong ThreadLocal
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }
}
