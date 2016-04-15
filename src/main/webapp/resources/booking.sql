CREATE DATABASE  IF NOT EXISTS `booking` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `booking`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: booking
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `concert`
--

DROP TABLE IF EXISTS `concert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `introduction` text COLLATE utf8_bin,
  `stadium_id` int(11) DEFAULT NULL,
  `open_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `total_seat` int(11) DEFAULT NULL,
  `sold_seat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CONCERT_STADIUM_idx` (`stadium_id`),
  CONSTRAINT `FK_CONCERT_STADIUM` FOREIGN KEY (`stadium_id`) REFERENCES `stadium` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `concert_area`
--

DROP TABLE IF EXISTS `concert_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concert_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `concert_id` int(11) DEFAULT NULL,
  `area` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `total_seat` int(11) DEFAULT NULL,
  `sold_seat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_AREA_CONCERT_idx` (`concert_id`),
  CONSTRAINT `FK_AREA_CONCERT` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `final_price` double DEFAULT NULL,
  `original_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_ODER_idx` (`order_id`),
  KEY `FK_DETAIL_TICKET_idx` (`ticket_id`),
  CONSTRAINT `FK_DETAIL_ORDER` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_DETAIL_TICKET` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `concert_id` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0-booked, 1-paid, 2-expired',
  `create_time` timestamp NULL DEFAULT NULL,
  `paid_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ORDER_INFO_USER_idx` (`user_id`),
  KEY `FK_ORDER_INFO_CONCERT_idx` (`concert_id`),
  CONSTRAINT `FK_ORDER_INFO_CONCERT` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_ORDER_INFO_USER` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stadium`
--

DROP TABLE IF EXISTS `stadium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stadium` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `total_seat` int(11) DEFAULT NULL,
  `introduction` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `x_value` int(11) DEFAULT NULL,
  `y_value` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0-available, 1-sold, 2-locked',
  PRIMARY KEY (`id`),
  KEY `FK_TICKET_AREA_idx` (`area_id`),
  CONSTRAINT `FK_TICKET_AREA` FOREIGN KEY (`area_id`) REFERENCES `concert_area` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `role` int(11) DEFAULT '0' COMMENT '0-normal user\n1-admin user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-13 22:29:55
