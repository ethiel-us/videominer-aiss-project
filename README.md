# VideoMiner Project

Este proyecto es un **minador de plataformas de vídeo** desarrollado para la asignatura de AISS. Permite consultar, transformar y almacenar datos de canales y vídeos procedentes de **PeerTube** y **Dailymotion**.

---

## Arquitectura del Sistema

El proyecto sigue una arquitectura de microservicios compuesta por:

* **`videominer`**: El servidor central (Puerto `8080`). Gestiona la persistencia en una base de datos **H2** y ofrece la API principal de gestión.
  
* **`peertubeminer`**: Microservicio extractor (Puerto `8082`). Consume la API de PeerTube y mapea los datos al modelo de VideoMiner.
  
* **`dailymotionminer`**: Microservicio extractor (Puerto `8081`). Consume la API de Dailymotion, gestionando el mapeo de `User`/`Channel`.

## Monitoreo y Documentación

### Swagger UI (Documentación de API)
Puedes probar los endpoints directamente desde el navegador usando Swagger. Una vez que el servicio esté arrancado, accede a:

| Servicio | URL de Swagger |
| :--- | :--- |
| **VideoMiner** | [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) |

---

### Consola de Base de Datos (H2)
El servidor central almacena la información en una base de datos H2 en memoria. Para consultar las tablas `Channel`, `Video` `User`, `Comment`, `Caption`, accede a:

* **URL**: [http://localhost:8080/h2-ui](http://localhost:8080/h2-ui)
* **JDBC URL**: `jdbc:h2:mem:videodb`
* **User**: `sa`
* **Password**: *(vacío)*
