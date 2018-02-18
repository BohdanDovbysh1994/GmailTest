import businessobjects.GmailBO;
import drivers.DriverObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import properties.WebDriverProp;
import testdata.DataProvider;
import testdata.models.LetterData;
import testdata.models.User;

public class FactoryTest {
    private LetterData letterData;
    private User user;


    @Factory(dataProviderClass = DataProvider.class, dataProvider = "getData")
    public FactoryTest(LetterData letterData, User user) {
        this.letterData = letterData;
        this.user = user;
    }


    @Test
    public void testGmail() {
        DriverObject.getDriver().get(WebDriverProp.readUrl());
        GmailBO gmailBO = new GmailBO();
        gmailBO.login(user);
        gmailBO.sendMail(letterData);
        Assert.assertTrue(gmailBO.isMessageSent());
        gmailBO.getSentPage();
        gmailBO.moveLetter();
        Assert.assertTrue(gmailBO.isMovedMessagePresent());
    }

    @AfterMethod
    public void driverQuit() {
        DriverObject.releaseThread();
    }

}
