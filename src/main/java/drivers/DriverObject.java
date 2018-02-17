package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.WebDriverProp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DriverObject {
    private static Map<Long, WebDriver> driverMap = new HashMap<>();
    private static Semaphore semaphore = new Semaphore(1);

    private DriverObject() {
    }

    private static WebDriver createDriver() {
        WebDriverProp webDriverProp = new WebDriverProp();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.setProperty(webDriverProp.chromeDriver(), webDriverProp.readPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return driver;
    }

    public static void releaseThread() {
        DriverObject.getDriver().quit();
        driverMap.remove(Thread.currentThread().getId());
        semaphore.release();
    }

    public static WebDriver getDriver() {
        long currentThread = Thread.currentThread().getId();
        WebDriver driver = driverMap.get(currentThread);
        if (driver == null) {
            driver = createDriver();
            driverMap.put(currentThread, driver);
        }
        return driver;
    }
}
