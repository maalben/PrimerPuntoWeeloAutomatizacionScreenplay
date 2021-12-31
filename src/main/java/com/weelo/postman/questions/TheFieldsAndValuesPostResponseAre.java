package com.weelo.postman.questions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class TheFieldsAndValuesPostResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields and values Post service",
                        response -> response
                                .assertThat()
                                .body("data.phone", equalTo(TestData.getData().get("phone"))).and()
                                .body("data.name", equalTo(TestData.getData().get("name"))).and()
                                .body("data.email", equalTo(TestData.getData().get("email"))).and()
                                .body("headers.x-forwarded-proto", equalTo("https")).and()
                                .body("headers.x-forwarded-port", equalTo("443")).and()
                                .body("headers.host", equalTo("postman-echo.com")).and()
                                .body("headers.accept", equalTo("*/*")).and()
                                .body("headers.content-type", equalTo("application/json; charset=UTF-8")).and()
                                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                                .body("json.phone", equalTo(TestData.getData().get("phone"))).and()
                                .body("json.name", equalTo(TestData.getData().get("name"))).and()
                                .body("json.email", equalTo(TestData.getData().get("email"))).and()
                                .log().all()
                )
        );
        return true;
    }

    public static TheFieldsAndValuesPostResponseAre expected() {
        return new TheFieldsAndValuesPostResponseAre();
    }
}
