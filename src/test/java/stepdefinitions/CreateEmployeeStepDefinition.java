package stepdefinitions;

import exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import models.CreateDataEmployee;
import questions.ValidateCreation;
import tasks.CreateEmployee;

import java.util.Map;

import static exceptions.EmployeeException.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static utils.contants.General.KEY;
import static utils.contants.General.CLIENTE;

public class CreateEmployeeStepDefinition{


    @DataTableType
    public CreateDataEmployee infoEmployeeEntry(Map<String, String> entry){
        CreateDataEmployee obj = new CreateDataEmployee();
        obj.setName(entry.get("name") == null ? "" : entry.get("name"));
        obj.setSalary(entry.get("salary") == null ? "" : entry.get("salary"));
        obj.setAge(entry.get("age") == null ? "" : entry.get("age"));
        return obj;
    }

    @Cuando("se crea al usuario con los datos")
    public void seCreaAlUsuarioConLosDatos(CreateDataEmployee employee) {
        theActorCalled(CLIENTE).attemptsTo(
                CreateEmployee.whitData(employee)
        );
        theActorCalled(CLIENTE).remember(KEY, employee);
    }

    @Cuando("se valida la informacion del empleado creado")
    public void seValidaLaInformacionDelEmpleado() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateCreation.employee(), equalTo(true))
                        .orComplainWith(EmployeeException.class, MESSAGE));
    }

}