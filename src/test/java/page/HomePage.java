package page;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy (css = "[type=\"email\"]")
    WebElement email;

    @FindBy (css = "[type=\"password\"]")
    WebElement password;

    @FindBy (css = ".css-146c3p1.r-1loqt21")
    WebElement eye;

    @FindBy (xpath = "//*[contains(text(),\"Forgot password?\")]")

    WebElement forgot;
    @FindBy (css="[role=\"progressbar\"]")
    WebElement login;
    @FindBy (css = ".css-175oi2r.r-1mlwlqe.r-1udh08x.r-417010")
    WebElement homeCover;
    @FindBy (xpath = "//*[contains(text(),\"Invalid login credentials\")]")
    WebElement invalidCredentials;
    @FindBy (xpath = "//*[contains(text(),\"Invalid email\")]")
    WebElement invalidEmail;

    public HomePage () {
        PageFactory.initElements(driver, this);
    }

    public void fillEmail (String mail) {
        fillTextField(mail, email);
    }
    public void fillPassword (String pass) {
        fillTextField(pass,password);

    }
    public void clickOnEye () {
        clickOnButton(eye);

    }

    public void clickOnForgotten () {
        clickOnButton(forgot);
    }

    public void clickOnLogin () {
        clickOnButton(login);
    }

    public boolean isHomeSiteShown() {
       return homeCover.isDisplayed();
    }
    public String invalidCredentialsText() {return textShown(invalidCredentials);}
    public boolean isInvalidEmailShown() {return isDisplayed(invalidEmail);}
    public String invalidMailText() {return textShown(invalidEmail);}




}
