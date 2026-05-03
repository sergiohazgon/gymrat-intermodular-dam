# gymrat-intermodular-dam

## Descripción
GymRat es una aplicación que nace de la idea de ayudar a usuarios de gimnasio a planificar y organizar sus entrenamientos, consultar ejercicios y crear rutinas personalizadas de forma sencilla

## Problema que resuelve
Muchas personas entrenan sin una planificación clara. GymRat busca ofrecer una solución a esas personas que les cuesta consultar ejercicios y gestionar rutinas de entrenamiento.

## Tecnologías previstas
- Java
- MySQL
- JDBC
- XML / XSD
- Git y GitHub

## Estado del proyecto
Proyecto funcional con versión MVP completada. Permite gestionar ejercicios, rutinas y conexión con base de datos MySQL

## Estructura del repositorio

```text
gymrat-intermodular-dam/
├── src/main/java/
│   ├── dao/          → EjercicioDAO, RutinaDAO
│   ├── database/     → DBconnection
│   ├── model/        → Ejercicio, Rutina, RutinaEjercicio
│   └── main/         → Main
├── sql/              → scripts de creación e inserción de datos
├── docs/
│   ├── bbdd/         → diagrama E/R, modelo relacional y análisis
│   ├── xml/          → gymrat.xml, gymrat.xsd y evidencias de validación
│   ├── sistemas/     → informe técnico del entorno
│   ├── empleabilidad/→ perfil profesional, investigacion sector y reflexión personal
│   └── scrum/        → backlog y planificación de sprints
├── pom.xml
└── README.md
```

## Autor
Proyecto realizado por Sergio Hernández González para el Proyecto Intermodular de 1º DAM.
