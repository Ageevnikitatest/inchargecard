import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class LoginPage {

    private WebDriver driver;
    static Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        String formXpath = "//div[@class='container-sm']";

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement loginForm = driver.findElement(By.xpath(formXpath));

        Assert.assertTrue("Login Page doesn't open", loginForm.isDisplayed());
        log.info("Check : Login Page is opening");
    }

    public void login(String email, String password, Boolean skipNotification) {
        String loginBtnXpath = "//button[@type='submit']";
        String emailXpath = "//input[@type='email']";
        String passwordXpath = "//input[@type='password']";

        driver.findElement(By.xpath(emailXpath)).sendKeys(email);
        log.info("Enter email");
        driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
        log.info("Enter password");
        driver.findElement(By.xpath(loginBtnXpath)).click();
        log.info("Click Login button");

        NotificationPage notificationPage = new NotificationPage(driver);
        if (skipNotification == true) {
            notificationPage.skipNotification();
        } else {
            notificationPage.acceptNotification();
        }
    }
}