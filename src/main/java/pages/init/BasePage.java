package pages.init;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.LoginPage;
import utils.LoggerSetUp;

import java.time.Duration;

public class BasePage extends LoggerSetUp {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected LandingPage landingPage;

    public BasePage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();

        this.webDriver = new ChromeDriver(chromeOptions);
//        this.webDriver = new ChromeDriver(chromeOptions);
        this.webDriver.manage().window().maximize();

        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver,10);
        inicioPaginas();
    }

    private void inicioPaginas() {
        loginPage = new LoginPage(webDriver);
        landingPage = new LandingPage(webDriver);
    }
}
