package stepdefinitions;

import exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import models.DataEmployee;
import models.DeleteDataEmployee;
import questions.ValidateElimination;
import questions.ValidateEmployee;
import tasks.ConsultEmployee;
import tasks.DeleteEmployee;

import java.util.Map;

import static exceptions.EmployeeException.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static utils.contants.General.CLIENTE;

public class DeleteEmployeeStepDefinition {


    @DataTableType
    public DeleteDataEmployee infoEmployeeEntry(Map<String, String> entry){
        DeleteDataEmployee obj = new DeleteDataEmployee();
        obj.setId(entry.get("id") == null ? "": entry.get("id"));
        obj.setStatus(entry.get("status") == null ? "" : entry.get("status"));
        obj.setMessage(entry.get("message") == null ? "" : entry.get("message"));
        return obj;
    }


    @Cuando("se elimina la informacion de los empleados por")
    public void seEliminaLaInformacionDeLosEmpleadosPor(DeleteDataEmployee employee) {
        theActorCalled(CLIENTE).attemptsTo(
                DeleteEmployee.withData(employee)
        );
    }

    @Entonces("se valida la eliminacion exitosa")
    public void seValidaLaEliminacionExitosa(DeleteDataEmployee employee) {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateElimination.employee(employee), equalTo(true))
                        .orComplainWith(EmployeeException.class, MESSAGE));
    }

}