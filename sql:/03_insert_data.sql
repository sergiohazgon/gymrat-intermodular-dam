
--Insertamos ejercicios

INSERT INTO ejercicio (id_ejercicio, nombre, grupo_muscular, descripcion, url_video) VALUES
(1, 'Press banca', 'Pecho', 'Ejercicio básico para pectoral con barra', 'https://www.youtube.com/results?search_query=press+banca'),
(2, 'Press inclinado mancuernas', 'Pecho', 'Trabajo de pecho superior', 'https://www.youtube.com/results?search_query=press+inclinado+mancuernas'),
(3, 'Dominadas', 'Espalda', 'Ejercicio de tracción para espalda', 'https://www.youtube.com/results?search_query=dominadas'),
(4, 'Remo con barra', 'Espalda', 'Ejercicio básico de remo', 'https://www.youtube.com/results?search_query=remo+con+barra'),
(5, 'Sentadilla', 'Pierna', 'Ejercicio principal de tren inferior', 'https://www.youtube.com/results?search_query=sentadilla'),
(6, 'Prensa', 'Pierna', 'Trabajo de cuádriceps en máquina', 'https://www.youtube.com/results?search_query=prensa+pierna'),
(7, 'Press militar', 'Hombro', 'Ejercicio de empuje vertical', 'https://www.youtube.com/results?search_query=press+militar'),
(8, 'Curl bíceps', 'Brazo', 'Ejercicio aislado para bíceps', 'https://www.youtube.com/results?search_query=curl+biceps');

--Insertamos rutinas

INSERT INTO rutina (id_rutina, nombre, objetivo) VALUES
(1, 'Push Day', 'Hipertrofia torso'),
(2, 'Pull Day', 'Espalda y bíceps'),
(3, 'Leg Day', 'Pierna completa'),
(4, 'Full Body', 'Entrenamiento general');

--Insertamos relación rutina-ejercicio

INSERT INTO rutina_ejercicio (id_rutina, id_ejercicio, series, repeticiones, orden) VALUES

-- PUSH DAY
(1, 1, 4, 8, 1),
(1, 2, 3, 10, 2),
(1, 7, 4, 8, 3),

-- PULL DAY
(2, 3, 4, 8, 1),
(2, 4, 4, 10, 2),
(2, 8, 3, 12, 3),

-- LEG DAY
(3, 5, 4, 8, 1),
(3, 6, 4, 12, 2),

-- FULL BODY
(4, 1, 3, 10, 1),
(4, 3, 3, 10, 2),
(4, 5, 3, 10, 3);