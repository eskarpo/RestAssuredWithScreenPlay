package questions;

import models.CreateDataEmployee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static utils.contants.General.AGE;
import static utils.contants.General.DATA;
import static utils.contants.General.KEY;
import static utils.contants.General.NAME;
import static utils.contants.General.SALARY;

public class ValidateCreation implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String obtRespData = SerenityRest.lastResponse().then().statusCode(HttpStatus.SC_OK).extract().body().asString();
        SerenityRest.lastResponse().
                then().
                contentType(equalTo("application/json"))
                .body("data", notNullValue());
        CreateDataEmployee dataEmployee = actor.recall(KEY);
        assertThat(from(obtRespData).get(DATA+"."+NAME).toString(), equalTo(dataEmployee.getName()));
        assertThat(from(obtRespData).get(DATA+"."+SALARY).toString(), equalTo(dataEmployee.getSalary()));
        assertThat(from(obtRespData).get(DATA+"."+AGE).toString(), equalTo(dataEmployee.getAge()));
        return true;
    }

    public static ValidateCreation employee() {
        return new ValidateCreation();
    }

}
