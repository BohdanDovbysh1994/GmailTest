package businessobjects.pagepatternclasses;

import businessobjects.pagepatternclasses.decorator.elements.elements.ButtonImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.CheckBoxImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.LabelImpl;
import businessobjects.pagepatternclasses.decorator.elements.elements.TextInputImpl;
import businessobjects.pagepatternclasses.decorator.elements.handlers.MyPageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import testdata.models.LetterData;

public class GmailPage extends AbstractPage {
    private final static Logger LOGGER = Logger.getLogger(GmailPage.class);
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private ButtonImpl composeButton;
    @FindBy(xpath = "//textarea[@class='vO']")
    private TextInputImpl sendToInput;
    @FindBy(xpath = "//input[@class='aoT']")
    private TextInputImpl subjectInput;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextInputImpl messageInput;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private ButtonImpl sendButton;
    @FindBy(xpath = "//span[@id='link_vsm']")
    private LabelImpl sentMessageConfirmation;
    @FindBy(xpath = "//a[contains(@href, '#sent')]")
    private ButtonImpl sentPage;
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private CheckBoxImpl choosenMail;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private ButtonImpl deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private ButtonImpl deleteOkButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private LabelImpl movedMessage;

    public GmailPage() {
        super(new MyPageFactory());
    }

    public void sendLetter(LetterData letterData) {
        composeButton.click();
        sendToInput.sendKeys(letterData.getSentTo());
        subjectInput.sendKeys(letterData.getSubject());
        messageInput.sendKeys(letterData.getMessage());
        sendButton.click();
        LOGGER.info(String.format("User sent message"));

    }

    public boolean isMessageSent() {
        return sentMessageConfirmation.isPresent();
    }

    public void getSentPage() {
        sentPage.click();
        LOGGER.info(String.format("User get sent page"));
    }

    public void removeLetterFromSend() {
        choosenMail.click();
        LOGGER.info("User choose sent letter");
        deleteButton.click();
        LOGGER.info("User click delete button");
    }

    public void pushDeleteOkButton() {
        waitUntilBeClickableAbstract(deleteOkButton);
        deleteOkButton.click();
        LOGGER.info("User delete message");
    }

    public boolean isMovedMessagePresent() {
        return movedMessage.isPresent();
    }
}