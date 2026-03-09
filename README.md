## 🔑 USER AUTH API
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-red)

API REST desarrollada con **Spring Boot** en **Java** para la gestión de usuarios, incluyendo **registro**, **login** y control de **roles**.

Este proyecto forma parte de mi **portfolio como Backend Developer Junior**, demostrando buenas prácticas en arquitectura REST, validación de datos y seguridad con **Spring Security** y **BCrypt**.

## 🟩 Sobre el proyecto

- Permite registrar nuevos usuarios con contraseñas encriptadas.
- Permite autenticación de usuarios mediante login.
- Implementa roles básicos (`ROLE_USER`,`ROLE_ADMIN`).
- Usa **Spring Data JPA** con base de datos H2 en memoria para pruebas.
- Seguridad configurada con **Spring Security** (endpoints protegidos y públicos).

## 🟩 Requisitos antes de empezar a utilizar la API
- Java 17
- Maven

## 🟩 Como utilizar esta API

### 1 Clonar el repositorio
git clone https://github.com/tu-usuario/user-auth-api.git

### 2 Ir al directorio de la API
cd user-auth-api

### Acceder a la base de datos H2
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: h2
Password: h2
  
### Crear usuario (POST)
POST http://localhost:8080/users

JSON BODY:
```json
{
  "username": "admin",
  "password": "1234",
  "role": "ROLE_ADMIN"
}
```

### Listar usuarios (GET)
GET http://localhost:8080/users

### Login de usuario (POST)
POST http://localhost:8080/auth/login
JSON BODY:
```json
{
  "username": "admin",
  "password": "1234"
}
```
Nota: La contraseña se almacena de forma segura encriptada con BCrypt.


## 👨‍💻 Autor
Proyecto desarrollado por Juan Jesús González Hernández
Backend Developer Junior
