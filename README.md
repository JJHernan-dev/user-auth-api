## 🔑 USER AUTH API
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-red)

API REST desarrollada con **Spring Boot** en **Java** para la gestión de usuarios, incluyendo **registro**, **login** y control de **roles**.

Este proyecto forma parte de mi portfolio como **Backend Developer Junior**, demostrando buenas prácticas en arquitectura REST, autenticación con **JWT**, seguridad con **Spring Security** y almacenamiento seguro de contraseñas usando **BCrypt**.
## 🟩 Sobre el proyecto
Esta API permite:

- Registrar nuevos usuarios
- Autenticar usuarios mediante login
- Generar tokens JWT para autenticación
- Controlar acceso mediante roles (ROLE_USER, ROLE_ADMIN)
- Proteger endpoints usando Spring Security

Tecnologías utilizadas:
- Java 17
- Spring Boot
- Spring Scurity
- Spring Data JPA
- Maven
- JWT

## 🟩 Requisitos
Antes de ejecutar la API necesitas:

- Java 17
- Maven

## 🟩 Cómo ejecutar el proyecto

### 1 Clonar el repositorio
git clone https://github.com/tu-usuario/user-auth-api.git

### 2 Entrar al directorio
cd user-auth-api

### 3 Ejecutar la API
mvn spring-boot:run

### Base de datos H2
Puedes acceder a la base de datos desde la siguiente url:

- URL: http://localhost:8080/h2-console

Configuración:

- JDBC URL: jdbc:h2:mem:testdb
- Username: h2
- Password: h2

## 🟩 Flujo de autenticación (JWT)
La API utiliza autenticación basada en JSON Web Tokens.

Este es el lujo:

- Login con usuario y contraseña
- La API devuelve un token JWT
- El cliente envía el token en el header Authorization
- Los endpoints protegidos verifican el token

## 🟩 Endpoints

### Iniciar sesión y obtener TOKEN
POST http://localhost:8080/auth/login

JSON BODY:
```json
{
  "username": "admin",
  "password": "admin123"
}
```

### Crear usuario
POST http://localhost:8080/users

JSON BODY:
```json
{
  "username": "JuanJesus",
  "password": "123",
  "role": "ROLE_USER"
}
```

Header requerido: Authorization |  Bearer <TOKEN_ADMIN>

(Solo los usuarios con rol ADMIN pueden crear usuarios).

### Listar usuarios
GET http://localhost:8080/users

Header requerido: Authorization |  Bearer <TOKEN_ADMIN>

### Login de usuario
POST http://localhost:8080/auth/login
JSON BODY:
```json
{
  "username": "admin",
  "password": "1234"
}
```
Header: Authorization   Bearer (Poner Token Admin)

Nota: La contraseña se almacena de forma segura encriptada con BCrypt.

## 🟩 Seguridad

- Las contraseñas se almacenan usando BCrypt
- La autenticación se gestiona mediante JWT
- Los endpoints están protegidos con SPring Security
- Solo usuarios con ROLE_ADMIN pueden gestionar usuarios

## 👨‍💻 Autor
Proyecto desarrollado por Juan Jesús González Hernández
Backend Developer Junior
