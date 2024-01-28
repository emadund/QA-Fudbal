package page;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BaseClass {
 @FindBy (xpath= "//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div[2]/form/div/div[2]/input")
    WebElement email;

 @FindBy (css = "[type=\"button\"]")
    WebElement submit;

 @FindBy (xpath = "//*[contains(text(), \"Close\")]")
 WebElement close;
    @FindBy (xpath = "//*[contains(text(), \"Invalid email\")]")
    WebElement invalidEmail;

 @FindBy (css = "[data-testid=\"toastAnimatedContainer\"]")
 WebElement banner;

 public ResetPasswordPage () {
     super();
     PageFactory.initElements(driver, this);
 }

 public ResetPasswordPage fillEmail (String x) {
     fillTextField(x,email);
     return this;
 }
 public void clickOnSubmit () {
     clickOnButton(submit);
 }

 public void clickOnClose () {
     clickOnButton(close);
 }

 public String bannerText () {
     return textShown(banner);
 }

 public String invalidEmailText () {return textShown(invalidEmail);}


}
