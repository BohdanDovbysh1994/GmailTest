package businessobjects;

import businessobjects.pagepatternclasses.GmailPage;
import businessobjects.pagepatternclasses.LoginPage;
import testdata.models.LetterData;
import testdata.models.User;

public class GmailBO {
    private LoginPage loginPage;
    private GmailPage gmailPage;

    public GmailBO() {
        this.loginPage = new LoginPage();
        this.gmailPage = new GmailPage();
    }

    public void login(User user) {
        loginPage.loginGmail(user);
        loginPage.setPasswordInput(user);
        loginPage.openGmailPage();
    }

    public void sendMail(LetterData letterData) {
        gmailPage.sendLetter(letterData);
    }

    public boolean isMessageSent() {
        return gmailPage.isMessageSent();
    }

    public void getSentPage() {
        gmailPage.getSentPage();
    }

    public void moveLetter() {
        gmailPage.removeLetterFromSend();
        gmailPage.pushDeleteOkButton();
    }

    public boolean isMovedMessagePresent() {
        return gmailPage.isMovedMessagePresent();
    }
}
