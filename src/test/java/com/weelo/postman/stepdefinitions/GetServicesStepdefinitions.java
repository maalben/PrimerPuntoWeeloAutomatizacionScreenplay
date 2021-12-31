package com.weelo.postman.stepdefinitions;

import com.weelo.postman.exceptions.AssertionsServices;
import com.weelo.postman.questions.*;
import com.weelo.postman.task.Consume;
import com.weelo.postman.task.ConsumeWithMethodNotKnown;
import com.weelo.postman.task.ConsumeGetServiceWithoutParameters;
import com.weelo.postman.task.Load;
import com.weelo.postman.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetServicesStepdefinitions {

    @Given("Load customer information")
    public void loadCustomerInformation(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(Load.testData(data.get(0)));
    }

    @When("Call get services API")
    public void callGetServicesAPI() {
        theActorInTheSpotlight().attemptsTo(
                Consume.service(
                        WebServiceEndPoints.GET.getUrl()
                ));
    }

    @When("Call get services API without parameters")
    public void callGetServicesAPIWithoutParameters() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGetServiceWithoutParameters.service(
                        WebServiceEndPoints.GET.getUrl()
                ));
    }

    @When("Call services API with method not known")
    public void callServicesAPIWithMethodNotKnown() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeWithMethodNotKnown.service(
                        WebServiceEndPoints.ABC.getUrl()
                ));
    }

    @Then("Should see response is (.*)$")
    public void shouldSeeResponseIsSuccess(String value) {
        theActorInTheSpotlight()
                .should(seeThat(TheGetService.response(), is(value))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_GET_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see response with multiples parameters is (.*)$")
    public void shouldSeeResponseWithMultiplesParametersIsSuccess(String value) {
        theActorInTheSpotlight()
                .should(seeThat(WithMultiplesParameters.response(), is(value))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_GET_SERVICE_WITH_MULTIPLES_PARAMETERS_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see the fields get method response are expected")
    public void shouldSeeTheFieldsGetMethodResponseAreExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_GET_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see the fields and values in the response get service are expected")
    public void shouldSeeTheFieldsAndValuesInTheResponseGetServiceAreExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_GET_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Should see response without parameters (.*)$")
    public void shouldSeeResponseWithoutParametersSuccess(String value) {
        theActorInTheSpotlight()
                .should(seeThat(TheGetResponse.withoutParameters(), is(value))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_GET_SERVICE_WITHOUT_PARAMETERS_IS_NOT_EXPECTED)
                );
    }
}