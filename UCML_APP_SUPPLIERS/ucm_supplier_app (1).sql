-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2019 at 11:06 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ucm_supplier_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
`CAR_ID` int(11) NOT NULL,
  `CAR_ENGINE` varchar(30) DEFAULT NULL,
  `CAR_TRANS` varchar(30) NOT NULL,
  `CAR_COLOR` varchar(30) DEFAULT NULL,
  `CAR_PRICE` int(11) NOT NULL,
  `CAR_DESC` text,
  `CAR_STATUS` tinyint(1) NOT NULL,
  `CAR_MAKEID` int(11) NOT NULL,
  `CAR_MODELID` int(11) NOT NULL,
  `CAR_SUPID` int(11) NOT NULL,
  `CAR_DEALID` int(11) DEFAULT NULL,
  `CAR_YEAR` int(11) NOT NULL,
  `CAR_MILEAGE` int(15) NOT NULL,
  `CAR_BODY_TYPE` varchar(40) DEFAULT NULL,
  `CAR_DATE` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`CAR_ID`, `CAR_ENGINE`, `CAR_TRANS`, `CAR_COLOR`, `CAR_PRICE`, `CAR_DESC`, `CAR_STATUS`, `CAR_MAKEID`, `CAR_MODELID`, `CAR_SUPID`, `CAR_DEALID`, `CAR_YEAR`, `CAR_MILEAGE`, `CAR_BODY_TYPE`, `CAR_DATE`) VALUES
