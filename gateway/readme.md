Gateway module
==============

Este módulo contiene el API Gateway del sistema usando Spring Cloud Gateway (WebFlux). Sus responsabilidades:
- Exponer una única entrada a la plataforma
- Validar tokens JWT emitidos por Keycloak
- Enrutar peticiones hacia los microservicios internos
- Proveer filtros globales (ej. logging)

Levantar localmente (maven build + docker-compose del proyecto root):

```bash
# build jar
mvn -DskipTests package
# build image si usás docker
docker build -t transport-tpi/gateway .
```

Variables de entorno útiles:
- KEYCLOAK_ISSUER (ej: http://keycloak:8080/realms/transport-tpi)