# Aplicación "Alfred Services"

### Esto es una aplicación realizado con Java y PostgreSQL, además se aplica el framework de Hibernate en el desarrollo del código. 
**(El nombre solo fue una ocurrencia de momento XD.)**

El diseño de las GUI de la aplicación está inspirado y basado en un vídeo de [YouTube](https://youtu.be/OnYRLPSoUtM).
Al principio la idea fue replicar el diseño, pero posteriormente se decidió hacerlo con interacción a base de datos.
Hasta la fecha de este commit, la aplicación solo está probado la interacción de Users para el login y el CRUD completo para Personals.
Las demás funcionalidades aún faltan completar, por tanto, quien desee agregar a modo de probarlo, bienvenido sea. 😃🤩

Previa
![Previa](/src/com/screenshots/login.jpg)


#### Herramientas utilizados
- [Jdk v8 y NetBeans v8.2](https://drive.google.com/drive/folders/1lWXCtIYFlAhOtoTyOS5d_LfKGLWp4mBA?usp=sharing "NetBeans 8.0 y Jdk")
- [PostgreSQL v12](https://www.postgresql.org/download/)
- Librerías externas de java importados manualmente
  - [JCalendar 1.3.3](https://drive.google.com/drive/folders/1zl74i8Ej_vRwGv90pxS0Xq41XkYPGSZT?usp=sharing "JCalendar 1.3.3")
  - [AnimationClass](https://drive.google.com/drive/folders/1DsEIg01F5xjqsMCE8baqpIU-UCGQUSnh?usp=sharing)
  - [Alf-Validator](https://drive.google.com/drive/folders/1DqF52ztrjS-KKDWZ51-xBp6YN4aKB579?usp=sharing)
- Librerías auto importados por hibernate al realizar la conexión con base de datos
  - PostgreSQL12
  - Todos los paquetes de hibernate

#### Pasos para utilizar
1. Clonar o descargar el repositorio
2. Crear una base de datos con el nombre "db_alfred_services" (El nombre es opcional)
3. Crear las tablas e insertar los datos de prueba. Los archivos .sql están en el package "com.sql"
3. Crear una conexión de servicios desde NetBeans a la base de datos creado anteriormente
4. Importar las librerías externas que mencionamos en la sección anterior
5. Cualquier problema, escribirlo en los comentarios de este repositorio.

#### Capturas de pantalla
Pantalla Log In
![Pantalla Log In](/src/com/screenshots/login.jpg)

Pantalla Home
![Pantalla Home](/src/com/screenshots/home.jpg)

Pantalla Index de Personal
![Pantalla Index de Personal](/src/com/screenshots/personal-index.jpg)

Pantalla Registro de Personal
![Pantalla Registro de Personal](/src/com/screenshots/personal-register.jpg)
