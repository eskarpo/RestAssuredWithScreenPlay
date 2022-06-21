package questions;

import models.DeleteDataEmployee;
import models.ResponseDeleteEmployeePojo;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static contants.General.KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ValidateElimination implements Question<Boolean> {

    private DeleteDataEmployee employee;

    public  ValidateElimination(DeleteDataEmployee employee){
        this.employee = employee;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseDeleteEmployeePojo response =SerenityRest.lastResponse().then().statusCode(HttpStatus.SC_OK).extract().body().as(ResponseDeleteEmployeePojo.class);
        SerenityRest.lastResponse().
                then().
                contentType(equalTo("application/json"));

        String idEmployee = actor.recall(KEY);
        assertThat(response.getStatus(), equalTo(employee.status));
        assertThat(response.getData(), equalTo(idEmployee));
        assertThat(response.getMessage(), equalTo(employee.message));
        return true;
    }

    public static ValidateElimination employee(DeleteDataEmployee employee) {
        return new ValidateElimination(employee);
    }

}
