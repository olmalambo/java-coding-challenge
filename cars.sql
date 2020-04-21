-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2020 a las 01:02:18
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cars`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `engines`
--

CREATE TABLE `engines` (
  `id` int(11) NOT NULL,
  `power` varchar(200) NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `file_process`
--

CREATE TABLE `file_process` (
  `id` int(11) NOT NULL,
  `file_name` varchar(200) NOT NULL,
  `creation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `model`
--

CREATE TABLE `model` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `fromModel` varchar(100) DEFAULT NULL,
  `toModel` varchar(100) DEFAULT NULL,
  `idWheel` int(11) NOT NULL,
  `idEngine` int(11) NOT NULL,
  `parentModel` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wheels`
--

CREATE TABLE `wheels` (
  `id` int(11) NOT NULL,
  `size` varchar(150) NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `engines`
--
ALTER TABLE `engines`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `file_process`
--
ALTER TABLE `file_process`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEngine` (`idEngine`),
  ADD KEY `idWheel` (`idWheel`),
  ADD KEY `parentModel` (`parentModel`);

--
-- Indices de la tabla `wheels`
--
ALTER TABLE `wheels`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `engines`
--
ALTER TABLE `engines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `file_process`
--
ALTER TABLE `file_process`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `model`
--
ALTER TABLE `model`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `wheels`
--
ALTER TABLE `wheels`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`idEngine`) REFERENCES `engines` (`id`),
  ADD CONSTRAINT `model_ibfk_2` FOREIGN KEY (`idWheel`) REFERENCES `wheels` (`id`),
  ADD CONSTRAINT `model_ibfk_3` FOREIGN KEY (`parentModel`) REFERENCES `model` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
