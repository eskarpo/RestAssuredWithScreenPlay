package stepdefinitions;

import exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import models.DataEmployee;
import questions.ValidateEmployee;
import tasks.ConsultEmployee;

import java.util.Map;

import static contants.General.CLIENTE;
import static exceptions.EmployeeException.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class ConsultEmployeeStepDefinition {


    @DataTableType
    public DataEmployee infoEmployeeEntry(Map<String, String> entry){
        DataEmployee obj = new DataEmployee();
        obj.setSuId(entry.get("suId") == null ? "": entry.get("suId"));
        obj.setId(entry.get("id") == null ? "" : entry.get("id"));
        obj.setEmployeeName(entry.get("employeeName") == null ? "" : entry.get("employeeName"));
        obj.setEmployeeSalary(entry.get("employeeSalary") == null ? "" : entry.get("employeeSalary"));
        obj.setEmployeeAge(entry.get("employeeAge") == null ? "" : entry.get("employeeAge"));
        return obj;
    }


    @Cuando("se consulta la informacion de los empleados por")
    public void seConsultaLaInformacionDeLosEmpleados(DataEmployee employee) {
        theActorCalled(CLIENTE).attemptsTo(
                ConsultEmployee.withData(employee)
        );
    }

    @Entonces("se valida la informacion del empleado")
    public void seValidaLaInformacionDelEmpleado(DataEmployee employee) {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateEmployee.employee(employee), equalTo(true))
                        .orComplainWith(EmployeeException.class, MESSAGE));
    }

}