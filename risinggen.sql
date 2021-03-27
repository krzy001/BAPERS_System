-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2021 at 08:11 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `risinggen`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Account_No` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Contact_Name` varchar(255) NOT NULL,
  `Customer_Address` varchar(255) NOT NULL,
  `Phone_Number` char(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Discount_Plan` varchar(255) NOT NULL DEFAULT 'None',
  `Valued_Customer` varchar(255) NOT NULL DEFAULT 'False'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Account_No`, `Name`, `Contact_Name`, `Customer_Address`, `Phone_Number`, `Email`, `Discount_Plan`, `Valued_Customer`) VALUES
(2, 'Jeevzz', 'admin', 'edfwefqwf', '07986545672', 'qwdqwdwq@gamil.com', 'Flexible', 'Yes'),
(3, '', 'add', 'addd', '12345678901', 'sega06@', 'fixed', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `Discount_ID` int(11) NOT NULL,
  `DiscountRate` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `Job_No` int(11) NOT NULL,
  `Start_Time` time(5) NOT NULL,
  `Priority` varchar(255) NOT NULL,
  `Special_Instructions` varchar(255) DEFAULT NULL,
  `Job_Status` varchar(255) NOT NULL DEFAULT 'Pending',
  `Date` date NOT NULL,
  `Deadline` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`Job_No`, `Start_Time`, `Priority`, `Special_Instructions`, `Job_Status`, `Date`, `Deadline`, `Price`, `CustomerAccount_No`) VALUES
