package com.weelo.postman.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/post_services.feature",
        glue = {"com.weelo.postman.stepdefinitions.hook",
                "com.weelo.postman.stepdefinitions"
        }
)
public class PostServicesRunners {
}