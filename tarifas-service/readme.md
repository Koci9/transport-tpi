tarifas-service
===============

Responsable de la gestión de tarifas y camiones, validación de capacidades y cálculo de costos por tramo.

Endpoints principales:
- GET /api/tarifas/camiones/disponibles
- POST /api/tarifas/camion/{id}/validar-capacidad
- GET /api/tarifas/camion/{id}/costeo?distanciaKm=...

Construcción y ejecución:
```bash
mvn clean package -DskipTests
docker build -t transport-tpi/tarifas-service .
```