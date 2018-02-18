package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.ButtonImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInputImpl;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.openqa.selenium.support.FindBy;
import testdata.models.User;

public class LoginPage extends AbstractPage {
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
        loginNextButton.click();
    }


    public void setPasswordInput(User user) {
        waitUntilBeClickableAbstract(passwordInput);
        passwordInput.sendKeys(user.getPassword());
        passwordNextButton.click();
    }

    public void openGmailPage() {
        gmailIcon.click();
    }
}