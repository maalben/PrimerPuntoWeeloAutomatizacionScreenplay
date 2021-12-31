package com.weelo.postman.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static io.restassured.http.ContentType.JSON;

public class GetServiceWithMethodNotKnown implements Interaction {

    private final String resource;

    public GetServiceWithMethodNotKnown(String resource) {
        this.resource = resource;
    }

    public static GetServiceWithMethodNotKnown service(String resource) {
        return Tasks.instrumented(GetServiceWithMethodNotKnown.class, resource);
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