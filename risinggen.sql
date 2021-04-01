-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2021 at 11:51 AM
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
(6, 'Ivan Grey', 'Ivan Grey', 'N/A', 'N/A', 'IvanGrey@gmail.com', 'None', 'No'),
(10, 'Boris Bridge', 'Boris Bridge', 'N/A', 'N/A', 'BorisBridge@gmail.com', 'None', 'No');

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
(3, '0.97', 1),
(4, '0.97', 5);

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
(3, '00:00', 'Urgent', 'Nothing', 'Commenced', '2021-12-23', '2021-12-23', 497.5, 6),
(4, '00:00', 'Normal', 'Nothing', 'Commenced', '2021-12-28', '2021-12-29', 2155, 4),
(5, '00:00', 'Very Urgent', 'Nothing', 'Commenced', '2022-01-10', '2022-01-10', 497.4, 3),
(6, '00:00', 'Urgent', 'Nothing', 'Commenced', '2022-01-25', '2022-01-25', 515.4, 10),
(7, '00:00', 'Normal', 'Nothing', 'Commenced', '0002-02-01', '2022-02-02', 1803, 4);

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
(1, 497.5, '2021-12-23', 3, 6),
(2, 515.4, '2022-01-25', 6, 10),
(3, 74.5, '2022-01-10', 1, 1),
(4, 1993, '2022-01-10', 2, 1),
(5, 2155, '2022-01-05', 4, 4),
(6, 1803, '2022-01-05', 7, 4);

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
('2132132132139999', '01/23', 'Boris Bridge', 'Yes', 2, 888),
('0000000000000000', '12/23', 'City, University of London', 'Yes', 3, 125),
('0000000000000000', '12/23', 'City, University of London', 'Yes', 4, 125),
('1111111111111111', '12/23', 'Hello Magazine', 'Yes', 5, 110),
('1111111111111111', '12/23', 'Hello Magazine', 'Yes', 6, 110);

-- --------------------------------------------------------

--
-- Table structure for table `recordcashpayment`
--

