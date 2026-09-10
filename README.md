# Plataforma de Reservas de Servicios — Caso 14

Equipo **EAV11** — CodeF@ctory, Universidad de Antioquia (Fábrica-Escuela).

## Equipo

- Daniel Mesa Patiño
- Juan Andrés Ramírez Patiño
- Ricardo Rodríguez Loaiza
- María del Carmen Segura Ortiz
- Valeria Isabel Vásquez Barragán

## Descripción del caso

Plataforma que permite a proveedores de servicios (clínicas, consultorios, salones de belleza, centros deportivos, etc.) definir agendas y horarios disponibles, y a usuarios crear y cancelar reservas sobre esos horarios, evitando dobles reservas y sobreocupación.

## Sprint 1 — alcance

- Definir agenda y horarios disponibles
- Crear una reserva
- Cancelar una reserva

## Arquitectura

Monolito modular: un único backend Spring Boot, con un solo despliegue y una sola base de datos PostgreSQL, organizado internamente por paquetes de dominio (`usuarios`, `proveedores`, `agendas`, `recursos`, `reservas`, `notificaciones`), cada uno con sus propias capas (controller / service / repository / model).

## Stack tecnológico

| Componente | Versión |
|---|---|
| Java (JDK) | 17 (Eclipse Temurin 17.0.18) |
| Spring Boot | 4.1.1 |
| Lenguaje | Java |
| Gestor de build | Maven |
| Base de datos | PostgreSQL (Supabase) |
| Empaquetado | Jar |
| Group | `com.udea.reservas` |
| Artifact | `plataforma-reservas` |
| Package base | `com.udea.reservas.plataformareservas` |

## Dependencias (backend)

| Dependencia | Artefacto Maven | Uso |
|---|---|---|
| Spring Web | `spring-boot-starter-web` | Exponer la API REST |
| Spring Data JPA | `spring-boot-starter-data-jpa` | Persistencia ORM |
| PostgreSQL Driver | `org.postgresql:postgresql` | Conexión a la base de datos |
| Validation | `spring-boot-starter-validation` | Validación de payloads de entrada |
| Lombok | `org.projectlombok:lombok` | Reducir código repetitivo (getters/setters/constructores) |
| Spring Boot Actuator | `spring-boot-starter-actuator` | Endpoint de salud `/actuator/health` |

> Las versiones de estas dependencias las administra el Spring Boot Parent POM (4.1.1); no se fijan manualmente, para garantizar compatibilidad entre ellas.

**Pendiente para próximos sprints:** Spring Security (HU de autenticación y roles, ubicada en el Sprint 2).

## Estructura del repositorio

```
plataforma-reservas/
├── README.md
└── backend/                          # Proyecto Spring Boot
    ├── pom.xml
    ├── mvnw / mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/com/udea/reservas/plataformareservas/
        │   └── resources/application.properties
        └── test/java/com/udea/reservas/plataformareservas/
```

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```
   git clone https://github.com/juanramirez50-beep/plataforma-reservas.git
```
2. Entrar a la carpeta del backend:
```
   cd plataforma-reservas/backend
```
3. Configurar la conexión a la base de datos en `src/main/resources/application.properties` con las credenciales de Supabase (no subir credenciales reales al repositorio; usar variables de entorno o un archivo local no versionado).
4. Ejecutar el proyecto:
```
   ./mvnw spring-boot:run
```
   o desde IntelliJ, correr la clase principal `PlataformaReservasApplication`.
5. Verificar que el servicio está arriba:
```
   GET /actuator/health
```

## Contexto académico

CodeF@ctory — Fábrica-Escuela, Universidad de Antioquia. Caso 14: Plataforma de Reservas de Servicios.
