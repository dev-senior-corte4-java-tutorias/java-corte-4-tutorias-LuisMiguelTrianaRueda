# Sistema de Transacciones Bancarias

Este es un **sistema de cajero autom�tico** desarrollado en Java que simula operaciones bancarias basicas como depositos, retiros, transferencias y consulta de saldos.

## Funcionalidades principales

-  Agregar nuevas cuentas bancarias
- =� Realizar dep�sitos y retiros
- =� Transferencias entre cuentas
- =� Consultar saldos y estado del cajero
- =� Interfaz de consola interactiva

## Estructura del proyecto

- `Main.java` - Interfaz de usuario y men� principal
- `model/cuenta.java` - Clase modelo para representar cuentas bancarias
- `service/cajero.java` - L�gica de negocio y operaciones del cajero

## Configuracion del POM

### Informacion del Proyecto

- **GroupId**: `com.devsenior.tutorias.luistriana`
- **ArtifactId**: `leector-de-archivos` 
- **Version**: `1.0-SNAPSHOT`
- **Java**: Version 21

### Dependencias principales

1. **SLF4J API (v2.0.13)** - API de logging
2. **Log4j Core (v2.23.1)** - Implementaci�n de logs
3. **Log4j SLF4J2 Implementation** - Puente entre SLF4J y Log4j

### Gestion de dependencias

El POM utiliza `<dependencyManagement>` para centralizar las versiones y luego declara las dependencias necesarias en la secci�n `<dependencies>` sin especificar versiones (se heredan automoticamente).

## Ejecucion

Para ejecutar el proyecto, compile y ejecute la clase `Main.java`. El sistema mostrar� un men� interactivo que permite realizar todas las operaciones bancarias disponibles.