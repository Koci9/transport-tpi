ruta-service
============

Servicio encargado de gestionar rutas, tramos, cálculo de distancias y flujo operativo del transporte.

Endpoints principales:
- POST /api/rutas
- PUT /api/tramos/{id}/iniciar
- PUT /api/tramos/{id}/finalizar

Para ejecutar:

```bash
mvn clean package -DskipTests
docker build -t transport-tpi/ruta-service .