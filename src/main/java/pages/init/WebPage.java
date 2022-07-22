package pages.init;

import io.cucumber.java.jv.Lan;
import pages.LandingPage;
import pages.LoginPage;

public class WebPage extends BasePage {

    //Metodo cerra navegador
    public void cerrarNavegador() {
        webDriver.close();
    }
    public LoginPage onLoginPage() {
        return loginPage;
    }

    public LandingPage onLandingPage() {
        return landingPage;
    }

}
