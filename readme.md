# 📦 Transport-TPI – Backend de Aplicaciones (UTN-FRC)
## Sistema de logística de transporte terrestre de contenedores
# Grupo 77 – 2025

# 🧭 Descripción General

Este proyecto implementa un backend basado en microservicios, desarrollado con Java 21 + Spring Boot 3, orientado a gestionar el transporte de contenedores desde un punto de origen hacia un destino, pasando opcionalmente por depósitos.

Incluye:
- Múltiples microservicios independientes
- API Gateway
- Keycloak como proveedor de identidad
- Integración con Google Maps API
- Base de datos PostgreSQL
- Swagger / OpenAPI
- Docker Compose para levantar todo el ecosistema

El sistema fue diseñado y construido en base al enunciado del Trabajo Práctico Integrador – Backend de Aplicaciones (2025).

# 🏗️ Arquitectura del Sistema
## 🧱 Microservicios

El sistema está compuesto por los siguientes servicios:

### 1) solicitud-service

Gestiona:
- Clientes
- Contenedores
- Solicitudes de transporte

Realiza:
- Registro de solicitudes
- Cálculo inicial de costo/tiempo estimado (coordinación con otros servicios)
- Consulta de estado para el cliente

### 2) ruta-service
Gestiona:
- Rutas
- Tramos
- Asignación de camiones
- Inicio y fin de tramo por transportista

Realiza:
- Obtención de distancias vía Google Maps API
- Flujo operativo de cada tramo
- Actualización de estados del traslado

### 3) tarifas-service

Gestiona:
- Tarifas
- Camiones
- Reglas de negocio de costos

Realiza:
- Determinación de camión elegible según peso/volumen
- Cálculo de costo por tramo y costo total
- Validaciones de capacidad del camión

### 4) common (módulo compartido)

Contiene:
- DTOs comunes
- Excepciones
- GlobalExceptionHandler
- Configuración de serialización de fechas
- Clases utilitarias

5) gateway

Provee:

Punto de entrada único

Validación JWT

Enrutamiento a microservicios internos

Filtros de auditoría y logging

6) Keycloak (proveedor de identidad)

Autenticación basada en OAuth2 / OpenID Connect

Roles utilizados:

CLIENTE

TRANSPORTISTA

OPERADOR

ADMIN

🗄️ Base de Datos

El sistema utiliza una única base de datos PostgreSQL para todos los microservicios (decisión tomada por el equipo).

Tablas principales:

CLIENTE

CONTENEDOR

SOLICITUD

RUTA

TRAMO

CAMION

TARIFA

DEPOSITO

El DER completo se encuentra en la entrega inicial.

📡 Comunicación entre servicios

Gateway → Microservicios vía HTTP

Microservicios → PostgreSQL

ruta-service → Google Maps API

Token JWT validado en Gateway y en cada microservicio

🔐 Seguridad

Autenticación mediante Keycloak

Microservicios configurados como OAuth2 Resource Servers

Cada endpoint restringido según rol

Los tokens se validan vía issuer-uri (OpenID Connect)

🧪 Documentación de API

Cada microservicio expone su documentación Swagger en:

http://localhost:<puerto>/swagger-ui/index.html


Puertos típicos:

Gateway → 8080

solicitud-service → 8081

ruta-service → 8082

tarifas-service → 8083

🐳 Ejecución con Docker Compose
1) Build del proyecto
mvn clean package -DskipTests

2) Levantar todo el ecosistema

Desde la carpeta raíz:

docker-compose up --build


Servicios que se levantan:

Keycloak

PostgreSQL

Gateway

solicitud-service

ruta-service

tarifas-service

3) Ingresar a Keycloak
http://localhost:8080/admin


Credenciales:

user: admin

pass: admin

(Realm importado automáticamente si se incluye en docker-compose)