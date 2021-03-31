-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: risinggen
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `Account_No` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Contact_Name` varchar(255) NOT NULL,
  `Customer_Address` varchar(255) NOT NULL,
  `Phone_Number` char(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Discount_Plan` varchar(255) NOT NULL DEFAULT 'None',
  `Valued_Customer` varchar(255) NOT NULL DEFAULT 'False',
  PRIMARY KEY (`Account_No`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'City, University of London (City) ','David Rhind','Northampton Square, London EC1V 0HB','02070408000','David.Rhind@city.ac.uk','Fixed','Yes'),(2,'AirVia Ltd','Boris Berezovsky','12, Bond Street, London WC1V 8HU','02073218523','Boris.B@yahoo.com','Variable','Yes'),(3,'InfoPharma Ltd','Alex Wright ','25 Bond Street, London WC1V 8LS ','02073218001','Alex.Wright@infopharma.com','Flexible','Yes'),(4,'Hello Magazine ','Sarah Brocklehurst','12 Charter Street, London W1 8NS','02034567809','Sarah.Brocklehurst@hello.com','Flexible','Yes'),(5,'Eva Bauyer','Eva Bauyer','1, Liverpool street, London EC2V 8NS','02085558989','eva.bauyer@gmail.com','Fixed','Yes'),(6,'Ivan Grey','Ivan Grey','N/A','N/A','IvanGrey@gmail.com','None','No'),(10,'Boris Bridge','Boris Bridge','N/A','N/A','BorisBridge@gmail.com','None','No');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `Discount_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DiscountRate` varchar(11) NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL,
  PRIMARY KEY (`Discount_ID`),
  KEY `CustomerAccount_No` (`CustomerAccount_No`),
  CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (3,'0.97',1);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `Job_No` int(11) NOT NULL AUTO_INCREMENT,
  `Start_Time` varchar(5) NOT NULL,
  `Priority` varchar(255) NOT NULL,
  `Special_Instructions` varchar(255) DEFAULT NULL,
  `Job_Status` varchar(255) NOT NULL DEFAULT 'Pending',
  `Date` date NOT NULL,
  `Deadline` date NOT NULL,
  `Price` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL,
  PRIMARY KEY (`Job_No`),
  KEY `CustomerAccount_No` (`CustomerAccount_No`),
  CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'00:00','Normal','Nothing','Commenced','2021-12-20','2021-12-21',74.5,1),(2,'00:00','Normal','Nothing','Commenced','2021-12-23','2021-12-24',1993,1),(3,'00:00','Urgent','Nothing','Commenced','2021-12-23','2021-12-23',497.5,6),(4,'00:00','Normal','Nothing','Commenced','2021-12-28','2021-12-29',2155,4),(5,'00:00','Very Urgent','Nothing','Commenced','2022-01-10','2022-01-10',497.4,3),(6,'00:00','Urgent','Nothing','Commenced','2022-01-25','2022-01-25',515.4,10),(7,'00:00','Normal','Nothing','Commenced','0002-02-01','2022-02-02',1803,4);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_staff`
--

DROP TABLE IF EXISTS `jobs_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_staff` (
  `JobsJob_No` int(10) NOT NULL,
  `StaffStaff_ID` int(10) NOT NULL,
  KEY `JobsJob_No` (`JobsJob_No`),
  KEY `StaffStaff_ID` (`StaffStaff_ID`),
  CONSTRAINT `jobs_staff_ibfk_1` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`),
  CONSTRAINT `jobs_staff_ibfk_2` FOREIGN KEY (`StaffStaff_ID`) REFERENCES `staff` (`Staff_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_staff`
--

LOCK TABLES `jobs_staff` WRITE;
/*!40000 ALTER TABLE `jobs_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_task`
--

DROP TABLE IF EXISTS `jobs_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_task` (
  `Jobs_Task_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JobsJob_No` int(11) NOT NULL,
  `TaskTask_ID` int(11) NOT NULL,
  `Status` varchar(255) DEFAULT 'Pending',
  `Date` date NOT NULL,
  `StaffStaff_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Jobs_Task_ID`),
  KEY `JobsJob_No` (`JobsJob_No`),
  KEY `TaskTask_ID` (`TaskTask_ID`),
  CONSTRAINT `jobs_task_ibfk_1` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`),
  CONSTRAINT `jobs_task_ibfk_2` FOREIGN KEY (`TaskTask_ID`) REFERENCES `task` (`Task_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_task`
--

LOCK TABLES `jobs_task` WRITE;
/*!40000 ALTER TABLE `jobs_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Total_amount` float NOT NULL,
  `Date` date NOT NULL,
  `JobsJob_No` int(11) NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL,
  PRIMARY KEY (`Transaction_ID`),
  KEY `CustomerAccount_No` (`CustomerAccount_No`),
  KEY `JobsJob_No` (`JobsJob_No`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,497.5,'2021-12-23',3,6),(2,515.4,'2022-01-25',6,10),(3,74.5,'2022-01-10',1,1),(4,1993,'2022-01-10',2,1),(5,2155,'2022-01-05',4,4),(6,1803,'2022-01-05',7,4);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recordcardpayment`
--

DROP TABLE IF EXISTS `recordcardpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recordcardpayment` (
  `Card_No` char(16) NOT NULL,
  `Expiry_Date` char(5) NOT NULL,
  `Card_Holder_Name` varchar(255) NOT NULL,
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL,
  `CVV` int(3) NOT NULL,
  PRIMARY KEY (`PaymentTransaction_ID`),
  KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`),
  CONSTRAINT `recordcardpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordcardpayment`
--

LOCK TABLES `recordcardpayment` WRITE;
/*!40000 ALTER TABLE `recordcardpayment` DISABLE KEYS */;
INSERT INTO `recordcardpayment` VALUES ('2132132132139999','01/23','Boris Bridge','Yes',2,888),('0000000000000000','12/23','City, University of London','Yes',3,125),('0000000000000000','12/23','City, University of London','Yes',4,125),('1111111111111111','12/23','Hello Magazine','Yes',5,110),('1111111111111111','12/23','Hello Magazine','Yes',6,110);
/*!40000 ALTER TABLE `recordcardpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recordcashpayment`
--

DROP TABLE IF EXISTS `recordcashpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recordcashpayment` (
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL,
  PRIMARY KEY (`PaymentTransaction_ID`),
  KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`),
  CONSTRAINT `recordcashpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordcashpayment`
--

LOCK TABLES `recordcashpayment` WRITE;
/*!40000 ALTER TABLE `recordcashpayment` DISABLE KEYS */;
INSERT INTO `recordcashpayment` VALUES ('Yes',1);
/*!40000 ALTER TABLE `recordcashpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `Staff_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Job_Role` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Department` varchar(255) NOT NULL,
  PRIMARY KEY (`Staff_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Manager','Manager','Get_it_done','Office Manager','Manager@gmail.com','Office Manager'),(2,'Accountant','Accountant','Count_money','Shift Manager','ShiftManager@gmail.com','Shift Manager'),(3,'Clerk','Clerk','Paperwork','Shift Manager','Clerk@gmaio.com','Shift Manager'),(4,'Hello','Hello','Hello_there','Receptionist','Receptionist@gmail.com','Receptionist'),(5,'Development','Development','Lot_smell','Technician','Development@gmail.com','A technician in the development area'),(6,'Copy','Copy','Too_dark','Technician','Copy@gmail.com','A technician in the copy room'),(7,'Packer','Packer','Pack_it','Technician','Packer@gmail.com','A technician in the packing room'),(8,'Finish','Finish','Fine_touch','Technician','Finish@gmail.com','A technician in the finishing room ');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `Task_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Task_Description` varchar(255) NOT NULL,
  `Start_Time` varchar(5) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `Duration` varchar(11) NOT NULL,
  `Shift` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Completed_By` varchar(255) NOT NULL,
  `JobsJob_No` int(10) NOT NULL,
  `StaffStaff_Id` int(10) NOT NULL,
  `Time_Taken` int(5) NOT NULL,
  PRIMARY KEY (`Task_ID`),
  KEY `StaffStaff_Id` (`StaffStaff_Id`),
  KEY `JobsJob_No` (`JobsJob_No`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`StaffStaff_Id`) REFERENCES `staff` (`Staff_ID`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(2,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(3,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(4,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(5,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(6,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-20','Commenced','Copy',1,6,120),(7,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(8,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(9,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(10,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(11,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(12,'Black and white film processing','00:00','Development area',49.5,'60',0,'2021-12-20','Commenced','Development',1,5,60),(13,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-20','Commenced','Packer',1,7,30),(14,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-20','Commenced','Packer',1,7,30),(15,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-20','Commenced','Packer',1,7,30),(16,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-20','Commenced','Packer',1,7,30),(17,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-20','Commenced','Packer',1,7,30),(18,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(19,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(20,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(21,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(22,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(23,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(24,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(25,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(26,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(27,'Use of large copy camera','00:00','Copy Room',19,'120',0,'2021-12-23','Commenced','Copy',2,6,120),(28,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(29,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(30,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(31,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(32,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(33,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(34,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(35,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(36,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(37,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(38,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(39,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(40,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(41,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(42,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(43,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(44,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(45,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(46,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(47,'Bag up','00:00','Packing Departments ',6,'30',0,'2021-12-23','Commenced','Packer',2,7,30),(48,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(49,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(50,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(51,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(52,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(53,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(54,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(55,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(56,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(57,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(58,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(59,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(60,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(61,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(62,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(63,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(64,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(65,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(66,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(67,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-23','Commenced','Development',2,5,90),(68,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(69,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(70,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(71,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(72,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(73,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(74,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(75,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(76,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(77,'Use of small copy camera','00:00','Copy Room ',8.3,'75',0,'2021-12-23','Commenced','Copy',2,6,75),(78,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2021-12-23','Commenced','Development',3,5,180),(79,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2021-12-23','Commenced','Development',3,5,180),(80,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2021-12-23','Commenced','Development',3,5,180),(81,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2021-12-23','Commenced','Finish',3,8,45),(82,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2021-12-23','Commenced','Finish',3,8,45),(83,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2021-12-23','Commenced','Finish',3,8,45),(84,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(85,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(86,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(87,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(88,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(89,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(90,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(91,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(92,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(93,'Bag up','00:00','Packing Departments',6,'30 ',0,'2021-12-28','Commenced','Packer',4,7,30),(94,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(95,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(96,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(97,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(98,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(99,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(100,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(101,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(102,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(103,'Black and white film processing ','00:00','Development area',49.5,'60',0,'2021-12-28','Commenced','Development',4,5,60),(104,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(105,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(106,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(107,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(108,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(109,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(110,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(111,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(112,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(113,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(114,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(115,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(116,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(117,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(118,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(119,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(120,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(121,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(122,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(123,'Colour film processing','00:00','Development Area',80,'90',0,'2021-12-28','Commenced','Development',4,5,90),(124,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2022-01-10','Commenced','Development',5,5,180),(125,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2022-01-10','Commenced','Development',5,5,180),(126,'Colour Transparency processing','00:00','Development Area',110.3,'180',0,'2022-01-10','Commenced','Development',5,5,180),(127,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2022-01-10','Commenced','Finish',5,8,45),(128,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2022-01-10','Commenced','Finish',5,8,45),(129,'Mount Transparencies','00:00','Finishing Room',55.5,'45',0,'2022-01-10','Commenced','Finish',5,8,45),(130,'Bag up','00:00','Packing Departments ',6,'30',0,'2022-01-25','Commenced','Packer',6,7,30),(131,'Bag up','00:00','Packing Departments ',6,'30',0,'2022-01-25','Commenced','Packer',6,7,30),(132,'Bag up','00:00','Packing Departments ',6,'30',0,'2022-01-25','Commenced','Packer',6,7,30),(133,'Colour Transparency processing ','00:00','Development Area',110.3,'180',0,'2022-01-25','Commenced','Development',6,5,180),(134,'Colour Transparency processing ','00:00','Development Area',110.3,'180',0,'2022-01-25','Commenced','Development',6,5,180),(135,'Colour Transparency processing ','00:00','Development Area',110.3,'180',0,'2022-01-25','Commenced','Development',6,5,180),(136,'Mount Transparencies ','00:00','Finishing Room',55.5,'45 ',0,'2022-01-25','Commenced','Finish',6,8,45),(137,'Mount Transparencies ','00:00','Finishing Room',55.5,'45 ',0,'2022-01-25','Commenced','Finish',6,8,45),(138,'Mount Transparencies ','00:00','Finishing Room',55.5,'45 ',0,'2022-01-25','Commenced','Finish',6,8,45),(139,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(140,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(141,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(142,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(143,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(144,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(145,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(146,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(147,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(148,'Use of small copy camera','00:00','Copy Room',8.3,'75 ',0,'2022-02-01','Commenced','Copy',7,6,75),(149,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(150,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(151,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(152,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(153,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(154,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(155,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(156,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(157,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(158,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(159,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(160,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(161,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(162,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(163,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(164,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(165,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(166,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(167,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(168,'Bag up','00:00','Packing Departments ',6,'30 ',0,'2022-02-01','Commenced','Packer',7,7,30),(169,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(170,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(171,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(172,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(173,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(174,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(175,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(176,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(177,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(178,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(179,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(180,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(181,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(182,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(183,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(184,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(185,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(186,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(187,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90),(188,'Colour film processing ','00:00','Development Area',80,'90 ',0,'2022-02-01','Commenced','Development',7,5,90);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-31 14:22:06
