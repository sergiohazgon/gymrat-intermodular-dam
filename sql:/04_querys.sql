-- 1. Mostrar todos los ejercicios
SELECT * FROM ejercicio;

-- 2. Filtrar ejercicios por grupo muscular
SELECT * 
FROM ejercicio
WHERE grupo_muscular = 'Pecho';

-- 3. Buscar ejercicios por nombre
SELECT * 
FROM ejercicio
WHERE nombre LIKE '%press%';

-- 4. Mostrar todas las rutinas con sus ejercicios
SELECT r.nombre AS rutina,
       e.nombre AS ejercicio,
       re.series,
       re.repeticiones,
       re.orden
FROM rutina r
JOIN rutina_ejercicio re ON r.id_rutina = re.id_rutina
JOIN ejercicio e ON re.id_ejercicio = e.id_ejercicio
ORDER BY r.nombre, re.orden;

-- 5. Mostrar los ejercicios de una rutina concreta
SELECT r.nombre AS rutina,
       e.nombre AS ejercicio,
       re.series,
       re.repeticiones,
       re.orden
FROM rutina r
JOIN rutina_ejercicio re ON r.id_rutina = re.id_rutina
JOIN ejercicio e ON re.id_ejercicio = e.id_ejercicio
WHERE r.nombre = 'Push Day'
ORDER BY re.orden;

-- 6. Contar cuántos ejercicios tiene cada rutina
SELECT r.nombre AS rutina,
       COUNT(re.id_ejercicio) AS total_ejercicios
FROM rutina r
JOIN rutina_ejercicio re ON r.id_rutina = re.id_rutina
GROUP BY r.id_rutina, r.nombre;

-- 7. Mostrar ejercicios ordenados por grupo muscular
SELECT nombre, grupo_muscular
FROM ejercicio
ORDER BY grupo_muscular, nombre;