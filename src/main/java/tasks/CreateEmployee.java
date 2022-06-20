package tasks;

import io.restassured.http.ContentType;
import models.CreateDataEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static utils.contants.General.PATH_CREATE_EMPLOYEE;


public class CreateEmployee implements Task {

    private CreateDataEmployee employee;

    public CreateEmployee(CreateDataEmployee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(PATH_CREATE_EMPLOYEE)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .body(employee)));
    }

    public static CreateEmployee whitData(CreateDataEmployee employee){
        return Tasks.instrumented(CreateEmployee.class, employee);
    }
}
