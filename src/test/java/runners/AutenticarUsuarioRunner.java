package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/AutenticarUsuario.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        monochrome = true,
        publish = true
)
public class AutenticarUsuarioRunner {

}
