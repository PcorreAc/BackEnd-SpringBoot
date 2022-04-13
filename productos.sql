-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-03-2022 a las 04:37:06
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `videojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL,
  `ano_lanz` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `desarrollador` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `idioma` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pg` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `plataforma` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `precio` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `urlvideo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `ano_lanz`, `desarrollador`, `descripcion`, `idioma`, `imagen`, `nombre`, `pg`, `plataforma`, `precio`, `stock`, `urlvideo`) VALUES
(1, '2022', 'cualquiera', 'aasdasdada', 'ES', NULL, 'nombre', '8+', 'XBOX', 9000, 8, NULL),
(2, '3242', 'DSADSADA', 'ADSDASDASDSA', 'ES', NULL, 'DSADSA', '', 'DASDA', 12345, 2, NULL),
(3, '4322', 'FDSFDS', 'DFSFDSFS', 'FD', NULL, 'FDSFDSFS', '', 'FDSFDSFDS', 23231, 2, NULL),
(4, '4321', 'CZXCXZCZC', 'CXZCXZCX', 'FS', NULL, 'GDSFSC', '', 'SACSAC', 654543, 4, NULL),
(5, '3212', 'DFSD', 'DSFSF', 'FD', NULL, 'CSACSA', '', 'SACASC', 2345, 2, NULL),
(6, '5665', 'NVBVB', 'BFDBFDB', 'BF', NULL, 'BFDBF', '', 'NGFBVB', 543, 5, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
