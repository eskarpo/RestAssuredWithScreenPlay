package tasks;

import io.restassured.http.ContentType;
import models.DeleteDataEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static utils.contants.General.CLIENTE;
import static utils.contants.General.KEY;
import static utils.contants.General.PATH_DELETE_EMPLOYEE_ID;


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
