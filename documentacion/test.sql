-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquiler` (
  `id_alquiler` int NOT NULL AUTO_INCREMENT,
  `entregado` bit(1) NOT NULL,
  `fecha_entrega` datetime(6) DEFAULT NULL,
  `fecha_prestamo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_venta` bigint DEFAULT NULL,
  `cliente` int NOT NULL,
  PRIMARY KEY (`id_alquiler`),
  KEY `FK3uiw6kw2tyjyg664tau5882j5` (`cliente`),
  CONSTRAINT `FK3uiw6kw2tyjyg664tau5882j5` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
INSERT INTO `alquiler` VALUES (1,_binary '','2021-12-22 19:00:00.000000','2021-12-22 23:52:08',8000,2),(2,_binary '','2021-12-23 19:00:00.000000','2021-12-22 23:52:34',6000,1),(3,_binary '','2021-12-22 19:00:00.000000','2021-12-22 23:55:03',3000,1),(4,_binary '\0','2021-12-22 19:00:00.000000','2021-12-23 00:47:54',5000,3);
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'jhoan@gmail.com','ospina perez','159753','fernando','3108700938'),(2,'jhoan@gmail.com','ospina perez','894851','johan','65456465'),(3,'jhoan@gmail.com','ospina perez','4456565','uribe','154646111');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juego` (
  `id_juego` int NOT NULL AUTO_INCREMENT,
  `anio` int DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `productor` varchar(255) DEFAULT NULL,
  `protagonistas` varchar(255) DEFAULT NULL,
  `tecnologia` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `id_alquiler` int DEFAULT NULL,
  PRIMARY KEY (`id_juego`),
  KEY `FKfiaj4q5yp11g6a6g1uev79rts` (`id_alquiler`),
  CONSTRAINT `FKfiaj4q5yp11g6a6g1uev79rts` FOREIGN KEY (`id_alquiler`) REFERENCES `alquiler` (`id_alquiler`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (4,2000,'hender',_binary '\0',5000,'johan','no se sabe','play','god war',4),(5,2000,'hender',_binary '',6000,'johan','no se sabe','xbox','halo',2),(6,2000,'hender',_binary '',3000,'johan','no se sabe','nintendo','mario',1),(7,2000,'hender',_binary '',3000,'johan','no se sabe','nintendo','mario',3);
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-23  9:42:10
