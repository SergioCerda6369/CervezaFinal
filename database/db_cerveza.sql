-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2026 a las 03:50:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_cerveza`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calidad`
--

CREATE TABLE `calidad` (
  `id_calidad` int(11) NOT NULL,
  `cantidad_ph` int(11) NOT NULL,
  `control_calidad` bit(1) NOT NULL,
  `id_produccion` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribucion`
--

CREATE TABLE `distribucion` (
  `id_distribucion` int(11) NOT NULL,
  `estado_distribucion` varchar(100) NOT NULL,
  `nombre_conductor` varchar(255) NOT NULL,
  `patente_camion` varchar(6) NOT NULL,
  `id_pedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envasado`
--

CREATE TABLE `envasado` (
  `id_envasado` int(11) NOT NULL,
  `cantidad_envases` int(11) NOT NULL,
  `tipo_envase` varchar(255) NOT NULL,
  `id_stock_final` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fermentacion`
--

CREATE TABLE `fermentacion` (
  `id_fermentacion` int(11) NOT NULL,
  `codigo_tanque` varchar(10) NOT NULL,
  `temperatura_actual` int(11) NOT NULL,
  `id_produccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_materiales`
--

CREATE TABLE `inventario_materiales` (
  `id_material` int(11) NOT NULL,
  `cantidad_stock` int(11) NOT NULL,
  `nombre_material` varchar(255) NOT NULL,
  `nombre_proveedor` varchar(255) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE `mantenimiento` (
  `id_mantenimiento` int(11) NOT NULL,
  `codigo_equipo` varchar(10) NOT NULL,
  `estado_equipo` varchar(255) NOT NULL,
  `estado_mantenimiento` varchar(255) NOT NULL,
  `tipo_equipo` varchar(255) NOT NULL,
  `id_fermentacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL,
  `cantidad_solicitada` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `estado_pedido` varchar(50) NOT NULL,
  `total_venta` double NOT NULL,
  `id_stock_final` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion`
--

CREATE TABLE `produccion` (
  `id_produccion` int(11) NOT NULL,
  `estado_produccion` varchar(255) NOT NULL,
  `responsable_produccion` varchar(50) NOT NULL,
  `id_receta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `id_receta` int(11) NOT NULL,
  `nombre_receta` varchar(255) NOT NULL,
  `tiempo_coccion` int(11) NOT NULL,
  `tipo_cerveza` varchar(255) NOT NULL,
  `id_material` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock_final`
--

CREATE TABLE `stock_final` (
  `id_stock_final` int(11) NOT NULL,
  `cantidad_disponible` int(11) NOT NULL,
  `formato_distribucion` varchar(50) NOT NULL,
  `nombre_cerveza` varchar(100) NOT NULL,
  `precio_venta` int(11) NOT NULL
) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calidad`
--
ALTER TABLE `calidad`
  ADD PRIMARY KEY (`id_calidad`),
  ADD KEY `FK3wfnudii3k7nanoutep00r3tf` (`id_produccion`);

--
-- Indices de la tabla `distribucion`
--
ALTER TABLE `distribucion`
  ADD PRIMARY KEY (`id_distribucion`),
  ADD KEY `FK7u0kgeir08flju7sxxcn8i4xv` (`id_pedido`);

--
-- Indices de la tabla `envasado`
--
ALTER TABLE `envasado`
  ADD PRIMARY KEY (`id_envasado`),
  ADD KEY `FKoooh1iny6re9ip4xj797wbwoc` (`id_stock_final`);

--
-- Indices de la tabla `fermentacion`
--
ALTER TABLE `fermentacion`
  ADD PRIMARY KEY (`id_fermentacion`),
  ADD KEY `FKq5lip98p8j6xlefwd91nfcfxd` (`id_produccion`);

--
-- Indices de la tabla `inventario_materiales`
--
ALTER TABLE `inventario_materiales`
  ADD PRIMARY KEY (`id_material`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`id_mantenimiento`),
  ADD KEY `FK244c2lrkfo9g7o41nxyt8omdx` (`id_fermentacion`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FKk9fv1rohul7pdkj0vkya1vw0d` (`id_stock_final`);

--
-- Indices de la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD PRIMARY KEY (`id_produccion`),
  ADD KEY `FK9u03dk33bvdii46fj6btagg2s` (`id_receta`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`id_receta`),
  ADD KEY `FKaf8w2ffppbk899nocg5u6tax2` (`id_material`);

--
-- Indices de la tabla `stock_final`
--
ALTER TABLE `stock_final`
  ADD PRIMARY KEY (`id_stock_final`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calidad`
--
ALTER TABLE `calidad`
  MODIFY `id_calidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `distribucion`
--
ALTER TABLE `distribucion`
  MODIFY `id_distribucion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `envasado`
--
ALTER TABLE `envasado`
  MODIFY `id_envasado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `fermentacion`
--
ALTER TABLE `fermentacion`
  MODIFY `id_fermentacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inventario_materiales`
--
ALTER TABLE `inventario_materiales`
  MODIFY `id_material` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  MODIFY `id_mantenimiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `produccion`
--
ALTER TABLE `produccion`
  MODIFY `id_produccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recetas`
--
ALTER TABLE `recetas`
  MODIFY `id_receta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `stock_final`
--
ALTER TABLE `stock_final`
  MODIFY `id_stock_final` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calidad`
--
ALTER TABLE `calidad`
  ADD CONSTRAINT `FK3wfnudii3k7nanoutep00r3tf` FOREIGN KEY (`id_produccion`) REFERENCES `produccion` (`id_produccion`);

--
-- Filtros para la tabla `distribucion`
--
ALTER TABLE `distribucion`
  ADD CONSTRAINT `FK7u0kgeir08flju7sxxcn8i4xv` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`);

--
-- Filtros para la tabla `envasado`
--
ALTER TABLE `envasado`
  ADD CONSTRAINT `FKoooh1iny6re9ip4xj797wbwoc` FOREIGN KEY (`id_stock_final`) REFERENCES `stock_final` (`id_stock_final`);

--
-- Filtros para la tabla `fermentacion`
--
ALTER TABLE `fermentacion`
  ADD CONSTRAINT `FKq5lip98p8j6xlefwd91nfcfxd` FOREIGN KEY (`id_produccion`) REFERENCES `produccion` (`id_produccion`);

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `FK244c2lrkfo9g7o41nxyt8omdx` FOREIGN KEY (`id_fermentacion`) REFERENCES `fermentacion` (`id_fermentacion`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `FKk9fv1rohul7pdkj0vkya1vw0d` FOREIGN KEY (`id_stock_final`) REFERENCES `stock_final` (`id_stock_final`);

--
-- Filtros para la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD CONSTRAINT `FK9u03dk33bvdii46fj6btagg2s` FOREIGN KEY (`id_receta`) REFERENCES `recetas` (`id_receta`);

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `FKaf8w2ffppbk899nocg5u6tax2` FOREIGN KEY (`id_material`) REFERENCES `inventario_materiales` (`id_material`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
