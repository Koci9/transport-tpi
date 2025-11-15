Módulo: common
===============
Contiene DTOs, excepciones y utilidades compartidas por los microservicios del proyecto.

- Se usa incluyendo el módulo `common` como dependencia en los otros módulos (pom.xml del microservicio):

```xml
<dependency>
<groupId>utnfrc.isi.back.tpi</groupId>
<artifactId>common</artifactId>
<version>1.0.0</version>
</dependency>
```

- Este módulo expone:
- DTOs para Solicitud / Cliente / Contenedor
- Manejo centralizado de errores (`GlobalExceptionHandler`)
- `DateTimeConfig` para configurar Jackson a fin de serializar JSR310 dates