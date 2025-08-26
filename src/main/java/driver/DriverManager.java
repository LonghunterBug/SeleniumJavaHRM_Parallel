package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverManager(){
    }
    public static WebDriver getDriver(){
        return driver.get();// lấy giá trị driver trong ThreadLocal
    }
    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
        // gán Webdriver vô ThreadLocal
    }
    public static void quit(){
        DriverManager.driver.get().quit();// Đóng session drive hiện tại
        driver.remove();// Xóa Thread
    }
}
