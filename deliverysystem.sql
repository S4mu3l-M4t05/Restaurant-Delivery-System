-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 09, 2024 at 03:33 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `deliverysystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` enum('Active','Inactive') NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `username`, `password`, `status`) VALUES
(1, 'admin1', 'password1', 'Active'),
(2, 'admin2', 'password2', 'Inactive');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `address` text,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `account_status` enum('Active','Closed') NOT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `username`, `password`, `last_name`, `first_name`, `address`, `email`, `phone_number`, `account_status`, `postal_code`) VALUES
(1, 'client1', 'password1', 'Doe', 'John', '122 street', 'ex@ex.ca', '1234567890', 'Active', 'Q1Q'),
(2, 'client2', 'password2', 'Doe', 'Jane', '122 street', '123@456.789', '1234567890', 'Closed', 'Q1Q'),
(4, 'client3', '12345678', 'asdasd', 'dasdas', 'asdasdas', 'example@example.com', '123456789', 'Active', 'Q1Q'),
(5, 'client50', '87654321', 'qwerty', 'ytrewq', 'sdasdasd', 'ex@ex.com', '1112223333', 'Active', NULL),
(6, 'qweqwe', '12345678', '54654', '565', 'rfgregfreg', 'qwert@qwert.ca', '4444444445', 'Active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `deliverymen`
--

DROP TABLE IF EXISTS `deliverymen`;
CREATE TABLE IF NOT EXISTS `deliverymen` (
  `deliveryman_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `delivery_area` varchar(255) NOT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`deliveryman_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliverymen`
--

INSERT INTO `deliverymen` (`deliveryman_id`, `username`, `password`, `name`, `phone_number`, `delivery_area`, `status`) VALUES
(1, 'delivery1', 'password1', 'new Name', '(111)-222-3333', 'H3H', 1),
(2, 'delivery2', 'password2', 'Jane Smith', '444-555-6666', 'R2Q', 1),
(3, 'amirmalo', 'amirmalo', 'amir', '(438)-540-1381', 'K5J', 1),
(4, 'maloamri', 'amiramir', 'malo', '(545)-645-6465', 'Test Area', 1),
(5, 'usertest', 'amiramir', 'test1', '(438)-540-1384', 'Test Area , Area b , Area C', 1),
(6, 'userFLOCK', 'testtest', 'test', '(488)-888-8888', 'H3h, h1h, hh', 1),
(7, 'thisismyname', 'awswaws', 'NAN', '(222)-222-2222', '1d2', 1),
(8, 'usertest55', 'password', 'test name', '(855)-555-5555', 'h3h, 1h4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
CREATE TABLE IF NOT EXISTS `managers` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `username` (`username`),
  KEY `restaurant_id` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`manager_id`, `username`, `password`, `restaurant_id`, `status`) VALUES
(2, 'manager2', 'password2', 11, 1),
(4, 'AmirsManager', 'passwordM', 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
CREATE TABLE IF NOT EXISTS `menus` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) NOT NULL,
  `item` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `restaurant_id` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`menu_id`, `restaurant_id`, `item`, `price`) VALUES
(14, 15, 'sushi', '25.00'),
(13, 15, 'pasta', '20.00'),
(10, 11, 'ret', '45.00');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  `status` enum('Pending','Accepted','Ready','En Route','Delivered') NOT NULL,
  `deliveryman_id` int(11) DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `order_detail` text,
  `delivery_address` varchar(255) DEFAULT NULL,
  `delivery_postal_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `client_id` (`client_id`),
  KEY `restaurant_id` (`restaurant_id`),
  KEY `deliveryman_id` (`deliveryman_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `client_id`, `restaurant_id`, `status`, `deliveryman_id`, `delivery_time`, `order_detail`, `delivery_address`, `delivery_postal_code`) VALUES
(11, 4, 11, 'Delivered', 3, '2024-04-09 13:15:00', 'ret - Quantity: 2 - Total: $90.00', 'montreal', 'K5J'),
(9, 1, 15, 'Delivered', 1, '2024-04-09 12:30:00', 'pizza - Quantity: 2 - Total: $50.00', 'MONTREAL', 'H3H');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
CREATE TABLE IF NOT EXISTS `restaurants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone_number` varchar(10) NOT NULL,
  `OpenHourSun` varchar(2) NOT NULL,
  `OpenMinSun` varchar(2) NOT NULL,
  `CloseHourSun` varchar(2) NOT NULL,
  `CloseMinSun` varchar(2) NOT NULL,
  `OpenHourMon` varchar(2) NOT NULL,
  `OpenMinMon` varchar(2) NOT NULL,
  `CloseHourMon` varchar(2) NOT NULL,
  `CloseMinMon` varchar(2) NOT NULL,
  `OpenHourTues` varchar(2) NOT NULL,
  `OpenMinTues` varchar(2) NOT NULL,
  `CloseHourTues` varchar(2) NOT NULL,
  `CloseMinTues` varchar(2) NOT NULL,
  `OpenHourWed` varchar(2) NOT NULL,
  `OpenMinWed` varchar(2) NOT NULL,
  `CloseHourWed` varchar(2) NOT NULL,
  `CloseMinWed` varchar(2) NOT NULL,
  `OpenHourThurs` varchar(2) NOT NULL,
  `OpenMinThurs` varchar(2) NOT NULL,
  `CloseHourThurs` varchar(2) NOT NULL,
  `CloseMinThurs` varchar(2) NOT NULL,
  `OpenHourFri` varchar(2) NOT NULL,
  `OpenMinFri` varchar(2) NOT NULL,
  `CloseHourFri` varchar(2) NOT NULL,
  `CloseMinFri` varchar(2) NOT NULL,
  `OpenHourSat` varchar(2) NOT NULL,
  `OpenMinSat` varchar(2) NOT NULL,
  `CloseHourSat` varchar(2) NOT NULL,
  `CloseMinSat` varchar(2) NOT NULL,
  `delivery_area` text NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `address` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`, `address`, `phone_number`, `OpenHourSun`, `OpenMinSun`, `CloseHourSun`, `CloseMinSun`, `OpenHourMon`, `OpenMinMon`, `CloseHourMon`, `CloseMinMon`, `OpenHourTues`, `OpenMinTues`, `CloseHourTues`, `CloseMinTues`, `OpenHourWed`, `OpenMinWed`, `CloseHourWed`, `CloseMinWed`, `OpenHourThurs`, `OpenMinThurs`, `CloseHourThurs`, `CloseMinThurs`, `OpenHourFri`, `OpenMinFri`, `CloseHourFri`, `CloseMinFri`, `OpenHourSat`, `OpenMinSat`, `CloseHourSat`, `CloseMinSat`, `delivery_area`, `status`, `manager_id`) VALUES
(11, 'Noah', 'dasss', '5146610469', '08', '00', '08', '00', '08', '08', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', '08', '00', 'J5F, K7K', 0, 1),
(15, 'AmirsRestu', 'montreal', '6666666666', '15', '30', '21', '30', '10', '10', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', '10', '30', 'J5F, K7K', 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `restaurateur`
--

DROP TABLE IF EXISTS `restaurateur`;
CREATE TABLE IF NOT EXISTS `restaurateur` (
  `restaurateur_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`restaurateur_id`),
  KEY `restaurant_id` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `restaurateur`
--

INSERT INTO `restaurateur` (`restaurateur_id`, `restaurant_id`, `username`, `password`) VALUES
(1, 11, 'restu', 'password'),
(3, 15, 'AmirR', 'passwordR');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
