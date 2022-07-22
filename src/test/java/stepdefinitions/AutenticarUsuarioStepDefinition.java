package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.init.WebPage;

public class AutenticarUsuarioStepDefinition {

    private WebPage webpage;
    private static final Logger LOGGER = Logger.getLogger(AutenticarUsuarioStepDefinition.class);

    @Before
    public void openBrowser() {
        webpage = new WebPage();
        LOGGER.info("Entrando");
    }

    @After
    public void tearDown() {
        webpage.cerrarNavegador();
        LOGGER.info("Cerrando navegador");
    }

    @Given("que entro al sitio web")
    public void queEntroAlSitioWeb() {
        webpage.
                onLoginPage()
                .entrarASauceLab();
    }

    @When("ingreso mis credenciales")
    public void ingresoMisCredenciales() {
        webpage.
                onLoginPage()
                .escribirUsuario()
                .escribirContra()
                .iniciarSesion();
    }

    @Then("puedo entrar a la pagina a comprar")
    public void puedoEntrarALaPaginaAComprar() {
        Assert.assertTrue(
                webpage
                        .onLandingPage()
                        .validoEntroBien()
        );
    }

    @When("ingreso mis credenciales bloqueadas")
    public void ingresoMisCredencialesBloqueadas() {
        webpage.
                onLoginPage()
                .escribirUsuarioBloqueado()
                .escribirContra()
                .iniciarSesion();
    }

    @Then("me aparece un mensaje de error")
    public void meApareceUnMensajeDeError() {
        Assert.assertTrue(
                webpage
                        .onLoginPage()
                        .validarMensajeError()
        );
    }

}
