#language: es
Característica: Crear usuario
  Yo como automatizador
  Necesito crear usuario
  Para verificar que responde con exito el servicio

  Esquema del escenario: Crear datos
    Dado se crea al usuario con los datos
      | name   | salary   | age   |
      | <name> | <salary> | <age> |
    Entonces  se valida la informacion del empleado creado

    Ejemplos:
      | name        | salary | age |
      | Juan Luna   | 2310   | 23  |
      | Gloria Lulo | 500    | 39  |






