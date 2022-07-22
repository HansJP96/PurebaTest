package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import pages.LoginPage;

public class AutenticarUsuarioStepDefinition extends Setup {

    protected LoginPage loginPage;
    protected BasePage basePage;

    @Before
    public void setup() {
        basePage = new BasePage();
    }

    @After
    public void tearDown() {
        basePage.cerrarNavegador();
    }

//    LoginPage loginPage = (LoginPage) basePage;

    @Given("que entro al sitio web")
    public void queEntroAlSitioWeb() {
        loginPage.entrarASaucelabs();
    }

    @When("ingreso mis credenciales")
    public void ingresoMisCredenciales() {
        loginPage.escribirUsuario();
        loginPage.escribirContra();
        loginPage.iniciarSesion();
    }

    @Then("puedo entrar a la pagina a comprar")
    public void puedoEntrarALaPaginaAComprar() {
        Assert.assertTrue(loginPage.validoEntroBien());
        loginPage.cerrarNavegador();
    }

    @When("ingreso mis credenciales bloqueadas")
    public void ingresoMisCredencialesBloqueadas() {
        loginPage.escribirUsuarioBloqueado();
        loginPage.escribirContra();
        loginPage.iniciarSesion();
    }

    @Then("me aparece un mensaje de error")
    public void meApareceUnMensajeDeError() {
        Assert.assertTrue(loginPage.validarMensajeError());
    }

}
