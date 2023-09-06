-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_appestudiantil
-- ------------------------------------------------------
-- Server version	5.7.23

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
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura` (
  `idasignatura` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cantHoras` int(11) DEFAULT NULL,
  `cuatrimestre` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `idCarrera` int(11) DEFAULT NULL,
  PRIMARY KEY (`idasignatura`),
  KEY `idCarrera_idx` (`idCarrera`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,'programacion',NULL,NULL,NULL,NULL,NULL,1),(2,'matematica',NULL,NULL,NULL,NULL,NULL,1),(3,'anatomia',NULL,NULL,NULL,NULL,NULL,2),(4,'quimica',NULL,NULL,NULL,NULL,NULL,2),(5,'base de datos',NULL,NULL,NULL,NULL,NULL,1),(6,'farmacologia',NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `idcarrera` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `duracion` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `sede` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcarrera`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'sistemas',NULL,NULL,'','UTN'),(2,'medicina',NULL,NULL,'','UNC');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `idCarrera` int(11) DEFAULT NULL,
  `universidad` varchar(45) DEFAULT NULL,
  `fechaIngreso` varchar(45) DEFAULT NULL,
  `promedio` varchar(45) DEFAULT NULL,
  `idMatricula` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEstudiante`),
  KEY `idMatricula_idx` (`idMatricula`),
  KEY `idCarrera_idx` (`idCarrera`),
  CONSTRAINT `idCarrera` FOREIGN KEY (`idCarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idMatricula` FOREIGN KEY (`idMatricula`) REFERENCES `matricula` (`idmatricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'nico','enrico',123,'casanueva','123',1,'utn',NULL,'10',1),(2,'lucas','suarez',234,'casa2','1234',2,'unc',NULL,'5',2),(4,'Juan','Perez',12345678,'Av. Siempre Viva 123','123456789',1,'UTN','3919-04-01','0.0',4),(5,'Juan','Perez',12345678,'Av. Siempre Viva 123','123456789',2,'UNC','1969-12-31','0.0',0),(7,'Juan','Perez',12345678,'Av. Siempre Viva 123','123456789',1,'UTN','2023-09-06','0.0',0),(8,'juan','pruebas',234,'casa','1234',1,'utn','2023-09-06','0.0',0);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `idmatricula` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `nombreInstituto` varchar(45) DEFAULT NULL,
  `fechaMatriculacion` date DEFAULT NULL,
  PRIMARY KEY (`idmatricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (0,'no matriculado',NULL,NULL),(1,'Activa','UTN','2023-09-06'),(2,'Activa','UNC','2023-09-06'),(4,'Activa','UTN','2023-09-06');
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriculaxasignatura`
--

DROP TABLE IF EXISTS `matriculaxasignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriculaxasignatura` (
  `idmatricula` int(11) NOT NULL,
  `idasignatura` int(11) NOT NULL,
  PRIMARY KEY (`idmatricula`,`idasignatura`),
  KEY `idasignatura_idx` (`idasignatura`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriculaxasignatura`
--

LOCK TABLES `matriculaxasignatura` WRITE;
/*!40000 ALTER TABLE `matriculaxasignatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `matriculaxasignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plandeestudio`
--

DROP TABLE IF EXISTS `plandeestudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plandeestudio` (
  `idPlan` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `asignaturas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plandeestudio`
--

LOCK TABLES `plandeestudio` WRITE;
/*!40000 ALTER TABLE `plandeestudio` DISABLE KEYS */;
/*!40000 ALTER TABLE `plandeestudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `idprofesor` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `asignaturas` varchar(45) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `estadoLaboral` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idprofesor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-06 19:16:16
