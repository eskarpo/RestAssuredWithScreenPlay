package contants;

public class General {

    //Constantes pare generales pra consumir los servicios
    public static final String BASE_URL_API = "https://dummy.restapiexample.com";
    public static final String KEY = "response";
    public static final String CLIENTE = "cliente";

    //Constantes pare el servicio consultar employee
    public static final String PATH_GET_EMPLOYEES = "/api/v1/employees";
    public static final String PATH_GET_EMPLOYEE_ID = "/api/v1/employee/";
    public static final String ID = "id";
    public static final String EMPLOYEE_NAME = "employee_name";
    public static final String EMPLOYEE_SALARY ="employee_salary";
    public static final String EMPLOYEE_AGE = "employee_age";

    //Constantes pare el servicio de crear
    public static final String PATH_CREATE_EMPLOYEE= "/api/v1/create";
    public static final String NAME = "name";
    public static final String SALARY = "salary";
    public static final String AGE = "age";
    public static final String DATA = "data";

    //Constante para eliminar emplaeados
    public static final String PATH_DELETE_EMPLOYEE_ID = "/api/v1/delete/";

}
