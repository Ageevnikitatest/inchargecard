import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class MyAccountPage {

    private WebDriver driver;
    static Logger log = LoggerFactory.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver) {
        String scrollBarXpath = "//div[@class='undefined']//div[contains(@class,'h-2')]";

        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement scrollBar = driver.findElement(By.xpath(scrollBarXpath));
        Assert.assertTrue("My Account Page doesn't open", scrollBar.isDisplayed());
    }

    public void selectCard(int numberOfCard) throws InterruptedException {
        String cardXpath = "//div[@class='undefined']//div[contains(@class,'h-2')][" + numberOfCard + "]";

        Thread.sleep(4000); // Добавил именно такую задержку из-за проблем с версткой dev, думаю на live можно избежать
        driver.findElement(By.xpath(cardXpath)).click();
        log.info("Select card");
    }

    public int getCardNumber() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int cardNumber = Integer.parseInt(js.executeScript("return document.documentElement.innerText;")
                .toString().substring(291, 295));
        log.info("Get last 4 digital of the card");

        return cardNumber;
    }
}