(1, '1.2', 'Automatic', 'white', 30000, 'excellent condition', 1, 1, 8, 1, 1, 2016, 120000, 'suv', '2019-06-14 00:00:00'),
(2, '1.6', 'Manual', 'white', 120000, 'excellent condition', 1, 3, 344, 1, 1, 2016, 30000, 'Bakkie', '2019-06-15 13:21:40'),
(3, '2.0', 'Manual', 'Black', 120000, 'excellent condition', 1, 1, 10, 5, 1, 2016, 30000, 'Sedane', '2019-06-15 22:19:20'),
(4, '1.4', 'Manual', 'silver', 30000, 'excellent condition', 1, 8, 333, 7, 1, 2016, 30000, 'Sedane', '2019-06-17 10:59:37'),
(6, '1.4', 'Automatic', 'black', 101000, 'testing ', 1, 5, 230, 5, 1, 2009, 101000, 'Bakkie', '2019-06-17 21:44:34'),
(7, '2.0', 'Automatic', 'white', 49000, 'good deal, testing', 1, 1, 186, 7, 1, 2019, 49000, 'SUV', '2019-06-17 21:46:47'),
(8, '1.3', 'Manual', 'silver', 42000, 'not too clean No finance, no service book', 1, 7, 358, 9, 1, 2004, 144000, 'Hatchback', '2019-06-26 15:25:30'),
(9, '1.5', 'Automatic', 'silver', 225000, 'Finance available, service book and sport version. Accident free', 1, 6, 173, 10, 1, 2018, 9000, 'Hatchback', '2019-06-26 15:27:02'),
(10, '1.6', 'Manual', 'white', 100000, 'Finance available, service book and sport version. Accident free', 1, 11, 272, 11, 1, 2018, 42000, 'Bakkie', '2019-06-26 15:28:24'),
(11, '1.2', 'Manual', 'Red', 60000, 'Finance available.', 1, 6, 167, 12, 1, 2014, 90000, 'Hatchback', '2019-06-26 15:29:54'),
(12, '1.2', 'Manual', 'Red', 77000, 'no comment', 1, 7, 5, 14, 1, 2013, 64000, 'Hatchback', '2019-06-26 15:35:04'),
(13, '1.1', 'Manual', 'Black', 33000, 'Not clean, poor body work on this car.', 1, 7, 355, 15, 1, 2007, 83000, 'Hatchback', '2019-06-26 15:36:51'),
(14, '1.6', 'Manual', 'white', 65000, 'No comment', 1, 11, 272, 16, 1, 2012, 35000, 'Bakkie', '2019-06-26 15:47:02'),
(15, '1.2', 'Automatic', 'Silver', 140000, 'Clean. Finance Available', 1, 14, 19, 11, 1, 2014, 2000, 'SUV', '2019-06-26 15:55:34'),
(16, '1.4', 'Manual', 'Red', 85000, 'Clean. Finance Available', 1, 3, 344, 8, 1, 2016, 35000, 'Bakkie', '2019-06-26 15:57:41'),
(17, '1.6', 'Manual', 'white', 75000, 'Code2', 1, 8, 328, 20, 1, 2011, 105000, 'Sedane', '2019-06-26 16:02:34'),
(18, '320i M-sport', 'Automatic', 'Blue', 270000, 'Code2', 1, 2, 208, 19, 1, 2016, 35000, 'Sedane', '2019-06-26 16:04:04'),
(19, '1.6', 'Manual', 'gold', 90000, 'Code 2, no finance', 1, 11, 280, 8, 1, 2009, 98000, 'SUV', '2019-06-26 16:06:37'),
(20, '1.2', 'Manual', 'white', 65000, 'expensive. ', 1, 3, 352, 18, 1, 2011, 118000, 'Hatchback', '2019-06-26 16:08:10'),
(21, '1.4 Trendline', 'Manual', 'silver', 80000, 'Clean, code 2', 1, 16, 16, 21, 1, 2012, 65000, 'Hatchback', '2019-06-26 16:42:50'),
(22, '1.4 confortline', 'Manual', 'white', 80000, 'Clean, code 2', 1, 16, 16, 22, 1, 2017, 37000, 'Hatchback', '2019-06-26 16:44:13'),
(23, '1.2 GL', 'Automatic', 'silver', 75000, 'Clean, code 3', 1, 14, 19, 23, 1, 2014, 58000, 'Hatchback', '2019-06-26 16:45:40'),
(24, '3.0 Raider', 'Automatic', 'white', 190000, '4X4 Double Cab with canopy. Leather interior', 1, 15, 65, 1, 1, 2010, 135000, 'Bakkie', '2019-06-26 16:48:17'),
(25, '22', 'Manual', 'beige', 160000, '4X4 Double Cab with canopy. Leather interior', 1, 5, 248, 24, 1, 2012, 92000, 'Bakkie', '2019-06-26 16:49:36'),
(26, 'VI 1.2 TSI ConfortLine', 'Manual', 'white', 135000, 'No Coment', 1, 16, 47, 25, 1, 2015, 90000, 'Sedane', '2019-06-26 17:02:48'),
(27, '1.4', 'Manual', 'Silver', 75000, 'No Coment', 1, 7, 5, 26, 1, 2013, 84000, 'Hatchback', '2019-06-26 17:04:34'),
(28, '2.0 tfsi', 'Manual', 'white', 75000, 'Code 2, Clean', 1, 1, 11, 8, 1, 2008, 87000, 'Sedane', '2019-06-26 17:05:59'),
(29, '1.2', 'Manual', 'white', 20000, 'good', 1, 5, 230, 1, 1, 2001, 10000, 'Hatchback', '2019-06-27 08:55:50'),
(30, '2.0', 'null', 'white', 50000, 'goo', 1, 1, 9, 1, 1, 2001, 30000, 'Hatchback', '2019-06-27 08:59:38'),
(31, '2.0', 'Automatic', 'white', 50000, 'Accident free ', 1, 17, 27, 28, 1, 2006, 180000, 'Hatchback', '2019-07-02 15:53:29'),
(32, '1.4', 'Manual', 'white', 115000, 'code 2', 1, 16, 16, 29, 1, 2017, 24000, 'Hatchback', '2019-07-02 16:05:43'),
(33, '1.2', 'Manual', 'white', 70000, 'code can be financed', 1, 3, 352, 30, 1, 2016, 75000, 'Hatchback', '2019-07-02 16:09:29'),
(34, '1.6 Prestige', 'Manual', 'grey', 145000, 'code 2', 1, 15, 60, 31, 1, 2014, 90000, 'Sedane', '2019-07-02 16:11:44'),
(35, '1.1', 'Manual', 'white', 70000, 'code 2', 1, 7, 4, 14, 1, 2016, 41000, 'Hatchback', '2019-07-02 16:13:22'),
(36, '2.0 Active', 'Automatic', 'maroon', 200000, 'code 2', 1, 9, 139, 30, 1, 2016, 58000, 'SUV', '2019-07-02 16:16:33'),
(37, '1.5 SX Sport', 'Manual', 'Blue', 74000, 'code 2', 1, 15, 2, 5, 1, 2014, 74000, 'Hatchback', '2019-07-02 16:19:41'),
(38, '2.0 Executive', 'Manual', 'white', 140000, 'Code 2', 1, 7, 369, 32, 1, 2011, 77000, 'SUV', '2019-07-02 16:24:40'),
(39, '2.0', 'Manual', 'white', 120000, 'Code 2. ', 1, 11, 273, 20, 1, 2016, 100000, 'Bakkie', '2019-07-02 16:29:47'),
(40, '1.4 Trendline', 'Manual', 'Red', 85000, 'code 2, spare key service book', 1, 16, 16, 29, 1, 2014, 79000, 'Hatchback', '2019-07-02 16:34:37'),
(41, '1.6 s/c', 'Manual', 'white', 85000, 'code 2, ', 1, 3, 344, 33, 1, 2016, 89000, 'Bakkie', '2019-07-02 16:38:33'),
(42, '1.2', 'Manual', 'Blue', 120000, 'code 2', 1, 8, 333, 34, 1, 2016, 53000, 'Hatchback', '2019-07-02 16:44:33'),
(43, '2.2', 'Manual', 'white', 230000, 'Code 2, Single Cab', 1, 5, 248, 30, 1, 2018, 55000, 'Bakkie', '2019-07-02 16:51:07');

