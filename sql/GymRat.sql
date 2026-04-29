-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-04-2026 a las 15:28:53
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `GymRat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

CREATE TABLE `ejercicio` (
  `id_ejercicio` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `grupo_muscular` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `url_video` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejercicio`
--

INSERT INTO `ejercicio` (`id_ejercicio`, `nombre`, `grupo_muscular`, `descripcion`, `url_video`) VALUES
(1, 'Press banca', 'Pecho', 'Ejercicio básico para pectoral con barra', 'https://www.youtube.com/results?search_query=press+banca'),
(2, 'Press inclinado mancuernas', 'Pecho', 'Trabajo de pecho superior', 'https://www.youtube.com/results?search_query=press+inclinado+mancuernas'),
(3, 'Dominadas', 'Espalda', 'Ejercicio de tracción para espalda', 'https://www.youtube.com/results?search_query=dominadas'),
(4, 'Remo con barra', 'Espalda', 'Ejercicio básico de remo', 'https://www.youtube.com/results?search_query=remo+con+barra'),
(5, 'Sentadilla', 'Pierna', 'Ejercicio principal de tren inferior', 'https://www.youtube.com/results?search_query=sentadilla'),
(6, 'Prensa', 'Pierna', 'Trabajo de cuádriceps en máquina', 'https://www.youtube.com/results?search_query=prensa+pierna'),
(7, 'Press militar', 'Hombro', 'Ejercicio de empuje vertical', 'https://www.youtube.com/results?search_query=press+militar'),
(8, 'Curl bíceps', 'Brazo', 'Ejercicio aislado para bíceps', 'https://www.youtube.com/results?search_query=curl+biceps');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

CREATE TABLE `rutina` (
  `id_rutina` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `objetivo` varchar(100) DEFAULT NULL,
  `fecha_creacion` date NOT NULL DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutina`
--

INSERT INTO `rutina` (`id_rutina`, `nombre`, `objetivo`, `fecha_creacion`) VALUES
(1, 'Push Day', 'Hipertrofia torso', '2026-04-22'),
(2, 'Pull Day', 'Espalda y bíceps', '2026-04-22'),
(3, 'Leg Day', 'Pierna completa', '2026-04-22'),
(4, 'Full Body', 'Entrenamiento general', '2026-04-22'),
(5, 'gis', 'pechito', '2026-04-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio`
--

CREATE TABLE `rutina_ejercicio` (
  `id_rutina` int(11) NOT NULL,
  `id_ejercicio` int(11) NOT NULL,
  `series` int(11) NOT NULL,
  `repeticiones` int(11) NOT NULL,
  `orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutina_ejercicio`
--

INSERT INTO `rutina_ejercicio` (`id_rutina`, `id_ejercicio`, `series`, `repeticiones`, `orden`) VALUES
(1, 1, 4, 8, 2),
(1, 2, 3, 10, 3),
(1, 3, 4, 20, 1),
(1, 7, 4, 8, 4),
(2, 3, 4, 8, 1),
(2, 8, 3, 12, 2),
(3, 5, 4, 8, 1),
(4, 1, 3, 10, 1),
(4, 2, 3, 10, 5),
(4, 3, 3, 10, 2),
(4, 4, 2, 13, 6),
(4, 7, 3, 12, 4),
(4, 8, 2, 25, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD PRIMARY KEY (`id_ejercicio`);

--
-- Indices de la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`id_rutina`);

--
-- Indices de la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD PRIMARY KEY (`id_rutina`,`id_ejercicio`),
  ADD KEY `id_ejercicio` (`id_ejercicio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `rutina`
--
ALTER TABLE `rutina`
  MODIFY `id_rutina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD CONSTRAINT `rutina_ejercicio_ibfk_1` FOREIGN KEY (`id_rutina`) REFERENCES `rutina` (`id_rutina`),
  ADD CONSTRAINT `rutina_ejercicio_ibfk_2` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicio` (`id_ejercicio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
