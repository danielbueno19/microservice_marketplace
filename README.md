# Microservice Marketplace

## Descripción
Marketplace con arquitectura de microservicios desarrollado con Spring Boot 3.5.7 y Java 17.

Este proyecto implementa una plataforma de marketplace utilizando una arquitectura basada en microservicios, lo que permite una mayor escalabilidad, mantenibilidad y resiliencia del sistema.

## Estructura del Proyecto

El proyecto está organizado en los siguientes microservicios:

- **ms_producto**: Gestión de productos del marketplace
- **ms_reserva**: Gestión de reservas y pedidos
- **ms_stock**: Control de inventario y disponibilidad
- **ms_discoveryserver**: Servidor de descubrimiento para registro y localización de servicios
- **ms_configserver**: Servidor de configuración centralizada
- **ms_apigateway**: API Gateway para enrutamiento y filtrado de solicitudes

## Requisitos Previos

- Java 17
- Maven 3.6+
- Docker o Un servidor RabbitMQ instalado en el sistema
- Si tiene Docker con el siguiente comando:
  ```bash
  docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
  ```
  Este comando iniciará un servidor RabbitMQ con:
    - Puerto 5672 para conexiones AMQP
    - Puerto 15672 para la interfaz web de administración
    - Usuario predeterminado: guest
    - Contraseña predeterminada: guest

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de los microservicios
- **Spring Cloud**: Para la implementación de patrones de microservicios
- **Lombok**: Para reducción de código boilerplate
- **Maven**: Para gestión de dependencias y construcción del proyecto

## Instalación y Ejecución

### Clonar el repositorio
```bash
git clone [URL_DEL_REPOSITORIO]
cd microservice_marketplace
```

### Compilar el proyecto
```bash
mvn clean install
```

### Ejecutar los servicios
Para iniciar todos los servicios en el orden correcto:

1. Primero, el servidor de configuración:
```bash
cd ms_configserver
mvn spring-boot:run
```

2. Luego, el servidor de descubrimiento:
```bash
cd ../ms_discoveryserver
mvn spring-boot:run
```

3. Después, los servicios de negocio:
```bash
cd ../ms_producto
mvn spring-boot:run
```

```bash
cd ../ms_stock
mvn spring-boot:run
```

```bash
cd ../ms_reserva
mvn spring-boot:run
```

4. Finalmente, el API Gateway:
```bash
cd ../ms_apigateway
mvn spring-boot:run
```

## Configuración

Cada microservicio tiene su propia configuración que puede ser personalizada a través del servidor de configuración centralizada.

## Contribución

1. Haz un fork del proyecto
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -am 'Añadir nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crea un nuevo Pull Request

## Licencia

[Especificar la licencia del proyecto]

## Contacto

[Información de contacto del equipo o desarrolladores]