package pages.init;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.LoginPage;
import utils.LoggerSetUp;

import java.time.Duration;

public class BaseWebPage extends LoggerSetUp {
    protected WebDriver webDriver;
//    protected LoginPage loginPage;
//    protected LandingPage landingPage;

    public BaseWebPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();

        this.webDriver = new ChromeDriver(chromeOptions);
//        this.webDriver = new ChromeDriver(chromeOptions);
        this.webDriver.manage().window().maximize();

        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver,10);
    }

    //Metodo cerra navegador
    public void cerrarNavegador() {
        webDriver.close();
    }

//    private void inicioPaginas() {
//        loginPage = new LoginPage(webDriver);
//        landingPage = new LandingPage(webDriver);
//    }

    public LoginPage onLoginPage() {
//        return loginPage == null ? new LoginPage(webDriver) : loginPage;
        return new LoginPage(webDriver);
    }

    public LandingPage onLandingPage() {
//        return landingPage == null ? new LandingPage(webDriver) : landingPage;
        return new LandingPage(webDriver);
    }
}
