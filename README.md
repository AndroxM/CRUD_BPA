# CRUD_BPA
Ejercicio #1 del curso de Java impartido por Carlos Be Peraza. 

La carpeta BaseProjectActivity contiene el código java utilizado para esta actividad.

Para probar su funcionamiento solo necesitan crear la base de datos encontrada en el script db_example.sql,
seguido de ejecutar el comando mvn spring-boot:run en la carpeta donde se aloje el proyecto BaseProjectActivity 
y probar las funciones dentro de postman basadas en lo siguiente:


1.- Añadir Usuario
localhost:8080/api/addUser/?name="nombreUsuario"&email="correoUsuario"

2.- Obtener Usuario
localhost:8080/api/getUser/"idUsuario"

3.- Obtener todos los Usuarios
localhost:8080/api/getAllUsers

4.- Actualizar Usuario
localhost:8080/api/updateUser/"idUsuario" 
(Aparte de este comando, en el apartado Body hay que colocar lo siguiente: 
{"id":idUsuario, "name": "nuevoNombre", "email": "nuevoEmail"})

5.- Eliminar Usuario
localhost:8080/api/deleteUser/"idUsuario"