(6, '00:00:12.00000', 'high', 'nothing', 'In process', '2014-05-15', '14/12/12', 12, 2),
(7, '00:00:12.00000', 'high', 'ewergr', 'comboBoxChanged', '2012-12-12', '13/12/12', 12, 2),
(8, '00:00:12.00000', 'Low', 'fcwefwe', 'In progress', '2012-12-12', '14/12/12', 121, 2),
(9, '00:20:00.00000', 'Medium', 'Nothing', 'High', '2021-11-18', '22/11/18', 2000.2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `jobs_staff`
--

CREATE TABLE `jobs_staff` (
  `JobsJob_No` int(10) NOT NULL,
  `StaffStaff_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jobs_task`
--

CREATE TABLE `jobs_task` (
  `Jobs_Task_ID` int(11) NOT NULL,
  `JobsJob_No` int(11) NOT NULL,
  `TaskTask_ID` int(11) NOT NULL,
  `Status` varchar(255) DEFAULT 'Pending',
  `Date` date NOT NULL,
  `StaffStaff_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Transaction_ID` int(11) NOT NULL,
  `Total_amount` float NOT NULL,
  `Date` date NOT NULL,
  `JobsJob_No` int(11) NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Transaction_ID`, `Total_amount`, `Date`, `JobsJob_No`, `CustomerAccount_No`) VALUES
(1, 120, '2013-12-13', 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `recordcardpayment`
--

CREATE TABLE `recordcardpayment` (
  `Card_No` char(16) NOT NULL,
  `Expiry_Date` char(5) NOT NULL,
  `Card_Holder_Name` varchar(255) NOT NULL,
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL,
  `CVV` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recordcardpayment`
--

INSERT INTO `recordcardpayment` (`Card_No`, `Expiry_Date`, `Card_Holder_Name`, `Paid`, `PaymentTransaction_ID`, `CVV`) VALUES
('1234567812345678', '12/12', 'admin', 'No', 1, 123);

-- --------------------------------------------------------

--
-- Table structure for table `recordcashpayment`
--

CREATE TABLE `recordcashpayment` (
  `Payment_No` char(16) NOT NULL,
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recordcashpayment`
--

INSERT INTO `recordcashpayment` (`Payment_No`, `Paid`, `PaymentTransaction_ID`) VALUES
('1', 'Yes', 1);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Job_Role` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Department` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_ID`, `Name`, `Username`, `Password`, `Job_Role`, `Email`, `Department`) VALUES
(1, 'admin', 'admin', 'user', 'Office Manager', 'admin123@gmail.com', 'Copy Room'),
(2, 'test', 'test', 'test', 'Technician', 'test@gmail.com', 'Copy Room');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `Task_ID` int(11) NOT NULL,
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
  `Time_Taken` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`Task_ID`, `Task_Description`, `Start_Time`, `Location`, `Price`, `Duration`, `Shift`, `Date`, `Status`, `Completed_By`, `JobsJob_No`, `StaffStaff_Id`, `Time_Taken`) VALUES
(6, 'hi', '12:30', 'office', 120, '2hrs', 2, '2014-11-12', '', 'admin', 6, 1, '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Account_No`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`Discount_ID`),
  ADD KEY `CustomerAccount_No` (`CustomerAccount_No`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`Job_No`),
  ADD KEY `CustomerAccount_No` (`CustomerAccount_No`);

--
-- Indexes for table `jobs_staff`
--
ALTER TABLE `jobs_staff`
  ADD KEY `JobsJob_No` (`JobsJob_No`),
  ADD KEY `StaffStaff_ID` (`StaffStaff_ID`);

--
-- Indexes for table `jobs_task`
--
ALTER TABLE `jobs_task`
  ADD PRIMARY KEY (`Jobs_Task_ID`),
  ADD KEY `JobsJob_No` (`JobsJob_No`),
  ADD KEY `TaskTask_ID` (`TaskTask_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Transaction_ID`),
  ADD KEY `CustomerAccount_No` (`CustomerAccount_No`),
  ADD KEY `JobsJob_No` (`JobsJob_No`);

--
-- Indexes for table `recordcardpayment`
--
ALTER TABLE `recordcardpayment`
  ADD PRIMARY KEY (`Card_No`),
  ADD KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`);

--
-- Indexes for table `recordcashpayment`
--
ALTER TABLE `recordcashpayment`
  ADD PRIMARY KEY (`Payment_No`),
  ADD KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_ID`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`Task_ID`),
  ADD KEY `StaffStaff_Id` (`StaffStaff_Id`),
  ADD KEY `JobsJob_No` (`JobsJob_No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Account_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `discount`
--
ALTER TABLE `discount`
  MODIFY `Discount_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `Job_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `jobs_task`
--
ALTER TABLE `jobs_task`
  MODIFY `Jobs_Task_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `Staff_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `Task_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `discount`
--
ALTER TABLE `discount`
  ADD CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`);

--
-- Constraints for table `jobs`
--
ALTER TABLE `jobs`
  ADD CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`);

--
-- Constraints for table `jobs_staff`
--
ALTER TABLE `jobs_staff`
  ADD CONSTRAINT `jobs_staff_ibfk_1` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`),
  ADD CONSTRAINT `jobs_staff_ibfk_2` FOREIGN KEY (`StaffStaff_ID`) REFERENCES `staff` (`Staff_ID`);

--
-- Constraints for table `jobs_task`
--
ALTER TABLE `jobs_task`
  ADD CONSTRAINT `jobs_task_ibfk_1` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`),
  ADD CONSTRAINT `jobs_task_ibfk_2` FOREIGN KEY (`TaskTask_ID`) REFERENCES `task` (`Task_ID`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`CustomerAccount_No`) REFERENCES `customer` (`Account_No`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`);

--
-- Constraints for table `recordcardpayment`
--
ALTER TABLE `recordcardpayment`
  ADD CONSTRAINT `recordcardpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`);

--
-- Constraints for table `recordcashpayment`
--
ALTER TABLE `recordcashpayment`
  ADD CONSTRAINT `recordcashpayment_ibfk_1` FOREIGN KEY (`PaymentTransaction_ID`) REFERENCES `payment` (`Transaction_ID`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`StaffStaff_Id`) REFERENCES `staff` (`Staff_ID`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`JobsJob_No`) REFERENCES `jobs` (`Job_No`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
