package com.weelo.postman.interactions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static io.restassured.http.ContentType.JSON;

public class GetService implements Interaction {

    private final String resource;

    public GetService(String resource) {
        this.resource = resource;
    }

    public static GetService service(String resource) {
        return Tasks.instrumented(GetService.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request.
                                contentType(JSON).params(TestData.getData())
                                .relaxedHTTPSValidation()
                        )
        );
    }
}