package tasks;

import io.restassured.http.ContentType;
import models.DataEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static utils.contants.General.PATH_GET_EMPLOYEES;
import static utils.contants.General.PATH_GET_EMPLOYEE_ID;


public class ConsultEmployee implements Task {

    private DataEmployee employee;

    public ConsultEmployee(DataEmployee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (employee.suId.equals("si")) {
            actor.attemptsTo(Get.resource(PATH_GET_EMPLOYEE_ID + employee.id)
                    .with(request -> request
                            .contentType(ContentType.JSON)));
        }
        if (employee.suId.equals("no")) {
            actor.attemptsTo(Get.resource(PATH_GET_EMPLOYEES)
                    .with(request -> request
                            .contentType(ContentType.JSON)));
        }
    }

    public static ConsultEmployee withData(DataEmployee employee) {
        return Tasks.instrumented(ConsultEmployee.class, employee);
    }
}
