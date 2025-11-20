![Dev Senior](dev%20senior.jpeg)

# Sistema de Gestion de Usuarios

API REST desarrollada con Spring Boot para la gestion de usuarios de un programa educativo, implementando control de acceso basado en roles y operaciones CRUD completas.

## Descripcion del Proyecto

Este proyecto es una aplicacion Spring Boot que proporciona un sistema robusto de gestion de usuarios con diferentes niveles de permisos. La aplicacion permite crear, leer, actualizar y eliminar usuarios, con validaciones de seguridad segun el rol del usuario autenticado.

## Caracteristicas Principales

- **Control de acceso basado en roles**: Sistema con dos tipos de usuarios (ADMINISTRADOR y ESTANDAR)
- **Operaciones CRUD completas**: Gestion completa de usuarios
- **Validaciones robustas**: Validacion de datos de entrada usando Jakarta Validation
- **Documentacion automatica**: Integracion con Swagger/OpenAPI para documentacion interactiva
- **Arquitectura en capas**: Separacion clara de responsabilidades (Controller, Service, Model)

## Tecnologias Utilizadas

- **Java 21**: Version LTS de Java
- **Spring Boot 3.5.7**: Framework principal
  - Spring Web: Para crear servicios REST
  - Spring Boot DevTools: Herramientas de desarrollo
  - Spring Validation: Validacion de datos
- **SpringDoc OpenAPI 2.6.0**: Documentacion automatica de la API
- **Maven**: Gestion de dependencias y build

## Estructura del Proyecto

```
gestion-usuarios/
├── src/
│   ├── main/
│   │   ├── java/com/devsenior/luistriana/gestion_usuarios/
│   │   │   ├── controller/
│   │   │   │   └── UsuariosController.java      # Controlador REST
│   │   │   ├── service/
│   │   │   │   ├── UsuarioService.java          # Interfaz del servicio
│   │   │   │   └── UsuarioServiceImpl.java      # Implementacion del servicio
│   │   │   ├── model/
│   │   │   │   ├── Usuario.java                 # Modelo de datos Usuario
│   │   │   │   └── RolUsuario.java              # Enum de roles
│   │   │   ├── config/
│   │   │   │   └── openApiConfiguration.java    # Configuracion de Swagger
│   │   │   └── GestionUsuariosApplication.java  # Clase principal
│   │   └── resources/
│   │       └── application.properties           # Configuracion de la aplicacion
│   └── test/
│       └── java/com/devsenior/luistriana/gestion_usuarios/
│           └── GestionUsuariosApplicationTests.java
└── pom.xml                                      # Configuracion de Maven
```

## Modelo de Datos

### Usuario

| Campo           | Tipo        | Descripcion                              | Validaciones                    |
|-----------------|-------------|------------------------------------------|---------------------------------|
| id              | Integer     | Identificador unico del usuario          | Requerido, Positivo             |
| nombreUsuario   | String      | Nombre de usuario para login             | Requerido, No vacio             |
| nombreCompleto  | String      | Nombre completo del usuario              | Requerido, No vacio             |
| contraseña      | String      | Contraseña (minimo 10 caracteres)        | Requerido, No vacio             |
| rol             | RolUsuario  | Rol del usuario en el sistema            | Requerido                       |

### RolUsuario (Enum)

- **ADMINISTRADOR**: Usuario con permisos totales para gestionar todos los usuarios
- **ESTANDAR**: Usuario con permisos limitados (solo puede actualizar su propio perfil)

## Endpoints de la API

### Base URL
```
http://localhost:8080/api/usuarios
```

### Operaciones Disponibles

#### 1. Crear Usuario
**POST** `/api/usuarios`

- **Descripcion**: Crea un nuevo usuario en el sistema
- **Permisos**: Solo ADMINISTRADOR
- **Request Body**:
```json
{
  "id": 1,
  "nombreUsuario": "jperez",
  "nombreCompleto": "Juan Perez",
  "contraseña": "jperez###",
  "rol": "ADMINISTRADOR"
}
```
- **Respuestas**:
  - `200`: Usuario creado exitosamente
  - `400`: Datos de entrada invalidos
  - `403`: Acceso denegado

#### 2. Ver Todos los Usuarios
**GET** `/api/usuarios`

- **Descripcion**: Retorna lista de todos los usuarios
- **Permisos**: Solo ADMINISTRADOR
- **Respuestas**:
  - `200`: Lista de usuarios obtenida exitosamente

#### 3. Ver Usuario por ID
**GET** `/api/usuarios/{id}`

- **Descripcion**: Obtiene un usuario especifico por su ID
- **Permisos**: Solo ADMINISTRADOR
- **Parametros**: `id` (Integer) - ID del usuario
- **Respuestas**:
  - `200`: Usuario encontrado
  - `404`: Usuario no encontrado

#### 4. Actualizar Usuario
**PUT** `/api/usuarios/{id}`

- **Descripcion**: Actualiza completamente un usuario
- **Permisos**: Solo ADMINISTRADOR
- **Parametros**: `id` (Integer) - ID del usuario
- **Request Body**: Objeto Usuario completo
- **Respuestas**:
  - `200`: Usuario actualizado exitosamente

#### 5. Actualizar Mi Perfil
**PUT** `/api/usuarios/mi-perfil/{id}`

