package exceptions;

public class EmployeeException extends AssertionError {

    public static final String MESSAGE = "La información que entrego la consulta no corresponde a la esperada";

    public EmployeeException(String msg, Throwable cause){
        super(msg,cause);
    }
}