-- --------------------------------------------------------

--
-- Table structure for table `dealerships`
--

CREATE TABLE IF NOT EXISTS `dealerships` (
`DEAL_ID` int(11) NOT NULL,
  `DEAL_NAME` varchar(60) NOT NULL,
  `DEAL_EMAIL` varchar(60) NOT NULL,
  `DEAL_PASSWORD` varchar(255) NOT NULL,
  `DEAL_ADDRESS` varchar(255) NOT NULL,
  `DEAL_NUM` varchar(30) NOT NULL,
  `DEAL_STATUS` varchar(40) DEFAULT NULL,
  `DEAL_OWNER` varchar(45) NOT NULL,
  `DEAL_OWNER_NUM` varchar(30) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dealerships`
--

INSERT INTO `dealerships` (`DEAL_ID`, `DEAL_NAME`, `DEAL_EMAIL`, `DEAL_PASSWORD`, `DEAL_ADDRESS`, `DEAL_NUM`, `DEAL_STATUS`, `DEAL_OWNER`, `DEAL_OWNER_NUM`, `Date`) VALUES
(1, 'isdynamic', 'shineparkmotors@gmail.com', '0000', '131 Marshall street', '0785332923', 'admin', 'kenzo', '0656528813', '2019-07-01'),
(2, 'IS DYNAMIC AUTO', 'isdynamic@gmail.com', '12345', '131 Marshall Street', '0785332923', 'true', 'Sam/Innocent', '0783767923', '2019-07-01'),
(3, 'C E AUTO', 'ce&auto@gmail.com', 'admin', 'place our address here', 'xxx-xxx-xxxx', 'admin', 'owner_name', 'xxx-xxx-xxxx', '2019-06-19'),
(4, 'OWINU AUTO', 'email@gmail.com', 'admin', 'address', '0656528813', 'admin', 'owner_name', '0656528813', '2019-06-19'),
(5, 'dealer', 'dealer@gmail.com', '12345', 'address here', 'xxx-xxx-xxxx', 'admin', 'owner''s name', 'xxx-xxx-xxxx', '2019-06-27'),
(6, 'dealer1', 'dealer1@gmail.com', '12345', 'address', 'xxx-xxx-xxxx', 'admin', 'owner''s name', 'xxx-xxx-xxxx', '2019-06-27');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
`IMG_ID` int(11) NOT NULL,
  `IMG_CARID` int(11) NOT NULL,
  `IMG_IMAGE` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `make`
--

CREATE TABLE IF NOT EXISTS `make` (
`makeId` int(11) NOT NULL,
  `make` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `make`
--

INSERT INTO `make` (`makeId`, `make`) VALUES
(1, 'Audi'),
(2, 'BMW'),
(3, 'Chevrolet'),
(4, 'Daihtsu'),
(5, 'Ford'),
(6, 'Honda'),
(7, 'Hyundai'),
(8, 'Kia'),
(9, 'Mazda'),
(10, 'MINI'),
(11, 'Nissan'),
(12, 'Opel'),
(13, 'Renault'),
(14, 'Suzuki'),
(15, 'Toyota'),
(16, 'Volkswagen'),
(17, 'Volvo'),
(18, 'Dodge'),
(20, 'ISUZU'),
(21, 'JEEP'),
(22, 'Mercedez-benz'),
(23, 'Porche'),
(24, 'TATA'),
(25, 'Sebaru'),
(26, 'SsongYong'),
(27, 'Soyat'),
(28, 'Smart'),
(29, 'Saab'),
(30, 'SEAT'),
(31, 'Rolls-royce'),
(32, 'Proton'),
(33, 'Peugeot'),
(34, 'Mitsubishi'),
(35, 'Mclaren'),
(36, 'Maserati'),
(37, 'Mahindra'),
(38, 'MG'),
(39, 'Lotus'),
(40, 'Lexus'),
(41, 'Land Rover'),
(42, 'Lamborghini'),
(43, 'Lada'),
(44, 'Jinbei'),
(45, 'JMC'),
(46, 'IVECO'),
(47, 'Infinity'),
(48, 'Hummer'),
(49, 'Hino'),
(50, 'Gonow');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE IF NOT EXISTS `model` (
`modelId` int(11) NOT NULL,
  `makeId` int(11) DEFAULT NULL,
  `model` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`modelId`, `makeId`, `model`) VALUES
(1, 15, 'Auris'),
(2, 15, 'Etios'),
(3, 7, 'Elantra'),
(4, 7, 'i10'),
(5, 7, 'i20'),
(6, 7, 'i30'),
(7, 7, 'Accent'),
(8, 1, 'A1'),
(9, 1, 'A2'),
(10, 1, 'A3'),
(11, 1, 'A4'),
(12, 1, 'A5'),
(13, 1, 'A6'),
(14, 1, 'A7'),
(15, 16, 'Polo'),
(16, 16, 'Polo Vivo'),
(17, 6, 'Honda'),
(18, 8, 'Picanto'),
(19, 14, 'Swift'),
(20, 13, 'Sandero'),
(21, 13, 'Clio'),
(22, 18, 'Caliber'),
(24, 17, 'C30'),
(25, 17, 'C70'),
(26, 17, 'S40'),
(27, 17, 'S60'),
(28, 17, 'S80'),
(29, 17, 'S90'),
(30, 17, 'V40'),
(31, 17, 'V50'),
(32, 17, 'V60'),
(33, 17, 'V70'),
(34, 17, 'XC60'),
(35, 17, 'XC70'),
(36, 17, 'XC90'),
(37, 16, 'Amarok'),
(38, 16, 'Beetle'),
(39, 16, 'CC'),
(40, 16, 'CITI'),
(41, 16, 'Caddy'),
(42, 16, 'Caravelle'),
(43, 16, 'Caddy'),
(44, 16, 'Crafter'),
(45, 16, 'Eos'),
(46, 16, 'Golf'),
(47, 16, 'Jetta'),
(48, 16, 'Passat'),
(49, 16, 'Touareg'),
(50, 16, 'Tiguan'),
(51, 16, 'Touran'),
(52, 16, 'Transporter'),
(53, 15, 'Avanza'),
(55, 15, 'Avensis'),
(56, 15, 'Aygo'),
(57, 15, 'Camry'),
(58, 15, 'Condor'),
(59, 15, 'Conquest'),
(60, 15, 'Corolla'),
(61, 15, 'Cressida'),
(62, 15, 'Dyna'),
(63, 15, 'Fortuner'),
(64, 15, 'Hi-ace'),
(65, 15, 'Hilux'),
(66, 15, 'Innova'),
(67, 15, 'Land Cruiser'),
(68, 15, 'Mr2'),
(69, 15, 'Prado'),
(70, 15, 'Prius'),
(71, 15, 'Quantum'),
(72, 15, 'RAV 4'),
(73, 15, 'RunX'),
(74, 15, 'Stallion'),
(75, 15, 'Tazz'),
(76, 15, 'Venture'),
(77, 15, 'Verso'),
(78, 15, 'Yaris'),
(79, 24, '207'),
(80, 24, 'Bolt'),
(81, 24, 'Indica'),
(82, 24, 'Indigo'),
(83, 24, 'Safari'),
(84, 24, 'Super Ace'),
(85, 24, 'Telc oline'),
(86, 24, 'Xenon'),
(87, 14, 'Alto'),
(88, 14, 'Baleno'),
(89, 14, 'Celerio'),
(90, 14, 'Ciaz'),
(91, 14, 'Ertiga'),
(92, 14, 'Grand Vitara'),
(93, 14, 'Ignis'),
(94, 14, 'Jinny'),
(95, 14, 'Kizashi'),
(96, 14, 'SX4'),
(97, 14, 'SJ'),
(98, 14, 'Splash'),
(99, 14, 'Super Carry'),
(100, 14, 'Swift'),
(101, 14, 'Vitara'),
(102, 23, '911'),
(103, 23, '944'),
(104, 23, 'Boxster'),
(105, 23, 'Cayenne'),
(106, 23, 'Macan'),
(108, 22, 'A-Class'),
(109, 22, 'AMG GT'),
(110, 22, 'B-Class'),
(111, 22, 'C-Class'),
(112, 22, 'CL-Class'),
(113, 22, 'CLK-Class'),
(114, 22, 'CLS-Class'),
(115, 22, 'Commercial'),
(116, 22, 'E 350'),
(117, 22, 'E-Class'),
(118, 22, 'G-Class'),
(119, 22, 'GL-Class'),
(120, 22, 'GLA-Class'),
(121, 22, 'GLC'),
(122, 22, 'GLE-Class'),
(123, 22, 'GLS-Class'),
(124, 22, 'M-Class'),
(125, 22, 'R-Class'),
(126, 22, 'S-Class'),
(127, 22, 'SL-Class'),
(128, 22, 'SLC-Class'),
(129, 22, 'SLK-Class'),
(130, 22, 'SLS-Class'),
(131, 35, 'MP4-12c'),
(132, 9, '2'),
(133, 9, '3'),
(134, 9, '5'),
(135, 9, '6'),
(136, 9, '121'),
(137, 9, '323'),
(138, 9, '626'),
(139, 9, 'CX-3'),
(140, 9, 'CX-5'),
(141, 9, 'Drifter'),
(142, 9, 'Etude'),
(143, 9, 'MX-5'),
(144, 9, 'MX-6'),
(145, 9, 'RX-8'),
(146, 10, 'Cooper'),
(147, 10, 'Cooper S'),
(148, 10, 'One'),
(149, 45, 'Boarding'),
(150, 45, 'Carrying'),
(151, 45, 'LondWind'),
(152, 45, 'Vigus'),
(153, 46, 'Daily'),
(154, 20, 'KB Series'),
(155, 20, 'F8000'),
(156, 20, 'FRR'),
(157, 20, 'Frontier'),
(159, 20, 'NPR'),
(160, 20, 'NPS 300'),
(161, 20, 'NQR'),
(162, 48, 'H2'),
(163, 48, 'H3'),
(164, 6, 'Honda Accord'),
(165, 6, 'BR-V'),
(166, 6, 'Ballade'),
(167, 6, 'Brio'),
(168, 6, 'CR-Z'),
(169, 6, 'Civic'),
(170, 6, 'FR-V'),
(171, 6, 'HR-V'),
(172, 6, 'Insight'),
(173, 6, 'Jazz'),
(174, 6, 'Molilio'),
(175, 6, 'S2000'),
(176, 49, '300'),
(177, 49, '500'),
(178, 50, 'X Space'),
(179, 1, '500'),
(181, 1, 'Q2'),
(182, 1, 'Q3'),
(183, 1, 'Q4'),
(184, 1, 'Q5'),
(186, 1, 'Q6'),
(187, 1, 'Q7'),
(188, 1, 'R8'),
(189, 1, 'RS7'),
(190, 1, 'RS Q3'),
(191, 1, 'RS3'),
(192, 1, 'RS4'),
(193, 1, 'RS6'),
(195, 1, 'S1'),
(196, 1, 'S3'),
(197, 1, 'S4'),
(198, 1, 'S5'),
(199, 1, 'S6'),
(200, 1, 'S7'),
(201, 1, 'S8'),
(202, 1, 'SQ5'),
(203, 1, 'TT'),
(205, 1, 'TTS'),
(206, 2, '1 Series'),
(207, 2, '2 Series'),
(208, 2, '3 Series'),
(209, 2, '4 Series'),
(210, 2, '5 Series'),
(211, 2, '8 Series'),
(212, 2, 'M Coupe'),
(213, 2, 'M1'),
(214, 2, 'M2'),
(215, 2, 'M3'),
(216, 2, 'M4'),
(217, 2, 'M5'),
(218, 2, 'M6'),
(219, 2, 'X1'),
(220, 2, 'X2'),
(221, 2, 'X3'),
(222, 2, 'X4'),
(223, 2, 'X5'),
(224, 2, 'X6'),
(225, 2, 'Z3'),
(226, 2, 'Z4'),
(227, 2, 'I3'),
(228, 2, 'I8'),
(229, 5, 'B-Max'),
(230, 5, 'BANTAM'),
(231, 5, 'Cortina'),
(232, 5, 'Courier'),
(233, 5, 'Ecosport'),
(234, 5, 'Everest'),
(235, 5, 'F-Series'),
(236, 5, 'Fairmont'),
(237, 5, 'Falcon'),
(238, 5, 'Fiesta'),
(239, 5, 'Figo'),
(240, 5, 'Focus'),
(241, 5, 'Fusion'),
(242, 5, 'Ikon'),
(243, 5, 'Ka'),
(244, 5, 'Kuga'),
(245, 5, 'Laser'),
(246, 5, 'Mustang'),
(247, 5, 'Rachero'),
(248, 5, 'Ranger'),
(249, 5, 'Testar'),
(250, 5, 'Territory'),
(251, 5, 'Tourneo'),
(252, 5, 'Transit'),
(253, 18, 'Journey'),
(254, 18, 'Nitro'),
(255, 18, 'Ram'),
(256, 11, '1400 Bakkie'),
(257, 11, '350z'),
(258, 11, '370z'),
(259, 11, 'Almera'),
(260, 11, 'Cabster'),
(261, 11, 'GT-R'),
(262, 11, 'Grand Livina'),
(263, 11, 'Hardbody'),
(264, 11, 'Interstar'),
(265, 11, 'Juke'),
(266, 11, 'Leaf'),
(267, 11, 'Langley'),
(268, 11, 'Livina'),
(269, 11, 'Maxima'),
(270, 11, 'Micra'),
(271, 11, 'Murano'),
(272, 11, 'Np200'),
(273, 11, 'Np300'),
(274, 11, 'Nv200'),
(275, 11, 'Nv350'),
(276, 11, 'Navara'),
(277, 11, 'Pathfinder'),
(278, 11, 'Patrol'),
(279, 11, 'Primaster'),
(280, 11, 'Qashqai'),
(281, 11, 'Sabre'),
(282, 11, 'Sani'),
(283, 11, 'Santra'),
(284, 11, 'Skyline'),
(285, 11, 'Tida'),
(286, 11, 'Ud'),
(287, 11, 'X-trail'),
(288, 12, 'Adam'),
(289, 12, 'Astra'),
(290, 12, 'Combo'),
(291, 12, 'Corsa'),
(292, 12, 'Corsa Utility'),
(293, 12, 'Kadett'),
(294, 12, 'Meriva'),
(295, 12, 'Mokka'),
(296, 12, 'Monza'),
(297, 12, 'Movano'),
(298, 12, 'Omega'),
(299, 12, 'Tigra'),
(300, 12, 'Vivaro'),
(301, 12, 'Zafira'),
(302, 11, '1Tonner'),
(303, 13, 'Captur'),
(304, 13, 'Duster'),
(305, 13, 'Espace'),
(306, 13, 'Fluence'),
(307, 13, 'Grand Scenic'),
(308, 13, 'Kadjar'),
(309, 13, 'Kangoo'),
(310, 13, 'Koleos'),
(311, 13, 'Kwid'),
(312, 13, 'Laguna'),
(313, 13, 'Logan'),
(314, 13, 'Megan'),
(315, 13, 'Modus'),
(316, 13, 'Scenic'),
(317, 13, 'Trafic'),
(318, 13, 'Twingo'),
(319, 4, 'Charade'),
(320, 4, 'Copen'),
(321, 4, 'Gran Max'),
(322, 4, 'Materia'),
(323, 4, 'Sirion'),
(324, 4, 'Terios'),
(325, 4, 'Yrv'),
(326, 8, 'Carens'),
(327, 8, 'Carnival'),
(328, 8, 'Cerato'),
(329, 8, 'K 2500'),
(330, 8, 'K 2700'),
(331, 8, 'Optima'),
(332, 8, 'Proceed'),
(333, 8, 'Rio'),
(334, 8, 'Sedona'),
(335, 8, 'Shuma'),
(336, 8, 'Soreto'),
(337, 8, 'Soul'),
(338, 8, 'Sportage'),
(339, 3, 'Aveo'),
(340, 3, 'Blazer'),
(341, 3, 'Camaro'),
(342, 3, 'Captiva'),
(343, 3, 'Chevair'),
(344, 3, 'Corsa Utility'),
(345, 3, 'Corvette'),
(346, 3, 'Cruze'),
(347, 3, 'Fleetline'),
(348, 3, 'Lumina'),
(349, 3, 'Optra'),
(350, 3, 'Orlando'),
(351, 3, 'Sonic'),
(352, 3, 'Spark'),
(353, 3, 'Trailblazer'),
(354, 3, 'Vivant'),
(355, 7, 'Atos'),
(356, 7, 'Azera'),
(357, 7, 'Creta'),
(358, 7, 'Getz'),
(359, 7, 'H1'),
(360, 7, 'H100 Bakkie'),
(361, 7, 'Matrix'),
(362, 7, 'Mighty'),
(363, 7, 'Santa Fe'),
(364, 7, 'Sonata'),
(365, 7, 'Terracan'),
(366, 7, 'Tiburon'),
(367, 7, 'Tucson'),
(368, 7, 'Veloster'),
(369, 7, 'IX35'),
(370, 2, '6 series');

-- --------------------------------------------------------

--
-- Table structure for table `model1`
--

CREATE TABLE IF NOT EXISTS `model1` (
`modelId` int(15) NOT NULL,
  `makeId` int(15) NOT NULL,
  `model` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
`SUP_ID` int(11) NOT NULL,
  `SUP_NAME` varchar(40) NOT NULL,
  `SUP_NUM` varchar(40) NOT NULL,
  `SUP_NUM1` varchar(40) NOT NULL,
  `DEAL_ID` int(11) DEFAULT NULL,
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SUP_ID`, `SUP_NAME`, `SUP_NUM`, `SUP_NUM1`, `DEAL_ID`, `Date`) VALUES
(1, 'Ernest', '079653663', '065635352', 1, '2019-06-14 00:00:00'),
(2, 'jeff', '0785332923', '0656528813', NULL, '2019-06-15 10:13:37'),
(3, 'PrinceWill', '0656528823', '0785332821', 1, '2019-06-15 10:17:48'),
(4, 'Walters', '0783009060', '0783009060', 1, '2019-06-15 22:15:16'),
(5, 'Sam', '0730024190', '0730024190', 1, '2019-06-15 22:16:30'),
(6, 'Innocent', '0833676029', '0833676029', 1, '2019-06-15 22:17:45'),
(7, 'Felix', '0846152632', '0846252632', 1, '2019-06-17 10:55:37'),
(8, 'Asobo', '0813029302', '0813029382', 1, '2019-06-17 11:01:19'),
(9, 'Getz Supplier', '0739666417', '0739666417', 1, '2019-06-26 15:20:31'),
(10, 'Bruno', '0746519727', '0746519727', 1, '2019-06-26 15:21:22'),
(11, 'Charles', '0837660518', '0837660518', 1, '2019-06-26 15:22:04'),
(12, 'gbenga', '0629337423', '0629337423', 1, '2019-06-26 15:23:38'),
(13, 'Afix', '0739594232', '0739594232', 1, '2019-06-26 15:31:16'),
(14, 'Mr CC', '0717929222', '0717929222', 1, '2019-06-26 15:31:55'),
(15, 'Mr John', '0717254426', '0717254426', 1, '2019-06-26 15:32:42'),
(16, 'Kingsley', '0843003656', '0843003656', 1, '2019-06-26 15:38:21'),
(17, 'Charles', '0837660518', '0837660518', 1, '2019-06-26 15:39:42'),
(18, 'Clement', '0729940044', '0729940044', 1, '2019-06-26 15:59:17'),
(19, 'Killian', '0731941699', '0731941699', 1, '2019-06-26 15:59:51'),
(20, 'Mr VJ', '0836736758', '0836736758', 1, '2019-06-26 16:01:05'),
(21, 'Joel', '0781331308', '0781331308', 1, '2019-06-26 16:36:49'),
(22, 'Steve', '0734453553', '0734453553', 1, '2019-06-26 16:38:15'),
(23, 'Mr Peter', '0836941026', '0836941026', 1, '2019-06-26 16:39:41'),
(24, 'Eze', '0844863214', '0844863214', 1, '2019-06-26 16:40:51'),
(25, 'Romeo', '0627220232', '0627220232', 1, '2019-06-26 16:59:35'),
(26, 'Eric', '0737082661', '0737082661', 1, '2019-06-26 17:00:11'),
(27, 'reo', '0656528813', '0656528813', 1, '2019-06-27 08:50:02'),
(28, 'Dumi', '0822571777', '0822571777', 1, '2019-07-02 15:51:40'),
(29, 'Mr Ola', '0610695384', '0610695384', 1, '2019-07-02 16:03:04'),
(30, 'Chidi', '0787042847', '0787042847', 1, '2019-07-02 16:06:27'),
(31, 'Jeff', '0783529345', '0783529345', 1, '2019-07-02 16:10:07'),
(32, 'Monday', '0833538699', '0833538699', 1, '2019-07-02 16:22:31'),
(33, 'Joe', '0734535116', '0734535116', 1, '2019-07-02 16:36:24'),
(34, 'Obi', '0742347115', '0742347115', 1, '2019-07-02 16:42:32'),
(35, 'Kingsley', '0739467088', '0739467088', 1, '2019-07-02 16:47:33');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
 ADD PRIMARY KEY (`CAR_ID`), ADD UNIQUE KEY `CAR_ID` (`CAR_ID`), ADD KEY `CAR_MAKEID` (`CAR_MAKEID`), ADD KEY `CAR_MODELID` (`CAR_MODELID`), ADD KEY `CAR_SUPID` (`CAR_SUPID`), ADD KEY `CAR_DEALID` (`CAR_DEALID`);

