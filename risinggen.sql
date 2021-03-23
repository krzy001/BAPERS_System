-- MariaDB dump 10.19  Distrib 10.4.18-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: risinggen
-- ------------------------------------------------------
-- Server version	10.4.18-MariaDB

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (2,'Jeevzz','admin','edfwefqwf','07986545672','qwdqwdwq@gamil.com','Flexible','Yes');
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
  `DiscountRate` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL,
  PRIMARY KEY (`Discount_ID`),
  KEY `CustomerAccount_No` (`CustomerAccount_No`),
  CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
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
  `Start_Time` time(5) NOT NULL,
  `Priority` varchar(255) NOT NULL,
  `Special_Instructions` varchar(255) DEFAULT NULL,
  `Job_Status` varchar(255) NOT NULL DEFAULT 'Pending',
  `Date` date NOT NULL,
  `Deadline` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL,
  PRIMARY KEY (`Job_No`),
  KEY `CustomerAccount_No` (`CustomerAccount_No`),
  CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (6,'00:00:12.00000','high','nothing','In process','2014-05-15','14/12/12',12,2),(7,'00:00:12.00000','high','ewergr','comboBoxChanged','2012-12-12','13/12/12',12,2),(8,'00:00:12.00000','Low','fcwefwe','In progress','2012-12-12','14/12/12',121,2),(9,'00:20:00.00000','Medium','Nothing','High','2021-11-18','22/11/18',2000.2,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,120,'2013-12-13',6,2);
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
  PRIMARY KEY (`Card_No`),
  KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`),
  CONSTRAINT `recordcardpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordcardpayment`
--

LOCK TABLES `recordcardpayment` WRITE;
/*!40000 ALTER TABLE `recordcardpayment` DISABLE KEYS */;
INSERT INTO `recordcardpayment` VALUES ('1234567812345678','12/12','admin','No',1,123);
/*!40000 ALTER TABLE `recordcardpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recordcashpayment`
--

DROP TABLE IF EXISTS `recordcashpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recordcashpayment` (
  `Payment_No` char(16) NOT NULL,
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL,
  PRIMARY KEY (`Payment_No`),
  KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`),
  CONSTRAINT `recordcashpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordcashpayment`
--

LOCK TABLES `recordcashpayment` WRITE;
/*!40000 ALTER TABLE `recordcashpayment` DISABLE KEYS */;
INSERT INTO `recordcashpayment` VALUES ('1','Yes',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'admin','admin','user','Office Manager','admin123@gmail.com','Copy Room');
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
  `Location` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `Duration` varchar(11) NOT NULL,
  `Shift` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Completed_By` varchar(255) NOT NULL,
  `JobsJob_No` int(10) NOT NULL,
  `StaffStaff_Id` int(10) NOT NULL,
  PRIMARY KEY (`Task_ID`),
  KEY `StaffStaff_Id` (`StaffStaff_Id`),
  KEY `JobsJob_No` (`JobsJob_No`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`StaffStaff_Id`) REFERENCES `staff` (`Staff_ID`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (6,'hi','office',120,'2hrs',2,'2014-11-12','','admin',6,1);
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

-- Dump completed on 2021-03-23 17:28:13
