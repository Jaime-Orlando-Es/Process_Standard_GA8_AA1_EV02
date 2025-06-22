# Process Standard - GA8-220501096-AA1-EV02

Este trabajo contiene la implementación del sistema **Process Standard**, desarrollado como parte de la evidencia de producto **GA8-220501096-AA1-EV02** del programa de formación en Análisis y Desarrollo de Software.


# Objetivo

El sistema **Process Standard** permite gestionar estándares de producción, usuarios y comentarios, con control de acceso según el rol (Administrador o Usuario).


# Arquitectura del sistema

El proyecto sigue una arquitectura **de microservicios** desarrollada en **Java con Spring Boot**, y se compone de los siguientes módulos:

- `api_login`: Módulo de autenticación con validación de credenciales y control de rol (`ADMIN` o `USER`).
- `api_register`: Registro de usuarios con encriptación de contraseñas.
- `api_usuarios`: Gestión de usuarios (listar, bloquear, eliminar).
- `api_estandares`: Gestión de estándares (consultar, crear, editar, eliminar).
- `api_comentarios`: Envío y visualización de comentarios por parte de los usuarios.

# Roles y funcionalidades

| Rol         | Funciones habilitadas |
|-------------|------------------------|
| **ADMIN**   | Registrar, consultar, editar y eliminar estándares. Visualizar usuarios y comentarios. |
| **USER**    | Consultar estándares por máquina y referencia. Enviar comentarios. |


# Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL
- Git + GitHub
- Postman (para pruebas de API)


# Cómo ejecutar

   bash
   git clone https://github.com/Jaime-Orlando-Es/Process_Standard_GA8_AA1_EV02.git

# Autor
Jaime Orlando Estupiñan Malagón 

# Ficha
2834913

## ANALISIS Y DESARROLLO DE SOFTWARE 

SENA
2025