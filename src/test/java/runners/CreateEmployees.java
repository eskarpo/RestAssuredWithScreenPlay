package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"stepdefinitions", "hook"},
        features = "src/test/resources/features/createEmployees.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)

public class CreateEmployees {
}