package com.weelo.postman.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static io.restassured.http.ContentType.JSON;

public class PostServiceWithoutParameters implements Interaction {

    private final String resource;

    public PostServiceWithoutParameters(String resource) {
        this.resource = resource;
    }

    public static PostServiceWithoutParameters service(String resource) {
        return Tasks.instrumented(PostServiceWithoutParameters.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Post.to(resource)
                        .with(request -> request.
                                contentType(JSON)
                                .relaxedHTTPSValidation()
                        )
        );
    }
}