-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2021 at 02:08 AM
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
(1, 'City, University of London (City) ', 'David Rhind', 'Northampton Square, London EC1V 0HB', '02070408000', 'David.Rhind@city.ac.uk', 'Fixed', 'Yes'),
(2, 'AirVia Ltd', 'Boris Berezovsky', '12, Bond Street, London WC1V 8HU', '02073218523', 'Boris.B@yahoo.com', 'Variable', 'Yes'),
(3, 'InfoPharma Ltd', 'Alex Wright ', '25 Bond Street, London WC1V 8LS ', '02073218001', 'Alex.Wright@infopharma.com', 'Flexible', 'Yes'),
(4, 'Hello Magazine ', 'Sarah Brocklehurst', '12 Charter Street, London W1 8NS', '02034567809', 'Sarah.Brocklehurst@hello.com', 'Flexible', 'Yes'),
(5, 'Eva Bauyer', 'Eva Bauyer', '1, Liverpool street, London EC2V 8NS', '02085558989', 'eva.bauyer@gmail.com', 'Fixed', 'Yes'),
(6, 'Ivan Grey', 'Ivan Grey', 'N/A', 'N/A', 'N/A', 'None', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `Discount_ID` int(11) NOT NULL,
  `DiscountRate` varchar(11) NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`Discount_ID`, `DiscountRate`, `CustomerAccount_No`) VALUES
(3, '0.97', 1);

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `Job_No` int(11) NOT NULL,
  `Start_Time` varchar(5) NOT NULL,
  `Priority` varchar(255) NOT NULL,
  `Special_Instructions` varchar(255) DEFAULT NULL,
  `Job_Status` varchar(255) NOT NULL DEFAULT 'Pending',
  `Date` date NOT NULL,
  `Deadline` date NOT NULL,
  `Price` double NOT NULL,
  `CustomerAccount_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`Job_No`, `Start_Time`, `Priority`, `Special_Instructions`, `Job_Status`, `Date`, `Deadline`, `Price`, `CustomerAccount_No`) VALUES
(1, '00:00', 'Normal', 'Nothing', 'Commenced', '2021-12-20', '2021-12-21', 74.5, 1),
(2, '00:00', 'Normal', 'Nothing', 'Commenced', '2021-12-23', '2021-12-24', 1993, 1),
(3, '00:00', 'Urgent', 'Nothing', 'Commenced', '2021-12-23', '2021-12-23', 497.5, 6);

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
(1, 497.5, '2021-12-23', 3, 6);

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

-- --------------------------------------------------------

--
-- Table structure for table `recordcashpayment`
--

CREATE TABLE `recordcashpayment` (
  `Payment_No` char(16) NOT NULL,
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(1, 'Manager', 'Manager', 'Get_it_done', 'Office Manager', 'Manager@gmail.com', 'Office Manager'),
(2, 'Accountant', 'Accountant', 'Count_money', 'Shift Manager', 'ShiftManager@gmail.com', 'Shift Manager'),
(3, 'Clerk', 'Clerk', 'Paperwork', 'Shift Manager', 'Clerk@gmaio.com', 'Shift Manager'),
(4, 'Hello', 'Hello', 'Hello_there', 'Receptionist', 'Receptionist@gmail.com', 'Receptionist'),
(5, 'Development', 'Development', 'Lot_smell', 'Technician', 'Development@gmail.com', 'A technician in the development area'),
(6, 'Copy', 'Copy', 'Too_dark', 'Technician', 'Copy@gmail.com', 'A technician in the copy room'),
(7, 'Packer', 'Packer', 'Pack_it', 'Technician', 'Packer@gmail.com', 'A technician in the packing room'),
(8, 'Finish', 'Finish', 'Fine_touch', 'Technician', 'Finish@gmail.com', 'A technician in the finishing room ');

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
  `Time_Taken` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`Task_ID`, `Task_Description`, `Start_Time`, `Location`, `Price`, `Duration`, `Shift`, `Date`, `Status`, `Completed_By`, `JobsJob_No`, `StaffStaff_Id`, `Time_Taken`) VALUES
(1, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(2, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(3, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(4, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(5, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(6, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 0),
(7, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(8, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(9, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(10, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(11, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(12, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 0),
(13, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 0),
(14, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 0),
(15, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 0),
(16, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 0),
(17, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 0),
(18, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(19, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(20, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(21, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(22, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(23, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(24, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(25, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(26, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(27, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(28, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(29, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(30, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(31, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(32, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(33, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(34, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(35, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(36, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(37, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(38, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(39, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(40, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(41, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(42, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(43, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(44, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(45, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(46, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(47, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 0),
(48, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(49, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(50, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(51, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(52, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(53, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(54, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(55, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(56, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(57, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(58, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(59, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(60, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(61, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(62, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(63, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(64, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(65, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(66, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(67, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 0),
(68, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(69, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(70, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(71, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(72, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(73, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(74, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(75, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(76, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(77, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 0),
(78, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 0),
(79, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 0),
(80, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 0),
(81, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 0),
(82, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 0),
(83, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 0);

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
  ADD PRIMARY KEY (`PaymentTransaction_ID`),
  ADD KEY `PaymentTransaction_ID` (`PaymentTransaction_ID`);

--
-- Indexes for table `recordcashpayment`
--
ALTER TABLE `recordcashpayment`
  ADD PRIMARY KEY (`PaymentTransaction_ID`),
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
  MODIFY `Account_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `discount`
--
ALTER TABLE `discount`
  MODIFY `Discount_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `Job_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `Staff_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `Task_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

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
