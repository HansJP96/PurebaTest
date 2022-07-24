package pages;

import interactions.Acciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Acciones {


    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "header_container")
    private WebElement entroBien;

    public boolean validoEntroBien() {
        return elementoVisible(entroBien);
    }

}
