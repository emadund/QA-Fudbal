package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    protected static WebDriver driver;
    protected static WebDriverWait wdWait;

    @Before

    public void initialSetup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://grassrootly.netlify.app/");
    }

    protected void fillTextField (String text, WebElement w) {
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
        w.clear();
        w.sendKeys(text);
    }
    protected void clickOnButton (WebElement w) {
        wdWait.until(ExpectedConditions.elementToBeClickable(w));
        w.click();
    }
    protected boolean isDisplayed (WebElement w) {
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.isDisplayed();
    }
    protected String textShown (WebElement w) {
        wdWait.until(ExpectedConditions.visibilityOf(w));
        return w.getText();
    }


   @After

    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