CREATE TABLE `recordcashpayment` (
  `Paid` varchar(255) NOT NULL,
  `PaymentTransaction_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recordcashpayment`
--

INSERT INTO `recordcashpayment` (`Paid`, `PaymentTransaction_ID`) VALUES
('Yes', 1);

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
(1, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(2, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(3, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(4, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(5, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(6, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-20', 'Commenced', 'Copy', 1, 6, 120),
(7, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(8, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(9, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(10, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(11, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(12, 'Black and white film processing', '00:00', 'Development area', 49.5, '60', 0, '2021-12-20', 'Commenced', 'Development', 1, 5, 60),
(13, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 30),
(14, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 30),
(15, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 30),
(16, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 30),
(17, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-20', 'Commenced', 'Packer', 1, 7, 30),
(18, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(19, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(20, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(21, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(22, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(23, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(24, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(25, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(26, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(27, 'Use of large copy camera', '00:00', 'Copy Room', 19, '120', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 120),
(28, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(29, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(30, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(31, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(32, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(33, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(34, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(35, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(36, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(37, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(38, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(39, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(40, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(41, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(42, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(43, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(44, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(45, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(46, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(47, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2021-12-23', 'Commenced', 'Packer', 2, 7, 30),
(48, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(49, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(50, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(51, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(52, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(53, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(54, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(55, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(56, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(57, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(58, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(59, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(60, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(61, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(62, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(63, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(64, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(65, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(66, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(67, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-23', 'Commenced', 'Development', 2, 5, 90),
(68, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(69, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(70, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(71, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(72, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(73, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(74, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(75, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(76, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(77, 'Use of small copy camera', '00:00', 'Copy Room ', 8.3, '75', 0, '2021-12-23', 'Commenced', 'Copy', 2, 6, 75),
(78, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 180),
(79, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 180),
(80, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2021-12-23', 'Commenced', 'Development', 3, 5, 180),
(81, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 45),
(82, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 45),
(83, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2021-12-23', 'Commenced', 'Finish', 3, 8, 45),
(84, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(85, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(86, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(87, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(88, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(89, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(90, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(91, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(92, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(93, 'Bag up', '00:00', 'Packing Departments', 6, '30 ', 0, '2021-12-28', 'Commenced', 'Packer', 4, 7, 30),
(94, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(95, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(96, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(97, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(98, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(99, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(100, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(101, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(102, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(103, 'Black and white film processing ', '00:00', 'Development area', 49.5, '60', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 60),
(104, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(105, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(106, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(107, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(108, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(109, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(110, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(111, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(112, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(113, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(114, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(115, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(116, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(117, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(118, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(119, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(120, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(121, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(122, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(123, 'Colour film processing', '00:00', 'Development Area', 80, '90', 0, '2021-12-28', 'Commenced', 'Development', 4, 5, 90),
(124, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-10', 'Commenced', 'Development', 5, 5, 180),
(125, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-10', 'Commenced', 'Development', 5, 5, 180),
(126, 'Colour Transparency processing', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-10', 'Commenced', 'Development', 5, 5, 180),
(127, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2022-01-10', 'Commenced', 'Finish', 5, 8, 45),
(128, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2022-01-10', 'Commenced', 'Finish', 5, 8, 45),
(129, 'Mount Transparencies', '00:00', 'Finishing Room', 55.5, '45', 0, '2022-01-10', 'Commenced', 'Finish', 5, 8, 45),
(130, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2022-01-25', 'Commenced', 'Packer', 6, 7, 30),
(131, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2022-01-25', 'Commenced', 'Packer', 6, 7, 30),
(132, 'Bag up', '00:00', 'Packing Departments ', 6, '30', 0, '2022-01-25', 'Commenced', 'Packer', 6, 7, 30),
(133, 'Colour Transparency processing ', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-25', 'Commenced', 'Development', 6, 5, 180),
(134, 'Colour Transparency processing ', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-25', 'Commenced', 'Development', 6, 5, 180),
(135, 'Colour Transparency processing ', '00:00', 'Development Area', 110.3, '180', 0, '2022-01-25', 'Commenced', 'Development', 6, 5, 180),
(136, 'Mount Transparencies ', '00:00', 'Finishing Room', 55.5, '45 ', 0, '2022-01-25', 'Commenced', 'Finish', 6, 8, 45),
(137, 'Mount Transparencies ', '00:00', 'Finishing Room', 55.5, '45 ', 0, '2022-01-25', 'Commenced', 'Finish', 6, 8, 45),
(138, 'Mount Transparencies ', '00:00', 'Finishing Room', 55.5, '45 ', 0, '2022-01-25', 'Commenced', 'Finish', 6, 8, 45),
(139, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(140, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(141, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(142, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(143, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(144, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(145, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(146, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(147, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(148, 'Use of small copy camera', '00:00', 'Copy Room', 8.3, '75 ', 0, '2022-02-01', 'Commenced', 'Copy', 7, 6, 75),
(149, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(150, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(151, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(152, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(153, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(154, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(155, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(156, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(157, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(158, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(159, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(160, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(161, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(162, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(163, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(164, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(165, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(166, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(167, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(168, 'Bag up', '00:00', 'Packing Departments ', 6, '30 ', 0, '2022-02-01', 'Commenced', 'Packer', 7, 7, 30),
(169, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(170, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(171, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(172, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(173, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(174, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(175, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(176, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(177, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(178, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(179, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(180, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(181, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(182, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(183, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(184, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(185, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(186, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(187, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90),
(188, 'Colour film processing ', '00:00', 'Development Area', 80, '90 ', 0, '2022-02-01', 'Commenced', 'Development', 7, 5, 90);

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
  MODIFY `Account_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `discount`
--
ALTER TABLE `discount`
  MODIFY `Discount_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `Job_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `jobs_task`
--
ALTER TABLE `jobs_task`
  MODIFY `Jobs_Task_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `Staff_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `Task_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=189;

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
