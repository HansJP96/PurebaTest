package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {

    @Managed()
    protected static WebDriver webDriver;

    static {
//        ChromeOptions chromeOptions = new ChromeOptions();
        webDriver = WebDriverManager.chromedriver().create();
//        driver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver,10);
    }

    public void entrarASaucelabs() {
        webDriver.get("https://www.saucedemo.com/");
    }

    //Metodo Para Escrbir en los campos
    public void escribir(WebElement webElement, String texto) {
        webElement.clear(); //Limpiar el campo de texto
        webElement.sendKeys(texto);
    }

    //Metodo click
    public void clickElement(WebElement webElement) {
        scrollOn(webElement);
        webElement.click();
    }

    public boolean elementoVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void scrollOn(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    //Metodo cerra navegador
    public void cerrarNavegador() {
        webDriver.close();
    }

    public String textFromElement(WebElement webElement) {
        return webElement.getText();
    }
}
