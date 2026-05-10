-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: medical_store
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `id` varchar(15) NOT NULL,
  `password` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('tofeeque','1',123);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` varchar(15) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `name` varchar(20) DEFAULT NULL,
  `customer_id` varchar(15) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Tofeeque','1'),('Ali Khan','101'),('Sara Ahmed','102'),('Usman Raza','103'),('Ayesha Malik','104'),('Bilal Hussain','105');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical` (
  `id` varchar(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `brand` varchar(15) NOT NULL,
  `type` varchar(15) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `mfg` date NOT NULL,
  `exp` date NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES ('1','Panadol','Brufin','Tablet',60,43.55,'2010-11-30','2011-12-31',NULL);
/*!40000 ALTER TABLE `medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_id` varchar(15) NOT NULL,
  `category_id` varchar(15) NOT NULL,
  `name` varchar(20) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `exp` date DEFAULT NULL,
  `mfg` date NOT NULL,
  PRIMARY KEY (`medicine_id`),
  UNIQUE KEY `medicine_id_UNIQUE` (`medicine_id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES ('1','9','panadol','HBO',20,64,'2024-09-23','2026-12-03'),('10','110','Calcium Tablets','Caltrate',180,140,'2027-05-05','2025-04-04'),('11','101','Paracetamol','Panadol',50,100,'2027-12-31','2025-01-01'),('12','104','Cetirizine','Zyrtec',60,90,'2027-03-25','2025-02-14'),('2','102','Ibuprofen','Brufen',80,150,'2026-10-15','2024-11-20'),('3','103','Amoxicillin','Amoxil',120,200,'2026-08-20','2024-09-10'),('4','1','airinac','gsk',22,73,'2030-09-09','2022-09-08'),('5','105','Metformin','Glucophage',200,75,'2028-01-01','2025-05-05'),('6','106','Aspirin','Disprin',40,300,'2027-07-30','2025-03-18'),('7','107','Omeprazole','Losec',150,120,'2026-11-11','2024-12-12'),('8','108','Azithromycin','Zithromax',250,60,'2026-09-09','2024-10-01'),('9','109','Vitamin C','Ceevit',30,500,'2028-06-06','2025-06-06');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `purchase_id` int NOT NULL AUTO_INCREMENT,
  `supplier_id` varchar(15) NOT NULL,
  `total_price` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`purchase_id`),
  UNIQUE KEY `purchase_id_UNIQUE` (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (3,'1',220,'2026-04-24'),(4,'1',0,'2026-04-24'),(5,'1',0,'2026-04-24'),(6,'2',660,'2026-04-24'),(7,'1',880,'2026-04-24'),(8,'1',440,'2026-04-24'),(9,'2',660,'2026-04-24'),(10,'2',660,'2026-04-24'),(11,'1',2000,'2026-04-25'),(12,'1',220,'2026-04-25'),(13,'2',400,'2026-04-25'),(14,'2',726,'2026-04-25'),(15,'1',1000,'2026-04-25');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_detail`
--

DROP TABLE IF EXISTS `purchase_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_detail` (
  `purchase_detail_id` int NOT NULL AUTO_INCREMENT,
  `purchase_id` int DEFAULT NULL,
  `medicine_id` varchar(15) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`purchase_detail_id`),
  UNIQUE KEY `purchase_detail_id_UNIQUE` (`purchase_detail_id`),
  UNIQUE KEY `purchase_id` (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
INSERT INTO `purchase_detail` VALUES (1,3,'4',10,22,220),(2,6,'4',30,22,660),(3,7,'4',40,22,880),(4,8,'4',20,22,440),(5,9,'4',30,22,660),(6,10,'4',30,22,660),(7,11,'1',100,20,2000),(8,12,'4',10,22,220),(9,13,'1',20,20,400),(10,14,'4',33,22,726),(11,15,'1',50,20,1000);
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`sale_id`),
  UNIQUE KEY `sale_id_UNIQUE` (`sale_id`),
  UNIQUE KEY `total_price` (`total_price`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (3,1,440,'2026-04-24'),(6,1,1100,'2026-04-24'),(7,1,100,'2026-04-25'),(8,1,1500,'2026-04-25'),(10,1,44,'2026-04-25'),(11,1,200,'2026-04-25'),(12,1,600,'2026-04-25'),(13,1,2200,'2026-04-25'),(14,1,NULL,'2026-04-25'),(15,1,NULL,'2026-04-25'),(16,1,NULL,'2026-04-25'),(17,1,NULL,'2026-04-25'),(18,101,NULL,'2026-05-06');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_detail`
--

DROP TABLE IF EXISTS `sales_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_detail` (
  `sale_detail_id` int NOT NULL AUTO_INCREMENT,
  `sale_id` varchar(15) NOT NULL,
  `medicine_id` varchar(15) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`sale_detail_id`),
  UNIQUE KEY `sale_detail_id_UNIQUE` (`sale_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_detail`
--

LOCK TABLES `sales_detail` WRITE;
/*!40000 ALTER TABLE `sales_detail` DISABLE KEYS */;
INSERT INTO `sales_detail` VALUES (1,'3','4',20,22,440),(2,'6','4',50,22,1100),(3,'7','1',5,20,100),(4,'8','2',100,15,1500),(5,'9','4',2,22,44),(6,'10','4',2,22,44),(7,'11','1',10,20,200),(8,'12','2',40,15,600),(9,'13','4',100,22,2200),(10,'14','2',1,15,15),(11,'15','1',3,20,60),(12,'16','1',30,20,600),(13,'17','1',50,20,1000),(14,'18','1',20,20,400);
/*!40000 ALTER TABLE `sales_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_id` varchar(20) NOT NULL,
  `supplier_name` varchar(20) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `address` varchar(40) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  UNIQUE KEY `supplier_id_UNIQUE` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('1','Ali Traders','03001234567','Karachi, Pakistan'),('2','Baloch Supplies','03119876543','Quetta, Pakistan');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'medical_store'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-06 12:08:59
