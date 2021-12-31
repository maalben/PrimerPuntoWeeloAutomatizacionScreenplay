package com.weelo.postman.questions;

import com.weelo.postman.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ThePostService implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.should(seeThatResponse("Post service API is Success",
                response -> response
                        .assertThat()
                        .body("data.phone", equalTo(TestData.getData().get("phone")))
                        .and()
                        .body("data.name", equalTo(TestData.getData().get("name")))
                        .and()
                        .body("data.email", equalTo(TestData.getData().get("email")))
                        .log().all()
        ));
        return "success";
    }

    public static ThePostService response() {
        return new ThePostService();
    }
}
