#language: es
Característica: Eliminar empleado
  Yo como automatizador
  Necesito eliminar los empleados de restapiexample
  Para asugurar que el servicio funciona

  Esquema del escenario:  Eliminar datos de empleados
    Cuando se elimina la informacion de los empleados por
      | id   |
      | <id> |
    Entonces  se valida la eliminacion exitosa
      | status   | message   |
      | <status> | <message> |

    Ejemplos:
      | id | status  | message                               |
      | 17 | success | Successfully! Record has been deleted |