--
-- Indexes for table `dealerships`
--
ALTER TABLE `dealerships`
 ADD PRIMARY KEY (`DEAL_ID`), ADD UNIQUE KEY `DEAL_ID` (`DEAL_ID`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
 ADD PRIMARY KEY (`IMG_ID`), ADD UNIQUE KEY `IMG_ID` (`IMG_ID`), ADD KEY `IMG_CARID` (`IMG_CARID`);

--
-- Indexes for table `make`
--
ALTER TABLE `make`
 ADD PRIMARY KEY (`makeId`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
 ADD PRIMARY KEY (`modelId`), ADD UNIQUE KEY `modelId` (`modelId`), ADD KEY `makeId_7` (`makeId`);

--
-- Indexes for table `model1`
--
ALTER TABLE `model1`
 ADD PRIMARY KEY (`modelId`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
 ADD PRIMARY KEY (`SUP_ID`), ADD UNIQUE KEY `SUP_ID` (`SUP_ID`), ADD KEY `DEAL_ID` (`DEAL_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
MODIFY `CAR_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `dealerships`
--
ALTER TABLE `dealerships`
MODIFY `DEAL_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
MODIFY `IMG_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `make`
--
ALTER TABLE `make`
MODIFY `makeId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
MODIFY `modelId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=371;
--
-- AUTO_INCREMENT for table `model1`
--
ALTER TABLE `model1`
MODIFY `modelId` int(15) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
MODIFY `SUP_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`CAR_MAKEID`) REFERENCES `make` (`makeId`),
ADD CONSTRAINT `car_ibfk_2` FOREIGN KEY (`CAR_MODELID`) REFERENCES `model` (`modelId`),
ADD CONSTRAINT `car_ibfk_3` FOREIGN KEY (`CAR_SUPID`) REFERENCES `supplier` (`SUP_ID`),
ADD CONSTRAINT `car_ibfk_4` FOREIGN KEY (`CAR_DEALID`) REFERENCES `dealerships` (`DEAL_ID`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`IMG_CARID`) REFERENCES `car` (`CAR_ID`);

--
-- Constraints for table `model`
--
ALTER TABLE `model`
ADD CONSTRAINT `model_ibfk_1` FOREIGN KEY (`makeId`) REFERENCES `make` (`makeId`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
ADD CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`DEAL_ID`) REFERENCES `dealerships` (`DEAL_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
