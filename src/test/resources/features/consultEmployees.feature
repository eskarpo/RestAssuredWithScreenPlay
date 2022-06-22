#language: es
Característica: Validar información de empleados
  Yo como automatizador
  Necesito verificar los empleados de restapiexample
  Para asugurar que la informción es correcta

  Esquema del escenario: Consultar datos de empleados
    Cuando se consulta la informacion de los empleados por
      | suId   | id   |
      | <suId> | <id> |
    Entonces  se valida la informacion del empleado
      | employeeName   | employeeSalary   | employeeAge   |
      | <employeeName> | <employeeSalary> | <employeeAge> |

    Ejemplos:
      | suId | id | employeeName  | employeeSalary | employeeAge |
      | si   | 17 | Paul Byrd     | 725000         | 64          |
      | no   | 23 | Caesar Vance  | 106450         | 21          |
      | no   | 18 | Gloria Little | 237500         | 59          |
