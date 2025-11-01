# Sistema de Parqueadero - Spring Boot

Sistema de gestion de parqueadero desarrollado con **Spring Boot** que permite administrar vehiculos, registrar tiempos de permanencia y calcular pagos automaticamente.

## Descripcion

Este proyecto es una API REST que gestiona un sistema de parqueadero. Permite registrar vehiculos por su placa, controlar el tiempo de uso, calcular el costo del servicio y realizar operaciones CRUD completas sobre los registros de vehiculos.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Web**
- **Spring DevTools**
- **Maven**

## Estructura del Proyecto

```
sistemaparqueadero/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/devsenior/luistriana/sistemaparqueadero/
│   │           ├── controller/
│   │           │   └── ParqueaderoController.java
│   │           ├── model/
│   │           │   └── Carro.java
│   │           ├── service/
│   │           │   ├── ServiceParqueadero.java
│   │           │   └── ParqueaderoImpl.java
│   │           └── SistemaparqueaderoApplication.java
│   └── test/
├── pom.xml
└── readme.md
```

## Modelo de Datos

### Clase Carro
```java
- placa: String (identificador unico)
- tiempoDePago: Double (horas de uso)
```

## Funcionalidades

### Endpoints Disponibles

| Metodo | Endpoint | Descripcion |
|--------|----------|-------------|
| `GET` | `/api/parqueadero/vercarros` | Obtener todos los vehiculos registrados |
| `POST` | `/api/parqueadero/carro` | Registrar un nuevo vehiculo |
| `DELETE` | `/api/parqueadero/carro/{placa}` | Eliminar un vehiculo por placa |
| `PATCH` | `/api/parqueadero/carro/{placa}` | Actualizar tiempo de uso |
| `GET` | `/api/parqueadero/carro/tiempo/{placa}` | Calcular pago del vehiculo |

## Detalles de Implementacion

### Tarifa
- **$4,000 COP por hora**

### Caracteristicas Tecnicas
- Utiliza `HashSet` para almacenar vehiculos (sin duplicados por placa)
- Implementacion de `equals()` y `hashCode()` basados en la placa
- Manejo de excepciones con mensajes personalizados
- Validacion de placas existentes antes de operaciones

## Instalacion y Ejecucion

### Prerrequisitos
- JDK 21 o superior
- Maven 3.6+

### Pasos para ejecutar

1. **Clonar el repositorio**
```bash
git clone <url-del-repositorio>
cd sistemaparqueadero
```

2. **Compilar el proyecto**
```bash
mvn clean install
```

3. **Ejecutar la aplicacion**
```bash
mvn spring-boot:run
```

4. **La aplicacion estara disponible en:**
```
http://localhost:8080
```

## Ejemplos de Uso

### 1. Registrar un vehiculo
```bash
POST http://localhost:8080/api/parqueadero/carro
Content-Type: application/json

{
  "placa": "ABC123",
  "tiempoDePago": 2.5
}
```

### 2. Ver todos los vehiculos
```bash
GET http://localhost:8080/api/parqueadero/vercarros
```

### 3. Actualizar tiempo de uso
```bash
PATCH http://localhost:8080/api/parqueadero/carro/ABC123
Content-Type: application/json

{
  "tiempoDePago": 5.0
}
```

### 4. Calcular pago
```bash
GET http://localhost:8080/api/parqueadero/carro/tiempo/ABC123
```

**Respuesta:**
```json
{
  "placa": "ABC123",
  "horas usadas": 5.0,
  "tarifa por hora": 4000.0,
  "mensaje": "el total a pagar por el uso del parqueadero es 20000.0"
}
```

### 5. Eliminar un vehiculo
```bash
DELETE http://localhost:8080/api/parqueadero/carro/ABC123
```

## Manejo de Errores

El sistema maneja errores cuando:
- Se busca un vehiculo con placa inexistente
- Se intenta calcular el pago de un vehiculo no registrado

**Ejemplo de respuesta de error:**
```json
{
  "error": true,
  "mensaje": "carro con la placa XYZ789 no fue encontrado"
}
```

## Arquitectura

El proyecto sigue una arquitectura de capas:

1. **Controller**: Maneja las peticiones HTTP
2. **Service**: Contiene la logica de negocio
3. **Model**: Define las entidades del sistema

## Autor

**Luis Miguel Triana Rueda**
Dev Senior - Modulo 5, Clase 3

## Licencia

Este es un proyecto educativo desarrollado para las tutorias de Java - Corte 4.
