package com.weelo.postman.stepdefinitions;

import com.weelo.postman.exceptions.AssertionsServices;
import com.weelo.postman.questions.StatusCode;
import com.weelo.postman.questions.TheQuantityFieldsService;
import com.weelo.postman.questions.TheSchemaIs;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonsStepdefinitions {

    @Then("Should see status code is {int}")
    public void shouldSeeStatusCodeIs(int code) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(code))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see that quantity fields in the root are {int}")
    public void shouldSeeThatQuantityFieldsInTheRootAre(int value) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(value))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should verify schema (.*)$")
    public void shouldVerifySchema(String structure) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(structure))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );
    }

}
