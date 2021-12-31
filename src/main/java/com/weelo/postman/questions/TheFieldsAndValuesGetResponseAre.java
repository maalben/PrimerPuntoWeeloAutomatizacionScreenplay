package com.weelo.postman.questions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TheFieldsAndValuesGetResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation Schema Get service",
                        response -> response
                                .assertThat()
                                .body("args.test", equalTo(TestData.getData().get("test"))).and()
                                .body("args.other", equalTo(TestData.getData().get("other"))).and()
                                .body("headers.x-forwarded-proto", equalTo("https")).and()
                                .body("headers.x-forwarded-port", equalTo("443")).and()
                                .body("headers.host", equalTo("postman-echo.com")).and()
                                .body("headers.accept", equalTo("*/*")).and()
                                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                                .log().all()
                )
        );
        return true;
    }

    public static TheFieldsAndValuesGetResponseAre expected() {
        return new TheFieldsAndValuesGetResponseAre();
    }
}
