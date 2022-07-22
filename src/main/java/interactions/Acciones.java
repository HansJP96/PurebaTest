package interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Acciones {

    private final WebDriver webDriver;

    public Acciones(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void abrirPaginas(String url) {
        webDriver.get(url);
    }

    //Metodo Para Escrbir en los campos
    protected void escribir(WebElement webElement, String texto) {
        webElement.clear(); //Limpiar el campo de texto
        webElement.sendKeys(texto);
    }

    //Metodo click
    protected void clickElement(WebElement webElement) {
        scrollOn(webElement);
        webElement.click();
    }

    protected boolean elementoVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }

    protected void scrollOn(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public String textFromElement(WebElement webElement) {
        return webElement.getText();
    }

}
