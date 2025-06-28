# 🧩 Perfulandia Microservicios

Proyecto desarrollado como parte del proceso de **transformación digital de Perfulandia SPA**, migrando desde una arquitectura monolítica a una basada en **microservicios distribuidos**.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.5.x**
- **Gradle**
- **Spring Data JPA**
- **OpenFeign** (comunicación REST entre microservicios)
- **MySQL**
- **Lombok**
- **Postman** (para pruebas de endpoints)

## 🏗️ Arquitectura de Microservicios

La arquitectura está organizada en tres capas:

### 🎯 **BFF (Backend for Frontend)** - Puertos 8089-8093
- `ms-usuario-bff` (Puerto: 8089)
- `ms-catalogo-bff` (Puerto: 8090)
- `ms-venta-bff` (Puerto: 8091)
- `ms-pedido-bff` (Puerto: 8092)
- `ms-envio-bff` (Puerto: 8093)

### ⚙️ **BS (Business Services)** - Puertos 8081-8087, 8094
- `ms-usuario-bs` (Puerto: 8081)
- `ms-catalogo-bs` (Puerto: 8083)
- `ms-venta-bs` (Puerto: 8085)
- `ms-pedido-bs` (Puerto: 8087)
- `ms-envio-bs` (Puerto: 8094)

### 🗄️ **DB (Database Services)** - Puertos 8080, 8082, 8084, 8086, 8088
- `ms-usuario-db` (Puerto: 8080) - Base de datos: `usuarios`
- `ms-catalogo-db` (Puerto: 8082) - Base de datos: `catalogo`
- `ms-venta-db` (Puerto: 8084) - Base de datos: `ventas`
- `ms-pedido-db` (Puerto: 8086) - Base de datos: `pedidos`
- `ms-envio-db` (Puerto: 8088) - Base de datos: `envio`

## 📊 Modelo de Datos

### Usuario
```java
{
    "id": Long,
    "nombre": String,
    "correo": String,
    "activo": boolean
}
```

### Catálogo
```java
{
    "id": Long,
    "nombre": String,
    "precio": Integer,
    "stock": Integer
}
```

### Pedido
```java
{
    "id": Long,
    "clienteId": Long,
    "productoId": Long,
    "cantidad": Integer,
    "estado": String // CREADO, PROCESADO, CANCELADO
}
```

### Venta
```java
{
    "id": Long,
    "usuarioId": Long,
    "catalogoId": Long,
    "cantidad": Integer,
    "total": Integer,
    "fecha": String
}
```

### Envío
```java
{
    "id": Long,
    "pedidoId": Long,
    "direccion": String,
    "estado": String, // PENDIENTE, ENVIADO, ENTREGADO
    "fechaEnvio": LocalDate
}
```

## 🔗 Comunicación entre Microservicios

Los servicios BS (Business Services) utilizan **OpenFeign** para comunicarse con los servicios DB y entre sí:

- **ms-pedido-bs** → comunica con `ms-pedido-db`, `ms-usuario-db`, `ms-catalogo-db`
- **ms-envio-bs** → comunica con `ms-envio-db`, `ms-pedido-db`
- **ms-venta-bs** → comunica con `ms-venta-db`, `ms-usuario-db`, `ms-catalogo-db`

## 🗃️ Estado de las bases de datos

Las tablas se crean automáticamente al ejecutar cada microservicio.
No se insertan datos por defecto, pero puedes hacerlo manualmente vía Postman o SQL.

### Configuración de Base de Datos

Cada microservicio DB utiliza una base de datos MySQL diferente:

```properties
# Configuración común
spring.datasource.url=jdbc:mysql://localhost:3306/{nombre_db}?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## 🚀 Instrucciones de Ejecución

1. **Iniciar base de datos MySQL** en el puerto 3306
2. **Ejecutar microservicios en orden:**
   
   ```bash
   # 1. Primero los servicios DB
   cd ms-usuario-db/ms-usuario-db && ./gradlew bootRun
   cd ms-catalogo-db/ms-catalogo-db && ./gradlew bootRun
   cd ms-pedido-db/ms-pedido-db && ./gradlew bootRun
   cd ms-venta-db/ms-venta-db && ./gradlew bootRun
   cd ms-envio-db/ms-envio-db && ./gradlew bootRun
   
   # 2. Luego los servicios BS
   cd ms-usuario-bs/ms-usuario-bs && ./gradlew bootRun
   cd ms-catalogo-bs/ms-catalogo-bs && ./gradlew bootRun
   cd ms-pedido-bs/ms-pedido-bs && ./gradlew bootRun
   cd ms-venta-bs/ms-venta-bs && ./gradlew bootRun
   cd ms-envio-bs/ms-envio-bs && ./gradlew bootRun
   
   # 3. Finalmente los servicios BFF
   cd ms-usuario-bff/ms-usuario-bff && ./gradlew bootRun
   cd ms-catalogo-bff/ms-catalogo-bff && ./gradlew bootRun
   cd ms-pedido-bff/ms-pedido-bff && ./gradlew bootRun
   cd ms-venta-bff/ms-venta-bff && ./gradlew bootRun
   cd ms-envio-bff/ms-envio-bff && ./gradlew bootRun
   ```

## 📡 Endpoints Principales

### Usuarios
- GET `http://localhost:8081/usuarios` - Listar usuarios
- POST `http://localhost:8081/usuarios` - Crear usuario
- GET `http://localhost:8081/usuarios/{id}` - Obtener usuario

### Catálogo
- GET `http://localhost:8083/catalogo` - Listar productos
- POST `http://localhost:8083/catalogo` - Crear producto

### Pedidos
- GET `http://localhost:8087/pedidos` - Listar pedidos
- POST `http://localhost:8087/pedidos` - Crear pedido

### Ventas
- GET `http://localhost:8085/ventas` - Listar ventas
- POST `http://localhost:8085/ventas` - Crear venta

### Envíos
- GET `http://localhost:8094/envios` - Listar envíos
- POST `http://localhost:8094/envios` - Crear envío

## ✅ Estado del Proyecto

✅ **Arquitectura de microservicios implementada**  
✅ **DTOs estandarizados con Lombok**  
✅ **Comunicación Feign configurada**  
✅ **Base de datos MySQL configurada**  
✅ **Mapeo DTO ↔ Entity implementado**  
✅ **Puertos sin conflictos asignados**

## 🔧 Próximos Pasos

- [ ] Implementar manejo de excepciones global
- [ ] Agregar validaciones de entrada
- [ ] Integracíón otras APIs faltantes y frontend
- [ ] Agregar documentación Swagger
- [ ] Agregar tests unitarios e integración

