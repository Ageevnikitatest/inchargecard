import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LastDigitalTest {

    private WebDriver driver;

    private String url = "https://app.dev.inchargecard.com";
    private String email = "9mawcfnkrv2hk16cqmol.auto@bcvouch.com";
    private String password = "StrongPa$$w0rd";
    private int cardNumberExpected = 7015;

    static Logger log = LoggerFactory.getLogger(LastDigitalTest.class);

    @AfterTest
    public void after() {
        driver.quit();
        log.info("Driver close");
    }

    @BeforeTest
    @Parameters("driverName")
    public void before(String driverName) {
        BasePage basePage = new BasePage(driver);
        this.driver = basePage.getDriver(driverName);
    }

    @Test
    public void lastDigitalTest() throws InterruptedException {
        driver.get(url);
        log.info("Get url");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password, true);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.selectCard(3);

        Assert.assertEquals(myAccountPage.getCardNumber(), cardNumberExpected, "Wrong cards number");
    }
}