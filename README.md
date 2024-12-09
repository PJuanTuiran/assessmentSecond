# assessmentSecond


    # 🏥 Clinic Appointment Management System

## 📋 Descripción del Proyecto

Sistema de gestión de citas médicas desarrollado con Spring Boot, diseñado para optimizar la administración de una clínica privada, abordando desafíos críticos en la programación de citas y la gestión de pacientes.

## 🚀 Tecnologías Principales

- **Backend**: Spring Boot 3.x
- **ORM**: Spring Data JPA
- **Base de Datos**: PostgreSQL
- **Seguridad**: Spring Security
- **Validación**: Hibernate Validator
- **Testing**: JUnit 5, Mockito
- **Documentación API**: Swagger/OpenAPI
- **Gestión de Dependencias**: Maven
- **Contenedorización**: Docker

## 🎯 Objetivos del Proyecto

### Problemas Resueltos
1. **Conflictos de Horarios**
    - Prevención de reservas simultáneas
    - Control de disponibilidad de médicos en tiempo real
    - Gestión eficiente de reprogramaciones

2. **Gestión de Citas**
    - Eliminación de citas duplicadas
    - Seguimiento detallado del historial de pacientes
    - Registro centralizado de información

3. **Experiencia de Usuario**
    - Interfaz intuitiva
    - Acceso basado en roles
    - Filtrado avanzado de citas

## ✨ Características Principales

### Funcionalidades de Gestión
- Registro y autenticación de usuarios
- Programación de citas con validaciones
- Gestión de disponibilidad de médicos
- Historial detallado de citas
- Notificaciones y alertas

### Características Técnicas
- Arquitectura modular
- API RESTful
- Seguridad robusta
- Manejo de excepciones personalizado
- Logging centralizado

## 🔐 Roles de Usuario

1. **Administrador**
    - Gestión completa de usuarios
    - Configuración del sistema
    - Reportes y analytics

2. **Personal Médico**
    - Gestión de su propio calendario
    - Acceso al historial de pacientes
    - Registro de notas de consulta

3. **Pacientes**
    - Reserva de citas
    - Visualización de historial
    - Gestión de perfil

## 🛠 Configuración del Proyecto

### Requisitos Previos
- JDK 17+
- Maven 3.8+
- PostgreSQL 13+
- Docker (opcional)

### Estructura del Proyecto
```
src/
│
├── main/
│   ├── java/
│   │   └── com/clinicamedica/
│   │       ├── controllers/
│   │       ├── services/
│   │       ├── repositories/
│   │       ├── models/
│   │       └── security/
│   │       └── utils/
│   │
│   └── resources/
│       ├── application.properties
│       └── application-dev.properties
│
├── test/
│   └── java/
│       └── com/clinicamedica/
│           ├── controllers/
│           └── services/
```

### Configuración de Entorno

1. Clonar el repositorio
   ```bash
   git clone https://github.com/tu-usuario/clinic-appointment-system.git
   cd clinic-appointment-system
   ```

2. Configurar variables de entorno
   Crear archivo `.env`:
   ```properties
 
   spring.datasource.url=jdbc:mysql://localhost:3306/assessment
   spring.datasource.username=root
   spring.datasource.password;
   
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   spring.jpa.hibernate.ddl-auto=update
   
   spring.jpa.show-sql=true
   ```


## 📊 Endpoints Principales

### Autenticación
- `POST /api/auth/registerAdmin`
- `POST /api/auth/registerDoctor`
- `POST /api/auth/registerPatient`
- `POST /api/auth/login`

### Citas
- `GET /api/appointment`
- `POST /api/appointment`
- `PUT /api/appointment/{id}`
- `DELETE /api/appointment/{id}`


### Schedules
- `GET /api/schedules`
- `GET /api/schedules/available/date/{date}`
- `GET api/schedules/doctor/{doctorId}/date/{date}`
- `POST /api/schedules`
- `DELETE /api/schedules/{id}`

### Specialties
- `GET /api/specialty`
- `GET /api/specialty/{id}`
- `POST api/specialty`
- `DELETE /api/specialty/{id}`




## 📈 Mejoras Futuras
- Integración con sistemas de pago
- Módulo de telemedicina
- Notificaciones por SMS/Email
- Implementación de IA para optimización de horarios

## 🤝 Contribución

1. Fork del repositorio
2. Crear rama de feature (`git checkout -b feature/mejora-increible`)
3. Commit de cambios (`git commit -m 'Añadir mejora increíble'`)
4. Push a la rama (`git push origin feature/mejora-increible`)
5. Abrir Pull Request

## 📋 Documentación Adicional
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Documentación de API: `http://localhost:8080/v3/api-docs`


## 👥 Contacto
juanfer20091403@gmail.com

### 🌟 ¡Gracias por tu interés en el proyecto!

