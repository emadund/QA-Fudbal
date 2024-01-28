package test;

import base.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.HomePage;
import page.ResetPasswordPage;
import page.SchedulePage;

public class TestClass extends BaseClass {
    private HomePage homePage;
    private SchedulePage schedulePage;

    private ResetPasswordPage resetPasswordPage;

    @Before
    public void initialTest () {
        homePage = new HomePage();
        schedulePage = new SchedulePage();
        resetPasswordPage = new ResetPasswordPage();
    }

    @Test

    public void positiveInitialLogin() {     // login with valid inputs
        homePage.fillEmail("dundaetf@gmail.com");
        homePage.fillPassword("P@ssw0rd");
        homePage.clickOnEye();
        homePage.clickOnLogin();
        Assert.assertTrue(schedulePage.newSiteShown());
        Assert.assertEquals("MOC OD 2008",schedulePage.textNewSiteShown());
    }

    @Test

    public void positiveForgottenPasswordClose() {  // examine close button in forgotten password page
        homePage.clickOnForgotten();
        resetPasswordPage.clickOnClose();
        Assert.assertTrue(homePage.isHomeSiteShown());
    }

    @Test

    public void positiveForgottenPasswordBanner () { // clarifies if mail is sent for password reset to proper address
        // suggestion: to filter it only to mail addresses contained in database !

        homePage.clickOnForgotten();
        resetPasswordPage.fillEmail("any@email.com").clickOnSubmit();
        Assert.assertEquals("check_circle\nReset password link sent to your email. Check your inbox.",
        resetPasswordPage.bannerText());
    }

    @Test

    public void negativeExamineLogOut () { // examine if subscriber really logged out without possibility of going back
        homePage.fillEmail("dundaetf@gmail.com");
        homePage.fillPassword("P@ssw0rd");
        homePage.clickOnEye();
        homePage.clickOnLogin();
        schedulePage.clickOnOptions();
        schedulePage.clickOnLogOut();
        Assert.assertFalse(newSiteNotShown());
        Assert.assertTrue(homePage.isHomeSiteShown());
        driver.navigate().back(); // trying to back to logged page
        Assert.assertFalse(newSiteNotShown());
        Assert.assertTrue(homePage.isHomeSiteShown());
        driver.navigate().forward(); // trying to back to logged page
        Assert.assertFalse(newSiteNotShown());
        Assert.assertTrue(homePage.isHomeSiteShown());
    }

    @Test
    public void positiveAttendeeDetails () { // examine both Attendee and Details tabs
      homePage.fillEmail("dundaetf@gmail.com");
      homePage.fillPassword("P@ssw0rd");
      homePage.clickOnEye();
      homePage.clickOnLogin();
      schedulePage.clickOnDetails();
      Assert.assertEquals(schedulePage.detailsText(),"Wednesday 27.12.2023 21:00");
      Assert.assertTrue(schedulePage.detailsTextShown());
      schedulePage.clickOnAttendee();
      Assert.assertTrue(schedulePage.attendeeShown());

    }

    @Test
    public void negativeInvalidEmailForgottenPassword() {
        homePage.clickOnForgotten();
        resetPasswordPage.fillEmail("!@!asa@asa.asa");
        resetPasswordPage.clickOnSubmit();
        Assert.assertEquals("Invalid email", resetPasswordPage.invalidEmailText());
        resetPasswordPage.fillEmail("a sa@asa.asa");
        resetPasswordPage.clickOnSubmit();
        Assert.assertEquals("Invalid email", resetPasswordPage.invalidEmailText());
    }

    @Test
    public void negativeWrongOrEmptyCredentials() {
        homePage.fillEmail("dundaetf@gmail.com");
        homePage.fillPassword("wrongPassword");
        homePage.clickOnLogin();
        Assert.assertEquals("Invalid login credentials",homePage.invalidCredentialsText());
        homePage.fillEmail("wrong@on.purpose");
        homePage.fillPassword("P@ssw0rd");
        homePage.clickOnLogin();

        Assert.assertEquals("Invalid login credentials",homePage.invalidCredentialsText());
        Assert.assertTrue(homePage.isInvalidEmailShown());
        Assert.assertEquals("Invalid email",homePage.invalidMailText());

        homePage.fillEmail("dundaetf@gmail.com");
        homePage.fillPassword("");
        homePage.clickOnLogin();
        Assert.assertTrue(homePage.isHomeSiteShown());
        homePage.fillEmail("");
        homePage.fillPassword("P@ssw0rd");
        homePage.clickOnEye();
        homePage.clickOnLogin();
        Assert.assertTrue(homePage.isHomeSiteShown());
    }

    private boolean newSiteNotShown () {
        try {
            schedulePage.newSiteShown();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
