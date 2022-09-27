import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class NotificationPage {
    private WebDriver driver;

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    static Logger log = LoggerFactory.getLogger(NotificationPage.class);

    public void skipNotification() {
        String notificationXpath = "//button/span[text()='Not now']";

        driver.findElement(By.xpath(notificationXpath)).click();
        log.info("Skip notification");
    }

    public void acceptNotification() {
        String notificationXpath = "//button/span[text()='Turn on']";

        driver.findElement(By.xpath(notificationXpath)).click();
        log.info("Accept notification");
    }
}