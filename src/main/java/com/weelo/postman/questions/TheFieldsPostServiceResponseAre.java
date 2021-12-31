package com.weelo.postman.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsPostServiceResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Fields Post service API response exists",
                        response -> response.assertThat()
                                .body("$", hasKey("args")).and()
                                .body("data", hasKey("phone")).and()
                                .body("data", hasKey("name")).and()
                                .body("data", hasKey("email")).and()
                                .body("$", hasKey("files")).and()
                                .body("$", hasKey("form")).and()
                                .body("headers", hasKey("x-forwarded-proto")).and()
                                .body("headers", hasKey("x-forwarded-port")).and()
                                .body("headers", hasKey("host")).and()
                                .body("headers", hasKey("x-amzn-trace-id")).and()
                                .body("headers", hasKey("content-length")).and()
                                .body("headers", hasKey("accept")).and()
                                .body("headers", hasKey("content-type")).and()
                                .body("headers", hasKey("user-agent")).and()
                                .body("headers", hasKey("accept-encoding")).and()
                                .body("json", hasKey("phone"))
                                .body("json", hasKey("name"))
                                .body("json", hasKey("email"))
                                .body("$", hasKey("url"))
                                .log().all()
                ));
        return true;
    }

    public static TheFieldsPostServiceResponseAre expected() {
        return new TheFieldsPostServiceResponseAre();
    }
}
