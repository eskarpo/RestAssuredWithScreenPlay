# RestAssuredWithScreenPlay

## ⚙️ Descripción ⚙️

Este proyecto Maven, el cual se encuentra implementado con el patrón de diseño Screenplay y tiene ejemplos de automatización de servicios REST/API, que se realizan a la API http://dummy.restapiexample.com/.

## 📦 Pre-requisitos 📦


* Java 8 o mayor.
* Maven para gestión de librerías.
* Serenity BDD Screenplay.
* Cucumber 4 o mayor con Serenity BDD.
* Serenity Rest , Serenity BDD Screenplay
* Hamcrest

## 🛠️ Paquetes 🛠️

A continuación se describe que debe contener cada paquete del arquetipo base propuesto:

* **enums**: Contiene un grupo de constantes agrupadas por clase que representan un comportamiento.
* **exceptions**: Contiene la tipología de las excepciones que se quieren propagar en la ejecución de una automatización.
* **models**: Contiene la representación de objetos del mundo real con sus características.
* **questions**: Contiene aquellas clases que nos permiten realizar validaciones acerca del estado de los elementos.
* **tasks**: Contiene en cada clase un conjunto de interacciones que le permiten al actor realizar una acción completa en el sistema.
* **runners**: Contiene las clases que permiten ejecutar los features con relación uno a uno entre feature y clase.
* **stepdefinitions**: Contiene las clases que implementan los pasos utilizados en los features a partir de los cuales se pueden invocar tareas (tasks) o preguntas (questions).
* **features**: Contiene las historias de usuario en lenguaje Gherkin con narrativa declarativa en términos de negocio.

## 📋 Para generar el Reporte 📋

Ejecute de forma manual el escenario a validar a través del Runner especifico, luego de que el escenario o los escenario se ejecutaron, ingrese a la terminal de comandos puede ser de su IDE y ejecute el siguiente comando:

      mvn pre-clean post-integration-test

Se generará el reporte en la carpeta **/target/site/serenity/**, archivo **_index.htlm_**
