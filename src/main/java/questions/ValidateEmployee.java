package questions;

import models.DataEmployee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static contants.General.DATA;
import static contants.General.EMPLOYEE_AGE;
import static contants.General.EMPLOYEE_NAME;
import static contants.General.EMPLOYEE_SALARY;
import static contants.General.ID;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ValidateEmployee implements Question<Boolean> {

    private final DataEmployee employee;

    public ValidateEmployee(DataEmployee employee) {
        this.employee = employee;
    }

    @Override
    public Boolean answeredBy(Actor actor){
        String obtRespData = SerenityRest.lastResponse().then().statusCode(HttpStatus.SC_OK).extract().body().asString();
        if (employee.suId.equals("si")){
            assertThat(from(obtRespData).get(DATA+"."+ID).toString(), equalTo(employee.suId));
            assertThat(from(obtRespData).get(DATA+"."+EMPLOYEE_NAME).toString(), equalTo(employee.getEmployeeName()));
            assertThat(from(obtRespData).get(DATA+"."+EMPLOYEE_SALARY).toString(), equalTo(employee.getEmployeeSalary()));
            assertThat(from(obtRespData).get(DATA+"."+EMPLOYEE_AGE).toString(), equalTo(employee.getEmployeeAge()));
        }
        if (employee.suId.equals("no")){
            List<Map> responseUsers  = from(obtRespData).get("data.findAll { user -> user.id == "+Integer.valueOf(employee.getId())+" }" );
            assertThat(responseUsers.get(0).get(ID).toString(), equalTo(employee.getId()));
            assertThat(responseUsers.get(0).get(EMPLOYEE_NAME).toString(),equalTo(employee.getEmployeeName()));
            assertThat(responseUsers.get(0).get(EMPLOYEE_SALARY).toString(),equalTo(employee.getEmployeeSalary()));
            assertThat(responseUsers.get(0).get(EMPLOYEE_AGE).toString(), equalTo(employee.getEmployeeAge()));
        }
        return true;
    }

    public static ValidateEmployee employee(DataEmployee responseDataEmployee){
        return new ValidateEmployee(responseDataEmployee);
    }

}
