# dummyRestApi
Automation RestApi

Se creo un proyecto en Java de tipo Gradle con patron de diseño Screenplay
Se creo un runner el cual ejecuta 4 servicios de la pagina http://dummy.restapiexample.com/
El runner apunta al feature src\test\resources\features\consuming_rest.feature, el cual tiene 4 escenarios
*@GetAllUsers
*@CreateUser
*@GetUser
@DeleteUser

Para ejecutar de forma local el proyecto utilizar el siguiente comando en linea de comandos:
gradle clean test aggregate 