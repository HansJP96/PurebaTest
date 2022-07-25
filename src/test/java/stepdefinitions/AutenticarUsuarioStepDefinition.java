package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.init.BaseWebPage;

public class AutenticarUsuarioStepDefinition {

    private BaseWebPage webPage;
    private static final Logger LOGGER = Logger.getLogger(AutenticarUsuarioStepDefinition.class);

    @Before
    public void openBrowser() {
        webPage = new BaseWebPage();
        LOGGER.info("Abriendo navegador");
    }

    @After
    public void tearDown() {
        webPage.cerrarNavegador();
        LOGGER.info("Cerrando navegador");
    }

    @Given("que entro al sitio web")
    public void queEntroAlSitioWeb() {
        webPage.irAPaginaInicio();
    }

    @When("ingreso mis credenciales")
    public void ingresoMisCredenciales() {
        webPage.
                onLoginPage()
                .escribirUsuario()
                .escribirContra()
                .iniciarSesion();
    }

    @Then("puedo entrar a la pagina a comprar")
    public void puedoEntrarALaPaginaAComprar() {
        Assert.assertTrue(
                webPage
                        .onLandingPage()
                        .validoEntroBien()
        );
    }

    @When("ingreso mis credenciales bloqueadas")
    public void ingresoMisCredencialesBloqueadas() {
        webPage.
                onLoginPage()
                .escribirUsuarioBloqueado()
                .escribirContra()
                .iniciarSesion();
    }

    @Then("me aparece un mensaje de error")
    public void meApareceUnMensajeDeError() {
        Assert.assertTrue(
                webPage
                        .onLoginPage()
                        .validarMensajeError()
        );
    }

}
