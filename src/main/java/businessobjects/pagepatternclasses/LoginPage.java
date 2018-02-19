package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.ButtonImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInputImpl;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import testdata.models.User;

public class LoginPage extends AbstractPage {
    private final static Logger LOGGER = Logger.getLogger(LoginPage.class);
    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInputImpl loginInput;
    @FindBy(xpath = "//content[@class='CwaK9']")
    private ButtonImpl loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private TextInputImpl passwordInput;
    @FindBy(className = "CwaK9")
    private ButtonImpl passwordNextButton;
    @FindBy(className = "WaidBe")
    private ButtonImpl gmailIcon;

    public LoginPage() {
        super(new MyPageFactory());
    }

    public void loginGmail(User user) {
        loginInput.sendKeys(user.getLogin());
        LOGGER.info(String.format("User login is %s" , user.getLogin()));
        loginNextButton.click();
    }


    public void setPasswordInput(User user) {
        waitUntilBeClickableAbstract(passwordInput);
        passwordInput.sendKeys(user.getPassword());
        passwordNextButton.click();
        LOGGER.info(String.format("User %s login", user.getLogin()));
    }

    public void openGmailPage() {
        gmailIcon.click();
    }
}