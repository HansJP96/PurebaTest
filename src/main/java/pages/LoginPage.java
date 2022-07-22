package pages;

import interactions.Acciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Acciones {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usuario;

    @FindBy(id = "password")
    private WebElement contrasena;

    @FindBy(id = "login-button")
    private WebElement confirmar;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement mensajeError;

    public LoginPage entrarASauceLab() {
        abrirPaginas("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage escribirUsuario() {
        escribir(usuario, "standard_user");
        return this;
    }

    public LoginPage escribirUsuarioBloqueado() {
        escribir(usuario, "locked_out_user");
        return this;
    }

    public LoginPage escribirContra() {
        escribir(contrasena, "secret_sauce");
        return this;
    }

    public LoginPage iniciarSesion() {
        clickElement(confirmar);
        return this;
    }

    public boolean validarMensajeError() {
        return elementoVisible(mensajeError);
    }
}
