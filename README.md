# Demo Project

## Requisitos
- Java 17
- Maven
- Docker y Docker Compose

## Comandos

### 1. Iniciar PostgreSQL
```bash
docker-compose up -d
```

### 2. Compilar el proyecto
```bash
mvn clean compile
```

### 3. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

### 4. Detener PostgreSQL
```bash
docker-compose down
```

## Acceso
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- PostgreSQL: localhost:5433
  - Base de datos: demo_db
  - Usuario: postgres
  - Contraseña: postgres

