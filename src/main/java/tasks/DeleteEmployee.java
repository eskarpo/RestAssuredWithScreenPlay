package tasks;

import io.restassured.http.ContentType;
import models.DeleteDataEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static contants.General.CLIENTE;
import static contants.General.KEY;
import static contants.General.PATH_DELETE_EMPLOYEE_ID;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;



public class DeleteEmployee implements Task {

    private DeleteDataEmployee employee;

    public DeleteEmployee(DeleteDataEmployee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorCalled(CLIENTE).remember(KEY, employee.id);
        actor.attemptsTo(Delete.from(PATH_DELETE_EMPLOYEE_ID + employee.id)
                .with(request -> request
                        .contentType(ContentType.JSON))
        );
    }

    public static DeleteEmployee withData(DeleteDataEmployee employee) {
        return Tasks.instrumented(DeleteEmployee.class, employee);
    }
}
