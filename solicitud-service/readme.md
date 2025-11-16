solicitud-service
=================

Servicio encargado de gestionar clientes, contenedores y solicitudes.

Endpoints principales:
- POST /api/solicitudes
- GET /api/solicitudes/{id}

Construcción:
```bash
mvn clean package -DskipTests
```

Docker build:
```bash
docker build -t transport-tpi/solicitud-service .
```