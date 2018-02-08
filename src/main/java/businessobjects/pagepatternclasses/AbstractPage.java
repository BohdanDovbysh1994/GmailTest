package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.AbstractElement;
import businessobjects.pagepatternclasses.decorator.elements.elements.MyElementFactory;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import drivers.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    private static   WebDriver driver;
    private MyElementFactory elementFactory = new MyElementFactory();

    protected AbstractPage(MyPageFactory myPageFactory) {
        driver = DriverObject.getDriver();
        myPageFactory.initElements(driver, this);
    }
    protected static void driverClose(){
        driver.close();
    }
    protected  void getUrl(){
        driver.get("https://accounts.google.com/signin");
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, 25));
    }

    protected String getSubject(String subject) {
        return driver.findElement(By.xpath("//*[@class='bog']//*[text()='" + String.format("%s", subject) + "']")).getText();
    }

    protected AbstractElement waitUntilBeClickableAbstract(AbstractElement element) {
        return elementFactory.create(element.getClass(), getWait().until(ExpectedConditions.elementToBeClickable(element.getWebElement())));
    }

}
