import businessobjects.GmailBO;
import drivers.DriverObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.WebDriverProp;
import testdata.models.LetterData;
import testdata.models.User;

public class FailedTest {
    private User user;
    private LetterData letterData;
    @BeforeMethod
    public void init(){
        user = new User();
        user.setLogin("homevorkvit@gmail.com");
        user.setPassword("719113719113");
        letterData = new LetterData();
        letterData.setSubject("FailedTest");
        letterData.setSentTo("homevorkvit@gmail.com");
        letterData.setMessage("FailedTest");
    }
    @Test
    public void failedTest(){
        DriverObject.getDriver().get(WebDriverProp.readUrl());
        GmailBO gmailBO = new GmailBO();
        gmailBO.login(user);
        gmailBO.sendMail(letterData);
        Assert.assertTrue(gmailBO.isMessageSent());
        gmailBO.getSentPage();
        gmailBO.moveLetter();
        Assert.assertFalse(gmailBO.isMovedMessagePresent());
    }
    @AfterMethod
    public void closeDriver(){
        DriverObject.releaseThread();
    }
}
