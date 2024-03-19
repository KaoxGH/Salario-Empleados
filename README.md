# Salario de Empleados - RESTful API

En esta API (sólo Backend), por medio de métodos POST, se encuentran las funcionalidades CRUD para un sistema de empleados. Agregado a eso, hay un sistema de logueo en donde
se registra la hora de entrada y de salida de cada empleado por medio de su nombre de usuario. Utilizando la funcionalidad anterior, la API cálcula su salario total por día de 
acuerdo al departamento en el que el empleado está registrado. Cada departamento tiene establecido un salario fijo.  

https://github.com/KaoxGH/Salario-Empleados-API/assets/29785115/9b366dae-014b-401b-83b9-874b4109a9b6

## Ficha técnica:
Realiza una API de administración de empleados (sin front).

Prueba:  
Un gerente requiere llevar el control de las entradas y salidas de sus empleados y así poder calcular las horas diarias trabajadas por
empleado de cada uno de los departamentos que son: **Desarrollo, Infraestructura, Proyectos y Operaciones.**  
Tomando en cuenta que cada departamento tiene su media de pago por hora.

Servicios:  
Todos los servicios deben ser POST.  
-Login  
-CRUD de empleados  
-Registro de entrada y salida  
-Cálculo de salario diario de empleado

## Herramientas

Para la creación de la API se utilizó:  
**• IntelliJ IDEA Ultimate 2023.3.4**  
**• Java 17**  
**• Spring Boot 3.2.3 (Dependencias Maven: DevTools, Lombok, Web, Data JPA, MySQL Driver y Javax)**  
**• MySQL Server 8 / Workbench 8 CE**  
**• Postman**  

## Base de datos
Para la base de datos utilicé MySQL. Las tablas en la base de datos están normalizadas, lo que quiere decir que todas cumplen la tercera forma normal. A continuación está el diseño de
la base de datos:  
![Captura de pantalla 2024-03-03 221639](https://github.com/KaoxGH/Salario-Empleados-API/assets/29785115/07a3a203-457e-4993-b7ce-df815f36488d)

### Tabla `empleado`

| Columna         | Tipo          | Restricciones     |
|-----------------|---------------|-------------------|
| id              | INT           | PRIMARY KEY, AUTO_INCREMENT |
| nombre          | VARCHAR(255)  | NOT NULL          |
| password        | VARCHAR(255)  | NOT NULL          |
| departamento_id | INT           |                   |
|                 | FOREIGN KEY (departamento_id) REFERENCES departamento(id) |

### Tabla `departamento`

| Columna       | Tipo          | Restricciones     |
|---------------|---------------|-------------------|
| id            | INT           | PRIMARY KEY, AUTO_INCREMENT |
| nombre        | VARCHAR(255)  | NOT NULL          |
| tarifa_por_hora | DECIMAL(10, 2) | NOT NULL      |

### Tabla `registro_horas`

| Columna       | Tipo          | Restricciones     |
|---------------|---------------|-------------------|
| id            | INT           | PRIMARY KEY, AUTO_INCREMENT |
| empleado_id   | INT           |                   |
| fecha         | DATE          | NOT NULL          |
| hora_entrada  | TIME          | NOT NULL          |
| hora_salida   | TIME          | NOT NULL          |
|               | FOREIGN KEY (empleado_id) REFERENCES empleado(id) |


## Estructura del proyecto
La estructura en el ambiente de desarrollo en IntelliJ está organizado de la siguiente manera:  
![image](https://github.com/KaoxGH/Salario-Empleados-API/assets/29785115/f25daa0d-c02c-406d-856d-e216241d5e29)

**-Config** no se usa en esta ocasión pero sirve si queremos hacer alguna configuración futura usando la dependencia de Spring Security o Auth con JWT.  
**-Controller** es donde se crean las clases en donde declararemos nuestros endpoints y donde daremos instrucciones de comunicación con nuestras peticiones hacía el front.  
**-DTO** para crear nuestras clases de peticiones y respuestas en formato JSON.  
**-Entity** en donde creamos nuestras clases entidad. Obligatorias para comunicarnos con la base de datos y trabajar con nuestros objetos.  
**-Repository** para crear los lazos de comunicación de nuestras peticiones y respuestas con nuestra base de datos utilizando JpaRepository.  
**-Service** es en donde se codifica toda la lógica de negocio. Las instrucciones o validaciones por las que tiene que pasar nuestra información antes de almacenarse en nuestra base de datos.  
**-Util** para nuestras clases de apoyo. Aquí cree una clase que contiene un método que cálcula el salario del empleado. Se toma la hora de entrada y de salida para hacer la operación.  

## Endpoints
Para consultar la semi-documentación, utilicé la dependencia de Swagger, que nos permite visualizar información básica de nuestra API. El nombre de los endpoints está escrito en verbos como la convención lo sugiere.  
A continuación muestro los endpoints declarados en nuestro controlador. A como lo requería la ficha técnica, todos los métodos son POST por lo que siempre requerirá de una petición
si se quiere consultar, actualizar o eliminar algún empleado en la base de datos:  
![image](https://github.com/KaoxGH/Salario-Empleados-API/assets/29785115/a0caf134-7083-4c5b-a513-236c4f2673ef)

### getEmpleado
Para la demostración de la obtención de un empleado, la API requiere el nombre de **usuario** que se desea recuperar   
```json
{
  "usuario": "string",
  "password": "string",
  "departamentoId": 0
}
```
y se obtendra de respuesta un JSON con el siguiente formato:  
```json
{
  "responseCode": "string",
  "responseMessage": "string",
  "responseData": {
    "id": 0,
    "usuario": "string",
    "password": "string",
    "role": "ADMIN",
    "departamento": {
      "departamentoId": 0,
      "nombreDepartamento": "string",
      "tarifaPorHora": 0
    }
  }
}
```
Además de que devolverá un **código de respuesta 200 OK** si la petición y la respuesta fueron correctas.  
Aquí una prueba con Postman:  
![image](https://github.com/KaoxGH/Salario-Empleados-API/assets/29785115/0b4d030e-c542-4dc3-bfec-6dfc8f8d88e8)
