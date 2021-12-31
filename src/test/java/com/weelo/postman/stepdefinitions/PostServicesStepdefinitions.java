package com.weelo.postman.stepdefinitions;

import com.weelo.postman.exceptions.AssertionsServices;
import com.weelo.postman.models.TestData;
import com.weelo.postman.questions.*;
import com.weelo.postman.task.*;
import com.weelo.postman.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class PostServicesStepdefinitions {

    @When("Call post services API")
    public void callPostServicesAPI() {
        theActorInTheSpotlight().attemptsTo(Create.messageBody("postService.json", TestData.getData()));
        theActorInTheSpotlight().attemptsTo(ConsumePost.service(WebServiceEndPoints.POST.getUrl()));
    }

    @Then("Should see response post service is (.*)$")
    public void shouldSeeResponsePostServiceIsSuccess(String value) {
        theActorInTheSpotlight()
                .should(seeThat(ThePostService.response(), is(value))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see the fields post method response are expected")
    public void shouldSeeTheFieldsPostMethodResponseAreExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsPostServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see the fields and values in the response post service are expected")
    public void shouldSeeTheFieldsAndValuesInTheResponsePostServiceAreExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesPostResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @When("Call post services API without parameters")
    public void callPostServicesAPIWithoutParameters() {
        theActorInTheSpotlight().attemptsTo(
                ConsumePostServiceWithoutParameters.service(
                        WebServiceEndPoints.POST.getUrl()
                ));
    }

}