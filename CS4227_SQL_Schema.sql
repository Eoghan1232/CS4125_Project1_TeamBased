-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: cs4227-bookingapp-db.c14c8rsalbp0.eu-west-1.rds.amazonaws.com    Database: bookingappdb
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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `passenger_id` int NOT NULL,
  `route_id` int NOT NULL,
  `quantity` int DEFAULT '1',
  `date_time` datetime NOT NULL,
  `total_price` double NOT NULL,
  `transaction_id` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,4,1,5,'2021-02-27 15:51:00',300,1),(2,4,2,5,'2021-02-27 15:52:00',0,2),(3,4,3,1,'2021-02-27 15:52:00',60,3),(4,4,4,1,'2021-02-28 12:29:00',0,4);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connection`
--

DROP TABLE IF EXISTS `connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `connection` (
  `connection_id` int NOT NULL AUTO_INCREMENT,
  `station_one` varchar(45) NOT NULL,
  `station_two` varchar(45) NOT NULL,
  `transport_type` varchar(45) NOT NULL,
  `distance` double NOT NULL,
  PRIMARY KEY (`connection_id`),
  UNIQUE KEY `station_connection_id_UNIQUE` (`connection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connection`
--

LOCK TABLES `connection` WRITE;
/*!40000 ALTER TABLE `connection` DISABLE KEYS */;
INSERT INTO `connection` VALUES (1,'N1','N2','bus&bike',10),(2,'N1','N4','bus&bike&train',15),(3,'N2','N3','bus&train',25),(4,'N3','N5','bus&uber&taxi&train',30),(5,'N3','N8','plane',100),(6,'N4','N5','walk&bike',5),(7,'N1','N6','car&bus&uber&taxi',20),(8,'N1','N7','train&plane',80),(9,'N1','N3','walk&bike',2);
/*!40000 ALTER TABLE `connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `valid_users` varchar(2000) NOT NULL,
  `discount_percent` double NOT NULL,
  PRIMARY KEY (`discount_id`),
  UNIQUE KEY `discount_id_UNIQUE` (`discount_id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'EDRK','all',12),(2,'EDFF','1&2&3',10),(3,'DFRR','all',15);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `log_type` varchar(45) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `log_id_UNIQUE` (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=315 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'Log in request','2021-03-04 15:37:54'),(2,'Payment request','2021-03-04 15:44:24'),(3,'searchBooking,1','2021-03-06 16:56:41'),(4,'searchBooking Request','2021-03-06 17:00:13'),(5,'searchBooking Request','2021-03-06 17:11:03'),(6,'searchBooking Request','2021-03-06 17:15:33'),(7,'searchBooking Request','2021-03-06 17:15:45'),(8,'searchDiscountId Request','2021-03-14 14:59:04'),(9,'searchDiscountId Request','2021-03-14 14:59:18'),(10,'generateAllRoutes Request','2021-03-14 15:14:56'),(11,'generateAllRoutes Request','2021-03-14 15:18:13'),(12,'generateAllRoutes Request','2021-03-14 15:18:57'),(13,'generateAllRoutes Request','2021-03-14 15:20:50'),(14,'generateAllRoutes Request','2021-03-14 15:21:11'),(15,'generateAllRoutes Request','2021-03-14 15:21:28'),(16,'generateAllRoutes Request','2021-03-14 15:21:45'),(17,'generateAllRoutes Request','2021-03-14 15:22:49'),(18,'generateAllRoutes Request','2021-03-14 15:23:22'),(19,'generateAllRoutes Request','2021-03-14 15:32:37'),(20,'generateAllRoutes Request','2021-03-14 15:33:07'),(21,'generateAllRoutes Request','2021-03-14 15:35:46'),(22,'generateAllRoutes Request','2021-03-14 15:35:49'),(23,'generateAllRoutes Request','2021-03-14 15:41:12'),(24,'generateAllRoutes Request','2021-03-14 15:41:14'),(25,'generateAllRoutes Request','2021-03-14 15:41:14'),(26,'generateAllRoutes Request','2021-03-14 15:41:39'),(27,'generateAllRoutes Request','2021-03-14 15:44:37'),(28,'generateAllRoutes Request','2021-03-14 15:45:14'),(29,'generateAllRoutes Request','2021-03-14 15:49:05'),(30,'searchDiscountId Request','2021-03-15 16:16:55'),(31,'searchDiscountId Request','2021-03-15 16:55:37'),(32,'searchDiscountId Request','2021-03-15 16:55:39'),(33,'searchDiscountId Request','2021-03-15 16:56:45'),(34,'searchDiscountId Request','2021-03-15 16:56:48'),(35,'searchDiscountId Request','2021-03-15 16:56:50'),(36,'searchDiscountId Request','2021-03-15 16:56:51'),(37,'searchBooking Request','2021-03-15 16:57:11'),(38,'searchDiscountId Request','2021-03-15 17:17:12'),(39,'searchBooking Request','2021-03-15 17:17:15'),(40,'searchDiscountId Request','2021-03-15 17:22:29'),(41,'searchBooking Request','2021-03-16 17:05:17'),(42,'generateAllRoutes Request','2021-03-16 17:05:37'),(43,'generateAllRoutes Request','2021-03-16 17:06:12'),(44,'generateAllRoutes Request','2021-03-16 17:07:27'),(45,'generateAllRoutes Request','2021-03-16 17:07:56'),(46,'generateAllRoutes Request','2021-03-16 17:08:40'),(47,'generateAllRoutes Request','2021-03-16 17:09:09'),(48,'generateAllRoutes Request','2021-03-16 17:09:36'),(49,'generateAllRoutes Request','2021-03-16 17:09:48'),(50,'generateAllRoutes Request','2021-03-16 17:09:51'),(51,'generateAllRoutes Request','2021-03-16 17:10:38'),(52,'generateAllRoutes Request','2021-03-16 17:14:18'),(53,'generateAllRoutes Request','2021-03-16 17:15:03'),(54,'generateAllRoutes Request','2021-03-16 17:15:39'),(55,'generateAllRoutes Request','2021-03-16 17:16:18'),(56,'generateAllRoutes Request','2021-03-16 17:16:48'),(57,'searchDiscountId Request','2021-03-20 15:53:07'),(58,'generateAllRoutes Request','2021-03-20 15:53:13'),(59,'generateFilteredRoutes Request','2021-03-20 15:53:20'),(60,'generateFilteredRoutes Request','2021-03-20 15:53:24'),(61,'generateFilteredRoutes Request','2021-03-20 15:54:31'),(62,'generateFilteredRoutes Request','2021-03-20 16:10:49'),(63,'generateAllRoutes Request','2021-03-20 19:39:43'),(64,'generateAllRoutes Request','2021-03-20 19:47:46'),(65,'generateAllRoutes Request','2021-03-20 19:55:57'),(66,'generateAllRoutes Request','2021-03-20 19:59:11'),(67,'generateAllRoutes Request','2021-03-20 19:59:40'),(68,'generateAllRoutes Request','2021-03-20 20:00:02'),(69,'generateAllRoutes Request','2021-03-20 20:00:36'),(70,'generateAllRoutes Request','2021-03-20 20:00:38'),(71,'generateAllRoutes Request','2021-03-20 20:00:54'),(72,'generateAllRoutes Request','2021-03-20 20:00:56'),(73,'generateAllRoutes Request','2021-03-20 20:01:47'),(74,'generateAllRoutes Request','2021-03-20 20:01:50'),(75,'generateAllRoutes Request','2021-03-20 20:02:18'),(76,'generateAllRoutes Request','2021-03-20 20:02:21'),(77,'generateAllRoutes Request','2021-03-20 20:02:23'),(78,'generateAllRoutes Request','2021-03-20 20:02:57'),(79,'generateAllRoutes Request','2021-03-20 20:05:04'),(80,'generateAllRoutes Request','2021-03-20 20:05:08'),(81,'generateAllRoutes Request','2021-03-20 20:05:59'),(82,'generateAllRoutes Request','2021-03-20 20:07:39'),(83,'generateAllRoutes Request','2021-03-20 20:07:42'),(84,'generateAllRoutes Request','2021-03-20 20:08:55'),(85,'generateAllRoutes Request','2021-03-20 20:08:58'),(86,'generateAllRoutes Request','2021-03-20 20:09:50'),(87,'generateAllRoutes Request','2021-03-20 20:10:21'),(88,'generateAllRoutes Request','2021-03-20 20:14:57'),(89,'generateAllRoutes Request','2021-03-20 20:15:17'),(90,'generateAllRoutes Request','2021-03-20 20:17:08'),(91,'generateAllRoutes Request','2021-03-20 20:18:34'),(92,'generateAllRoutes Request','2021-03-20 20:19:40'),(93,'generateAllRoutes Request','2021-03-20 20:20:25'),(94,'generateAllRoutes Request','2021-03-20 20:20:28'),(95,'generateAllRoutes Request','2021-03-20 20:21:28'),(96,'generateAllRoutes Request','2021-03-20 20:22:22'),(97,'generateAllRoutes Request','2021-03-20 20:33:02'),(98,'generateAllRoutes Request','2021-03-20 20:33:16'),(99,'generateAllRoutes Request','2021-03-20 20:33:41'),(100,'generateAllRoutes Request','2021-03-20 20:34:09'),(101,'generateAllRoutes Request','2021-03-21 14:20:10'),(102,'generateAllRoutes Request','2021-03-21 14:20:13'),(103,'generateAllRoutes Request','2021-03-21 14:20:59'),(104,'generateAllRoutes Request','2021-03-21 14:21:46'),(105,'generateAllRoutes Request','2021-03-21 14:22:53'),(106,'generateAllRoutes Request','2021-03-21 14:22:55'),(107,'generateAllRoutes Request','2021-03-21 14:23:04'),(108,'generateAllRoutes Request','2021-03-21 14:23:07'),(109,'generateAllRoutes Request','2021-03-21 14:24:43'),(110,'generateAllRoutes Request','2021-03-21 14:24:46'),(111,'generateAllRoutes Request','2021-03-21 14:24:47'),(112,'generateAllRoutes Request','2021-03-21 14:25:24'),(113,'generateAllRoutes Request','2021-03-21 14:26:36'),(114,'generateAllRoutes Request','2021-03-21 14:27:13'),(115,'searchDiscountId Request','2021-03-21 21:32:01'),(116,'generateAllRoutes Request','2021-03-21 21:32:05'),(117,'generateAllRoutes Request','2021-03-21 21:35:15'),(118,'generateAllRoutes Request','2021-03-21 21:35:27'),(119,'generateAllRoutes Request','2021-03-21 21:36:30'),(120,'generateAllRoutes Request','2021-03-21 21:36:32'),(121,'generateAllRoutes Request','2021-03-21 21:37:59'),(122,'generateAllRoutes Request','2021-03-21 21:39:14'),(123,'generateAllRoutes Request','2021-03-21 21:39:52'),(124,'generateAllRoutes Request','2021-03-21 21:40:32'),(125,'generateFilteredRoutes Request','2021-03-21 21:42:20'),(126,'generateFilteredRoutes Request','2021-03-21 21:42:38'),(127,'searchBooking Request','2021-03-26 15:16:28'),(128,'searchBooking Request','2021-03-26 15:21:20'),(129,'searchBooking Request','2021-03-26 15:21:31'),(130,'login Request','2021-03-26 15:22:36'),(131,'searchBooking Request','2021-03-26 15:23:12'),(132,'searchBooking Request','2021-03-26 15:35:58'),(133,'generateAllRoutes Request','2021-03-26 15:36:06'),(134,'login Request','2021-03-26 15:37:41'),(135,'generateAllRoutes Request','2021-03-26 15:37:52'),(136,'login Request','2021-03-26 15:39:16'),(137,'generateAllRoutes Request','2021-03-26 15:39:24'),(138,'login Request','2021-03-26 15:40:46'),(139,'generateAllRoutes Request','2021-03-26 15:40:53'),(140,'generateAllRoutes Request','2021-03-26 15:45:44'),(141,'generateAllRoutes Request','2021-03-26 15:45:57'),(142,'generateAllRoutes Request','2021-03-26 15:47:52'),(143,'generateAllRoutes Request','2021-03-26 15:48:00'),(144,'generateAllRoutes Request','2021-03-26 15:51:42'),(145,'login Request','2021-03-26 15:56:14'),(146,'generateAllRoutes Request','2021-03-26 15:56:22'),(147,'generateAllRoutes Request','2021-03-26 15:56:30'),(148,'login Request','2021-03-26 16:21:10'),(149,'generateAllRoutes Request','2021-03-26 16:21:18'),(150,'login Request','2021-03-26 16:22:30'),(151,'generateAllRoutes Request','2021-03-26 16:22:38'),(152,'login Request','2021-03-26 16:23:50'),(153,'generateAllRoutes Request','2021-03-26 16:25:09'),(154,'login Request','2021-03-26 16:27:12'),(155,'generateAllRoutes Request','2021-03-26 16:27:22'),(156,'login Request','2021-03-26 16:29:51'),(157,'generateAllRoutes Request','2021-03-26 16:30:00'),(158,'login Request','2021-03-26 16:32:39'),(159,'generateAllRoutes Request','2021-03-26 16:33:10'),(160,'login Request','2021-03-26 16:38:59'),(161,'generateAllRoutes Request','2021-03-26 16:39:06'),(162,'login Request','2021-03-26 18:11:14'),(163,'generateAllRoutes Request','2021-03-26 18:11:26'),(164,'login Request','2021-03-26 18:14:42'),(165,'generateAllRoutes Request','2021-03-26 18:14:50'),(166,'login Request','2021-03-26 18:40:46'),(167,'generateAllRoutes Request','2021-03-26 18:40:55'),(168,'login Request','2021-03-26 20:10:09'),(169,'generateAllRoutes Request','2021-03-26 20:10:20'),(170,'addBooking Request','2021-03-26 20:10:32'),(171,'addBooking Request','2021-03-26 20:11:31'),(172,'login Request','2021-03-26 20:15:03'),(173,'generateAllRoutes Request','2021-03-26 20:15:11'),(174,'addBooking Request','2021-03-26 20:15:16'),(175,'addBooking Request','2021-03-26 20:18:16'),(176,'searchBooking Request','2021-03-26 20:18:42'),(177,'login Request','2021-03-26 20:23:52'),(178,'generateAllRoutes Request','2021-03-26 20:23:59'),(179,'addBooking Request','2021-03-26 20:24:12'),(180,'addBooking Request','2021-03-26 20:28:40'),(181,'addBooking Request','2021-03-26 20:28:41'),(182,'addBooking Request','2021-03-26 20:29:53'),(183,'searchBooking Request','2021-03-26 20:32:29'),(184,'searchBooking Request','2021-03-26 20:32:30'),(185,'searchBooking Request','2021-03-26 20:32:31'),(186,'searchBooking Request','2021-03-26 20:32:39'),(187,'searchBooking Request','2021-03-26 20:32:40'),(188,'login Request','2021-03-26 20:33:05'),(189,'generateAllRoutes Request','2021-03-26 20:33:13'),(190,'addBooking Request','2021-03-26 20:33:18'),(191,'addBooking Request','2021-03-26 20:38:09'),(192,'addBooking Request','2021-03-26 20:38:44'),(193,'addBooking Request','2021-03-26 20:38:45'),(194,'addBooking Request','2021-03-26 20:40:32'),(195,'addBooking Request','2021-03-26 20:40:33'),(196,'login Request','2021-03-26 20:43:38'),(197,'generateAllRoutes Request','2021-03-26 20:43:46'),(198,'addBooking Request','2021-03-26 20:43:54'),(199,'login Request','2021-03-26 20:47:43'),(200,'generateAllRoutes Request','2021-03-26 20:47:51'),(201,'login Request','2021-03-26 20:50:26'),(202,'generateAllRoutes Request','2021-03-26 20:50:33'),(203,'addBooking Request','2021-03-26 20:50:39'),(204,'addBooking Request','2021-03-26 20:51:08'),(205,'generateAllRoutes Request','2021-03-26 20:51:36'),(206,'addBooking Request','2021-03-26 20:51:39'),(207,'generateAllRoutes Request','2021-03-26 20:52:38'),(208,'addBooking Request','2021-03-26 20:52:41'),(209,'searchBooking Request','2021-03-26 20:58:29'),(210,'login Request','2021-03-26 20:58:32'),(211,'generateAllRoutes Request','2021-03-26 20:59:04'),(212,'addBooking Request','2021-03-26 20:59:08'),(213,'addBooking Request','2021-03-26 21:02:02'),(214,'addBooking Request','2021-03-26 21:02:54'),(215,'addBooking Request','2021-03-26 21:05:31'),(216,'addBooking Request','2021-03-26 21:08:11'),(217,'searchBooking Request','2021-03-26 21:10:57'),(218,'login Request','2021-03-26 21:11:12'),(219,'generateAllRoutes Request','2021-03-26 21:11:20'),(220,'addBooking Request','2021-03-26 21:11:25'),(221,'addBooking Request','2021-03-26 21:11:44'),(222,'addBooking Request','2021-03-26 21:11:55'),(223,'addBooking Request','2021-03-26 21:13:35'),(224,'addBooking Request','2021-03-26 21:15:32'),(225,'addBooking Request','2021-03-26 21:15:53'),(226,'addBooking Request','2021-03-26 21:16:10'),(227,'addBooking Request','2021-03-26 21:16:13'),(228,'addBooking Request','2021-03-26 21:16:48'),(229,'addBooking Request','2021-03-26 21:17:54'),(230,'addBooking Request','2021-03-26 21:20:13'),(231,'addBooking Request','2021-03-26 21:20:18'),(232,'login Request','2021-03-26 21:25:10'),(233,'generateAllRoutes Request','2021-03-26 21:26:31'),(234,'addBooking Request','2021-03-26 21:26:43'),(235,'login Request','2021-03-27 15:51:15'),(236,'generateAllRoutes Request','2021-03-27 15:51:24'),(237,'addBooking Request','2021-03-27 15:51:37'),(238,'updateTransaction Request','2021-03-27 15:52:05'),(239,'generateAllRoutes Request','2021-03-27 15:52:23'),(240,'addBooking Request','2021-03-27 15:52:29'),(241,'updateTransaction Request','2021-03-27 15:52:37'),(242,'generateAllRoutes Request','2021-03-27 15:52:50'),(243,'addBooking Request','2021-03-27 15:52:54'),(244,'login Request','2021-03-28 11:29:12'),(245,'login Request','2021-03-28 11:29:19'),(246,'generateAllRoutes Request','2021-03-28 11:29:57'),(247,'generateAllRoutes Request','2021-03-28 11:30:39'),(248,'addBooking Request','2021-03-28 11:31:31'),(249,'updateTransaction Request','2021-03-28 11:31:35'),(250,'login Request','2021-03-28 11:32:42'),(251,'generateAllRoutes Request','2021-03-28 11:32:50'),(252,'generateAllRoutes Request','2021-03-28 11:32:59'),(253,'generateFilteredRoutes Request','2021-03-28 11:33:35'),(254,'generateAllRoutes Request','2021-03-28 11:34:02'),(255,'generateFilteredRoutes Request','2021-03-28 11:35:08'),(256,'generateAllRoutes Request','2021-03-28 11:35:12'),(257,'generateAllRoutes Request','2021-03-28 11:35:40'),(258,'generateFilteredRoutes Request','2021-03-28 11:35:48'),(259,'generateFilteredRoutes Request','2021-03-28 11:36:27'),(260,'generateAllRoutes Request','2021-03-28 11:37:26'),(261,'generateFilteredRoutes Request','2021-03-28 11:38:23'),(262,'generateFilteredRoutes Request','2021-03-28 11:38:55'),(263,'generateAllRoutes Request','2021-03-28 11:39:07'),(264,'login Request','2021-03-28 12:10:56'),(265,'generateAllRoutes Request','2021-03-28 12:11:13'),(266,'login Request','2021-03-28 12:12:00'),(267,'login Request','2021-03-28 13:16:13'),(268,'login Request','2021-03-28 13:16:39'),(269,'login Request','2021-03-28 13:18:03'),(270,'login Request','2021-03-28 13:18:23'),(271,'generateAllRoutes Request','2021-03-28 13:18:48'),(272,'login Request','2021-03-28 13:20:52'),(273,'login Request','2021-03-28 13:22:20'),(274,'generateAllRoutes Request','2021-03-28 13:22:31'),(275,'login Request','2021-03-28 13:23:45'),(276,'generateAllRoutes Request','2021-03-28 13:23:56'),(277,'login Request','2021-03-28 13:24:41'),(278,'generateAllRoutes Request','2021-03-28 13:24:45'),(279,'login Request','2021-03-28 13:30:06'),(280,'login Request','2021-03-28 13:30:17'),(281,'login Request','2021-03-28 13:30:19'),(282,'login Request','2021-03-28 13:30:19'),(283,'login Request','2021-03-28 13:30:19'),(284,'login Request','2021-03-28 13:30:27'),(285,'login Request','2021-03-28 13:30:37'),(286,'register Request','2021-03-28 13:30:53'),(287,'login Request','2021-03-28 13:30:59'),(288,'login Request','2021-03-28 13:34:01'),(289,'login Request','2021-03-28 13:35:05'),(290,'login Request','2021-03-28 13:37:13'),(291,'login Request','2021-03-28 13:38:55'),(292,'login Request','2021-03-28 13:41:09'),(293,'login Request','2021-03-28 13:48:22'),(294,'login Request','2021-03-28 14:01:02'),(295,'login Request','2021-03-28 14:03:35'),(296,'login Request','2021-03-28 14:11:12'),(297,'login Request','2021-03-28 14:12:41'),(298,'login Request','2021-03-28 14:16:58'),(299,'login Request','2021-03-28 14:22:19'),(300,'login Request','2021-03-28 14:24:24'),(301,'login Request','2021-03-28 14:25:56'),(302,'login Request','2021-03-28 14:29:35'),(303,'login Request','2021-03-28 14:33:32'),(304,'login Request','2021-03-28 14:39:48'),(305,'login Request','2021-03-28 14:43:01'),(306,'login Request','2021-03-28 14:44:44'),(307,'login Request','2021-03-28 14:45:14'),(308,'login Request','2021-03-28 14:45:48'),(309,'login Request','2021-03-28 14:46:31'),(310,'login Request','2021-03-28 14:47:15'),(311,'login Request','2021-03-28 14:47:59'),(312,'login Request','2021-03-28 14:51:42'),(313,'login Request','2021-03-28 14:52:19'),(314,'login Request','2021-03-28 14:53:11');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `node` (
  `node_id` int NOT NULL AUTO_INCREMENT,
  `station_name` varchar(45) NOT NULL,
  `station_descriptions` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`node_id`),
  UNIQUE KEY `stationID_UNIQUE` (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,'N1','Station 1'),(2,'N2','Station 2'),(3,'N3','Station 3'),(4,'N4','Station 4'),(5,'N5','Station 5'),(6,'N6','Station 6'),(7,'N7','Station 7'),(8,'N8','Station 8');
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `start_station` varchar(45) NOT NULL,
  `end_station` varchar(45) NOT NULL,
  `connection_path` varchar(255) NOT NULL,
  PRIMARY KEY (`route_id`),
  UNIQUE KEY `route_id_UNIQUE` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'N1','N8','9&5'),(2,'N1','N2','1'),(3,'N1','N8','9&5'),(4,'N1','N2','1');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionrecord`
--

DROP TABLE IF EXISTS `transactionrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactionrecord` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `date_of_payment` datetime DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionrecord`
--

LOCK TABLES `transactionrecord` WRITE;
/*!40000 ALTER TABLE `transactionrecord` DISABLE KEYS */;
INSERT INTO `transactionrecord` VALUES (1,300,'2021-03-27 15:52:05',2),(2,0,'2021-03-27 15:52:37',2),(3,60,NULL,1),(4,0,'2021-03-28 11:31:35',2);
/*!40000 ALTER TABLE `transactionrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(45) NOT NULL,
  `usertype` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dummy','cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90','dummyEmail@gmail.com',1),(2,'test','cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90','test@gmail.com',1),(3,'coffee','37290d74ac4d186e3a8e5785d259d2ec04fac91ae28092e7620ec8bc99e830aa','IDrinkCoffee@gmail.com',1),(4,'testuser','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','dummyemail@yahoo.com',1),(5,'username','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','user@gmail.com',1),(6,'tester','9bba5c53a0545e0c80184b946153c9f58387e3bd1d4ee35740f29ac2e718b019','t@gmail.com',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-29 19:55:52
