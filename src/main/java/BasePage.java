import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class BasePage {
    private WebDriver driver;
    static Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver(String driverName) {
        if (driverName.equals("CHROME")) {
            File f = new File("src/main/resources/chromedriver");
            System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
            log.info("Set system property. Chrome driver");
            this.driver = new ChromeDriver();
            log.info("Set CHROME driver");
        } else {
            File f = new File("src/main/resources/geckodriver");
            System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
            log.info("Set system property. FireFox driver");
            this.driver = new FirefoxDriver();
            log.info("Set FIREFOX driver");
        }
        driver.manage().window().maximize();
        log.info("Maximize window");
        return driver;
    }
}