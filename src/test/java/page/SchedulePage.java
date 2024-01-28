package page;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends BaseClass {

    @FindBy (xpath = "//*[contains(text(),\"MOC OD 2008\")]")
    WebElement moc;
    @FindBy (xpath = "//*[contains(text(),\"menu\")]")
    WebElement options;
    @FindBy (xpath = "//*[contains(text(),\"logout\")]")
    WebElement logout;
    @FindBy (xpath = "//*[contains(text(),\"Wednesday 27.12.2023 21:00\")]")
    WebElement detailsText;
    @FindBy (xpath = "(//*[contains(@class,\"css-175oi2r r-1loqt21 r-1otgn73\")])[2]")
    WebElement details;
    @FindBy (xpath = "//*[contains(text(),\"ATTENDEE\")]")
    WebElement attendee;
    @FindBy (xpath = "(//*[contains(text(),\"check\")])[1]")
    WebElement attendeeCheck;


    public SchedulePage () {
        PageFactory.initElements(driver,this);
    }

    public boolean newSiteShown () {
       return isDisplayed(moc);
    }

    public String textNewSiteShown () {
        return textShown(moc);
    }

    public void clickOnOptions () { clickOnButton(options);}
    public void clickOnLogOut () {clickOnButton(logout);}
    public void clickOnDetails () {clickOnButton(details);}
    public String detailsText () { return textShown(detailsText);}
    public boolean detailsTextShown () { return isDisplayed(detailsText);}
    public void clickOnAttendee () {clickOnButton(attendee);}
    public boolean attendeeShown () { return isDisplayed(attendeeCheck);}

}
