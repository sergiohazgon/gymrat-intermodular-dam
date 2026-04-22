# Análisis de datos - GymRat

## Introducción

La aplicación GymRat está orientada a la gestión básica de rutinas de entrenamiento y ejercicios de gimnasio. Para ello, se ha diseñado una base de datos relacional que permite almacenar ejercicios disponibles, rutinas creadas y la relación entre ambas entidades.

El objetivo principal es ofrecer una estructura de datos sencilla, escalable y adecuada para una futura integración con una aplicación Java mediante JDBC.


## Información que maneja la aplicación

La aplicación gestionará principalmente los siguientes tipos de información:

- Ejercicios de gimnasio clasificados por grupo muscular.
- Rutinas de entrenamiento personalizadas.
- Ejercicios incluidos en cada rutina.
- Número de series y repeticiones recomendadas.
- Orden de ejecución dentro de una rutina.


## Entidades principales

### Ejercicio

Representa cada ejercicio disponible en la aplicación.

Datos almacenados:

- id_ejercicio
- nombre
- grupo_muscular
- descripcion
- url_video

Ejemplo:
Press banca, Dominadas, Sentadilla.

### Rutina

Representa una rutina de entrenamiento creada dentro de la aplicación.

Datos almacenados:

- id_rutina
- nombre
- objetivo
- fecha_creacion

Ejemplo:
Push Day, Pull Day, Leg Day.

### Rutina_Ejercicio

Representa la relación entre una rutina y los ejercicios que la componen.

Además de enlazar ambas entidades, almacena información adicional propia de la relación.

Datos almacenados:

- id_rutina
- id_ejercicio
- series
- repeticiones
- orden

## Relaciones entre entidades

Una rutina puede contener varios ejercicios y un mismo ejercicio puede pertenecer a varias rutinas distintas.

Por este motivo, la relación entre Rutina y Ejercicio es de tipo muchos a muchos (N:M), resolviéndose mediante la tabla intermedia Rutina_Ejercicio.


## Justificación del diseño

Se ha optado por un diseño simple con tres tablas principales para facilitar:

- La normalización de datos.
- La reutilización de ejercicios en distintas rutinas.
- La consulta eficiente mediante JOIN.
- La futura integración con una aplicación Java.


## Posibles mejoras futuras

La base de datos podría ampliarse en futuras versiones con nuevas entidades como:

- Usuario
- Historial de entrenamientos
- Ejercicios favoritos
- Registro de pesos utilizados
- Estadísticas de progreso