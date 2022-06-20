package hook;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static utils.contants.General.BASE_URL_API;

public class ConfigurarEscenarios {
    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at((BASE_URL_API))
        ));
        SerenityRest.useRelaxedHTTPSValidation();
    }

}
