# 🏥 Clinic Appointment Management System

Sistema de gestión de citas médicas desarrollado con **Spring Boot**, diseñado para optimizar la administración de clínicas privadas y resolver problemas críticos relacionados con la programación de citas, la gestión de usuarios y la disponibilidad de médicos.

---

## 📋 Descripción del Proyecto

Este sistema aborda los desafíos de las clínicas para gestionar de manera eficiente sus citas médicas, eliminando conflictos de horarios, duplicaciones y errores administrativos.
El sistema permite:
- Gestionar usuarios con roles definidos (pacientes, médicos, administradores).
- Agendar citas evitando conflictos de horarios.
- Revisar y gestionar el historial de pacientes.
- Facilitar la visualización de la disponibilidad médica.
- Proporcionar una interfaz segura y eficiente.

---

## 🚀 Tecnologías Principales

| Tecnología                  | Uso                                                                 |
|-----------------------------|---------------------------------------------------------------------|
| **Spring Boot**             | Desarrollo del backend.                                            |
| **Spring Data JPA**         | Manejo de la base de datos mediante ORM.                          |
| **Spring Security**         | Gestión de autenticación y autorización.                         |
| **PostgreSQL**              | Base de datos relacional para persistencia de datos.              |
| **Hibernate Validator**     | Validación de datos en las entidades.                             |
| **Swagger/OpenAPI**         | Documentación de la API REST.                                     |
| **JUnit 5 y Mockito**       | Pruebas unitarias e integración.                                  |
| **Docker**                  | Contenerización para despliegue ágil.                             |

---
## 🎯 Objetivos del Proyecto

### Problemas Resueltos

1. **Conflictos de Horarios:**
   - Control de disponibilidad de médicos en tiempo real.
   - Prevención de reservas simultáneas.
   - Gestión automatizada de reprogramaciones.

2. **Gestión de Citas:**
   - Eliminación de duplicaciones.
   - Registro centralizado de citas con seguimiento detallado.
   - Notificaciones para alertar sobre conflictos o cambios.

3. **Visualización de Disponibilidad:**
   - Acceso rápido y claro a los horarios médicos.
   - Reprogramación eficiente en caso de ausencia.

4. **Experiencia de Usuario:**
   - Interfaz intuitiva con acceso basado en roles.
   - Opciones avanzadas de filtrado de citas.
   - Seguridad robusta para proteger los datos de los pacientes.

---

## 🔐 Roles de Usuario

### 1. **Administrador**
- Gestión completa de usuarios.
- Configuración de especialidades y horarios.
- Generación de reportes y análisis.

### 2. **Personal Médico**
- Visualización y gestión de su propio calendario.
- Acceso al historial médico de los pacientes.
- Registro de notas para consultas.

### 3. **Paciente**
- Reserva de citas en horarios disponibles.
- Visualización de su historial de citas.
- Edición de su perfil personal.

---

## ✨ Características Principales

### Funcionalidades del Sistema
- Registro y autenticación de usuarios.
- Programación de citas con validaciones avanzadas.
- Gestión de horarios médicos.
- Seguimiento de citas pasadas.
- Generación de reportes (en desarrollo).

### Características Técnicas
- **Arquitectura Modular:** Separación lógica en controladores, servicios y repositorios.
- **API RESTful:** Endpoints claros y documentados.
- **Manejo de Excepciones:** Gestión personalizada de errores.
- **Seguridad:** Autenticación basada en JWT.

---
## 📊 Casos de Uso

### **CU-001: Registro de Usuarios**
**Actor(es):** Administrador

| Campo                | Descripción                                                           |
|----------------------|-----------------------------------------------------------------------|
| **Precondiciones**   | El administrador debe estar autenticado.                             |
| **Flujo Principal**  | 1. El administrador accede a la sección de "Usuarios".               |
|                      | 2. Completa el formulario con los datos del nuevo usuario.           |
|                      | 3. Envía la solicitud para registrar al usuario.                     |
| **Resultado Esperado** | El usuario se registra exitosamente en el sistema.                 |
| **Flujos Alternativos** | Si los datos son inválidos, se muestra un mensaje de error.        |

---

### **CU-002: Agendar una Cita**
**Actor(es):** Paciente

| Campo                | Descripción                                                           |
|----------------------|-----------------------------------------------------------------------|
| **Precondiciones**   | El paciente debe estar registrado y autenticado.                     |
| **Flujo Principal**  | 1. El paciente selecciona la fecha y especialidad.                   |
|                      | 2. El sistema muestra los horarios disponibles.                      |
|                      | 3. El paciente selecciona el horario deseado y confirma.             |
| **Resultado Esperado** | La cita se agenda exitosamente.                                     |
| **Flujos Alternativos** | Si el horario no está disponible, se sugieren horarios alternativos.|

---

### **CU-003: Visualizar Disponibilidad Médica**
**Actor(es):** Personal Médico

| Campo                | Descripción                                                           |
|----------------------|-----------------------------------------------------------------------|
| **Precondiciones**   | El médico debe estar registrado y autenticado.                       |
| **Flujo Principal**  | 1. El médico accede a la sección de "Horarios".                      |
|                      | 2. Visualiza su calendario con las citas programadas.                |
|                      | 3. Puede editar su disponibilidad según sea necesario.               |
| **Resultado Esperado** | La disponibilidad del médico se actualiza en tiempo real.          |
| **Flujos Alternativos** | Si ocurre un error, se muestra un mensaje indicando el problema.   |

---


## 🛠 Configuración del Proyecto

### Requisitos Previos
- JDK 17+
- Maven 3.8+


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
- 
### Users
- `GET/api/auth`

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

