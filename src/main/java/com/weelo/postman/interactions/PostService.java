package com.weelo.postman.interactions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static io.restassured.http.ContentType.JSON;

public class PostService implements Interaction {

    private final String resource;
    private final String body;

    public PostService(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    public static PostService service(String resource, String body) {
        return Tasks.instrumented(PostService.class, resource, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Post.to(resource)
                        .with(request -> request.
                                contentType(JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );
    }
}