Hola Grupo Coril, mi nombre es **Anderson Blas**, soy desarrollador de software y estoy deseoso de unirme a su equipo.

# CASO 01: Desarrolla un API

## Especificaciones
- Este ejercicio fue desarrolado con Springboot 3 y Java 17.
- Se utilizo webflux para programación reactiva.
- Se utilizó H2 para la persistencia de datos.
- Se implementó Json Web Token (JWT) para seguridad.

### Arquitectura de Software:
- Se utilizó una arquitectura hexagonal simplificada + Reactive clean

### Detalle de la arquitectura usada:
- **Controller (API layer):** 	Expone los endpoints REST, recibe solicitudes, valida y delega.
- **Service (Domain/Business layer):** Contiene la lógica de negocio (ej: calcular tipo de cambio, auditoría).
- **Repository (Data Access layer):** Acceso a la base de datos usando Spring Data R2DBC.
- **Security layer**: Maneja autenticación y validación de JWT tokens.
- **DTOs**: Objetos de transferencia para evitar exponer entidades directamente.
- **Model**: Entidades que representan las tablas en la base H2.





# Ejercicio 02: 
[Solucion del ejercicio 02](https://docs.google.com/document/d/1aYrB113LPdE47_FInCVtu2LU_DPsPpaTdBYWrYHeZls/edit?usp=sharing)
