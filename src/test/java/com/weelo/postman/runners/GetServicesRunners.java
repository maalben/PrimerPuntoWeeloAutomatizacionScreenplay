package com.weelo.postman.runners;

import static io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/get_services.feature",
        glue = {"com.weelo.postman.stepdefinitions.hook",
                "com.weelo.postman.stepdefinitions"
        }
)
public class GetServicesRunners {
}