package com.weelo.postman.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsGetServiceResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Fields Get service API response exists",
                        response -> response.assertThat()
                                .body("args", hasKey("test")).and()
                                .body("args", hasKey("other")).and()
                                .body("headers", hasKey("x-forwarded-proto")).and()
                                .body("headers", hasKey("x-forwarded-port")).and()
                                .body("headers", hasKey("host")).and()
                                .body("headers", hasKey("x-amzn-trace-id")).and()
                                .body("headers", hasKey("accept")).and()
                                .body("headers", hasKey("user-agent")).and()
                                .body("headers", hasKey("accept-encoding")).and()
                                .body("$", hasKey("url"))
                                .log().all()
                ));
        return true;
    }

    public static TheFieldsGetServiceResponseAre expected() {
        return new TheFieldsGetServiceResponseAre();
    }
}
