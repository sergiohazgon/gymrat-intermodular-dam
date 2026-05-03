# Documentación XML/XSD - GymRat

## Qué representa el XML

El archivo `gymrat.xml` contiene los datos principales de la aplicación: el catálogo
de ejercicios disponibles y las rutinas de entrenamiento con sus ejercicios asignados.

La estructura refleja exactamente las tres tablas de la base de datos del proyecto:
`ejercicio`, `rutina` y `rutina_ejercicio`.

## Cómo está organizado

El documento tiene dos bloques principales:

- `<ejercicios>` — listado de ejercicios con su grupo muscular, descripción y enlace
  a vídeo (opcionales)
- `<rutinas>` — cada rutina con su nombre, objetivo y los ejercicios que tiene
  asignados, referenciados por ID

Los ejercicios asignados a una rutina no repiten los datos del ejercicio, solo
referencian su ID y añaden series, repeticiones y orden, igual que hace la tabla
`rutina_ejercicio` en la base de datos.

## Qué valida el XSD

El archivo `gymrat.xsd` valida que:

- Los IDs son enteros positivos
- `nombre`, `grupoMuscular`, `fechaCreacion`, `series`, `repeticiones` y `orden`
  son obligatorios
- `descripcion` y `urlVideo` son opcionales
- `objetivo` de la rutina es opcional (puede ser null, como en la BBDD)
- Las fechas siguen el formato `xs:date` (YYYY-MM-DD)
- Los enlaces de vídeo usan el tipo `xs:anyURI`

## Relación con el proyecto

El XML funciona como una exportación de datos desde la aplicación. La idea es que
en un futuro la app Java pueda generar este archivo automáticamente a partir de
una consulta a la base de datos, mostrando el estado actual de ejercicios y rutinas.