- **Descripcion**: Permite a un usuario actualizar su propio perfil
- **Permisos**: ESTANDAR (propio perfil)
- **Parametros**: `id` (Integer) - ID del usuario
- **Request Body**: Objeto Usuario
- **Respuestas**:
  - `200`: Perfil actualizado exitosamente

#### 6. Eliminar Usuario
**DELETE** `/api/usuarios/{id}`

- **Descripcion**: Elimina un usuario del sistema
- **Permisos**: Solo ADMINISTRADOR
- **Parametros**: `id` (Integer) - ID del usuario
- **Respuestas**:
  - `200`: Usuario eliminado exitosamente

## Instalacion y Ejecucion

### Prerrequisitos

- Java 21 o superior
- Maven 3.6 o superior

### Pasos para Ejecutar

1. **Clonar el repositorio**
```bash
git clone <url-del-repositorio>
cd gestion-usuarios
```

2. **Compilar el proyecto**
```bash
mvn clean install
```

3. **Ejecutar la aplicacion**
```bash
mvn spring-boot:run
```

O alternativamente:
```bash
java -jar target/gestion-usuarios-0.0.1-SNAPSHOT.jar
```

4. **Verificar que la aplicacion este corriendo**
```
La aplicacion estara disponible en: http://localhost:8080
```

## Documentacion de la API

Una vez que la aplicacion este en ejecucion, puedes acceder a la documentacion interactiva de Swagger en:

```
http://localhost:8080/swagger-ui.html
```

Esta interfaz permite:
- Ver todos los endpoints disponibles
- Probar las operaciones directamente desde el navegador
- Ver los esquemas de datos
- Consultar ejemplos de request/response

## Arquitectura y Patrones

### Arquitectura en Capas

1. **Capa de Presentacion (Controller)**
   - [UsuariosController.java](src/main/java/com/devsenior/luistriana/gestion_usuarios/controller/UsuariosController.java): Maneja las peticiones HTTP y respuestas

2. **Capa de Logica de Negocio (Service)**
   - [UsuarioService.java](src/main/java/com/devsenior/luistriana/gestion_usuarios/service/UsuarioService.java): Define el contrato de servicios
   - [UsuarioServiceImpl.java](src/main/java/com/devsenior/luistriana/gestion_usuarios/service/UsuarioServiceImpl.java): Implementa la logica de negocio

3. **Capa de Modelo (Model)**
   - [Usuario.java](src/main/java/com/devsenior/luistriana/gestion_usuarios/model/Usuario.java): Entidad de dominio
   - [RolUsuario.java](src/main/java/com/devsenior/luistriana/gestion_usuarios/model/RolUsuario.java): Enumeracion de roles

### Patrones Implementados

- **Repository Pattern**: Mediante el uso de Set para almacenar usuarios
- **Dependency Injection**: Inyeccion de dependencias mediante constructor
- **DTO Pattern**: El modelo Usuario actua como DTO para transferencia de datos
- **Factory Pattern**: Constructor sin argumentos y con argumentos

## Validaciones Implementadas

El proyecto incluye validaciones robustas usando Jakarta Validation:

- `@NotBlank`: Campos no pueden estar vacios ni contener solo espacios
- `@NotNull`: Campos obligatorios
- `@Positive`: Valores numericos deben ser positivos
- Validacion de roles mediante enum
- Validacion de permisos segun rol del usuario

## Caracteristicas de Seguridad

1. **Validacion de roles**: Metodos `validarEsAdmin()` y `validarEsMismoUsuario()`
2. **Control de acceso**: Operaciones sensibles restringidas a administradores
3. **Auto-actualizacion de perfil**: Los usuarios pueden actualizar su propio perfil
4. **Gestion de contraseñas**: Campo obligatorio con requisitos minimos

## Almacenamiento de Datos

Actualmente el proyecto utiliza un `HashSet<Usuario>` para almacenar usuarios en memoria. Esto significa que:

- Los datos se pierden al reiniciar la aplicacion
- Ideal para desarrollo y pruebas
- Preparado para migrar a base de datos (JPA/Hibernate) en futuras versiones

## Conceptos Tecnicos Implementados

### Auto Boxing y Unboxing

El proyecto demuestra el uso de auto boxing y unboxing en Java:

```java
// Auto boxing: conversion automatica de int a Integer
usuario.getId().equals(id)

// Unboxing: conversion automatica de Integer a int
```

Referencia: [UsuarioServiceImpl.java:80-88](src/main/java/com/devsenior/luistriana/gestion_usuarios/service/UsuarioServiceImpl.java#L80-L88)

### Stream API

Uso de Java Streams para busqueda y filtrado:
```java
usuarios.stream()
    .filter(usuario -> usuario.getId().equals(id))
    .findFirst()
    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"))
```

## Proximas Mejoras

- [ ] Integracion con base de datos (PostgreSQL/MySQL)
- [ ] Sistema de autenticacion real (Spring Security + JWT)
- [ ] Encriptacion de contraseñas (BCrypt)
- [ ] Paginacion y ordenamiento de resultados
- [ ] Busqueda avanzada de usuarios
- [ ] Logs y auditoria de operaciones
- [ ] Tests unitarios e integracion
- [ ] Manejo centralizado de excepciones

## Autor

**Luis Miguel Triana Rueda**
- Organizacion: Dev Senior
- Proyecto: Tutorias Corte 4 - Modulo 5, Clase 4

## Licencia

Este proyecto es de codigo abierto y esta disponible para fines educativos.

---

**Desarrollado con Spring Boot 3.5.7 y Java 21**
