package com.weelo.postman.interactions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static io.restassured.http.ContentType.JSON;

public class GetServiceWithoutParameters implements Interaction {

    private final String resource;

    public GetServiceWithoutParameters(String resource) {
        this.resource = resource;
    }

    public static GetServiceWithoutParameters service(String resource) {
        return Tasks.instrumented(GetServiceWithoutParameters.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request.
                                contentType(JSON)
                                .relaxedHTTPSValidation()
                        )
        );
    }
}