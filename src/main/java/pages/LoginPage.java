package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    private WebElement USUARIO;

    @FindBy(id = "password")
    private WebElement CONTRASENA;

    @FindBy(id = "login-button")
    private WebElement CONFIRMAR;

    @FindBy(id = "header_container")
    private WebElement ENTRO_BIEN;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement MENSAJE_ERROR;

    public void escribirUsuario() {
        escribir(USUARIO, "standard_user");
    }

    public void escribirUsuarioBloqueado() {
        escribir(USUARIO, "locked_out_user");
    }

    public void escribirContra() {
        escribir(CONTRASENA, "secret_sauce");
    }

    public void iniciarSesion() {
        clickElement(CONFIRMAR);
    }

    public boolean validoEntroBien() {
        return elementoVisible(ENTRO_BIEN);
    }

    public boolean validarMensajeError() {
        return elementoVisible(MENSAJE_ERROR);
    }
}
