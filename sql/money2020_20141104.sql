CREATE DATABASE  IF NOT EXISTS `money2020` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `money2020`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: money2020.cpcyccyao7ql.us-west-2.rds.amazonaws.com    Database: money2020
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `LOCATION`
--

DROP TABLE IF EXISTS `LOCATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOCATION` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `modo_location_id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOCATION`
--

LOCK TABLES `LOCATION` WRITE;
/*!40000 ALTER TABLE `LOCATION` DISABLE KEYS */;
INSERT INTO `LOCATION` VALUES (10001,'Gucci Las Vegas','920e8565acf649aea98dc1ea848d60ca','2014-11-01 14:25:45','2014-11-01 14:25:45',36.107159,-115.17369),(10002,'StarBucks','c63a2e02403b4118a46cd4ee7d4f70b4','2014-11-01 14:25:45','2014-11-01 14:25:45',36.107159,-115.17369);
/*!40000 ALTER TABLE `LOCATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MERCHANT`
--

DROP TABLE IF EXISTS `MERCHANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MERCHANT` (
  `merchant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `modo_merchant_id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MERCHANT`
--

LOCK TABLES `MERCHANT` WRITE;
/*!40000 ALTER TABLE `MERCHANT` DISABLE KEYS */;
INSERT INTO `MERCHANT` VALUES (10001,'Gucci','3da28d76b4af44a293baea703644643b','2014-11-01 12:00:00','2014-11-01 12:00:00'),(10002,'Starbucks','cf631f5973974aafb62c0b39bde2d859','2014-11-01 12:00:00','2014-11-01 12:00:00');
/*!40000 ALTER TABLE `MERCHANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MERCHANT_LOCATION`
--

DROP TABLE IF EXISTS `MERCHANT_LOCATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MERCHANT_LOCATION` (
  `merchant_location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `merchant_id` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`merchant_location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MERCHANT_LOCATION`
--

LOCK TABLES `MERCHANT_LOCATION` WRITE;
/*!40000 ALTER TABLE `MERCHANT_LOCATION` DISABLE KEYS */;
INSERT INTO `MERCHANT_LOCATION` VALUES (1,'2014-11-02 12:21:48','10001','10001','2014-11-02 12:21:48'),(2,'2014-11-02 12:21:48','10002','10002','2014-11-02 12:21:48');
/*!40000 ALTER TABLE `MERCHANT_LOCATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRANSACTION`
--

DROP TABLE IF EXISTS `TRANSACTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRANSACTION` (
  `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_account_id` bigint(20) NOT NULL,
  `description` longtext NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `merchant_name` varchar(255) NOT NULL,
  `transaction_type` varchar(255) NOT NULL,
  `transaction_amount` double DEFAULT NULL,
  `intuit_transaction_id` varchar(255) NOT NULL,
  `merchant_sum` int(20) DEFAULT NULL,
  `merchant_count` int(20) DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRANSACTION`
--

LOCK TABLES `TRANSACTION` WRITE;
/*!40000 ALTER TABLE `TRANSACTION` DISABLE KEYS */;
INSERT INTO `TRANSACTION` VALUES (1,3333,'Shirt','Clothing','JC Penney','debit',50,'10000',NULL,NULL,'2014-10-01',0,'2014-10-01 12:00:00','2014-10-01 12:00:00'),(2,1111,'Mocha','Restaurants','Starbucks','debit',5,'10001',NULL,NULL,'2014-10-01',0,'2014-10-01 12:00:00','2014-10-01 12:00:00'),(3,2222,'Paycheck','Paycheck','Work','credit',5000,'10002',NULL,NULL,'2014-10-02',0,'2014-10-02 12:00:00','2014-10-02 12:00:00'),(4,1111,'Mocha','Restaurants','Starbucks','credit',5,'10003',NULL,NULL,'2014-10-03',0,'2014-10-03 12:00:00','2014-10-03 12:00:00'),(5,3333,'Tissues','Personal Care','Walgreens','debit',20,'10004',NULL,NULL,'2014-10-04',0,'2014-10-04 12:00:00','2014-10-04 12:00:00'),(6,1111,'Latte','Restaurants','Starbucks','debit',10,'10005',NULL,NULL,'2014-10-05',0,'2014-10-05 12:00:00','2014-10-05 12:00:00'),(7,2222,'Latte','Restaurants','Starbucks','debit',5,'10006',NULL,NULL,'2014-10-06',0,'2014-10-06 12:00:00','2014-10-06 12:00:00'),(8,1111,'Boots','Clothing','Nordstrom','debit',180,'10007',NULL,NULL,'2014-10-07',0,'2014-10-07 12:00:00','2014-10-07 12:00:00'),(9,1111,'Paycheck','Paycheck','Work','credit',5000,'10008',NULL,NULL,'2014-10-08',0,'2014-10-08 12:00:00','2014-10-08 12:00:00'),(10,1111,'Mocha','Restaurants','Starbucks','debit',5,'10009',NULL,NULL,'2014-10-09',0,'2014-10-09 12:00:00','2014-10-09 12:00:00'),(11,2222,'Latte','Restaurants','Starbucks','debit',15,'10011',NULL,NULL,'2014-10-11',0,'2014-10-11 12:00:00','2014-10-11 12:00:00'),(12,1111,'Jacket','Clothing','J Crew','debit',200,'10012',NULL,NULL,'2014-10-12',0,'2014-10-12 12:00:00','2014-10-12 12:00:00'),(13,1111,'Dress','Clothing','Gucci','debit',1000,'10013',NULL,NULL,'2014-10-13',0,'2014-10-13 12:00:00','2014-10-13 12:00:00'),(14,1111,'Ski Gear','Hobbies','REI','debit',200,'10014',NULL,NULL,'2014-10-14',0,'2014-10-14 12:00:00','2014-10-14 12:00:00'),(15,3333,'Mocha','Restaurants','Starbucks','debit',20,'10015',NULL,NULL,'2014-10-15',0,'2014-10-15 12:00:00','2014-10-15 12:00:00'),(16,1111,'Groceries','Groceries','Whole Foods','debit',75,'10016',NULL,NULL,'2014-10-16',0,'2014-10-16 12:00:00','2014-10-16 12:00:00'),(17,1111,'Suit','Clothing','Gucci','debit',1500,'10017',NULL,NULL,'2014-10-17',1,'2014-10-17 12:00:00','2014-10-17 12:00:00'),(18,2222,'Groceries','Groceries','Trader Joes','debit',100,'10018',NULL,NULL,'2014-10-18',0,'2014-10-18 12:00:00','2014-10-18 12:00:00'),(19,1111,'Haircut','Personal Care','Super Cuts','debit',20,'10019',NULL,NULL,'2014-10-19',0,'2014-10-19 12:00:00','2014-10-19 12:00:00'),(20,3333,'Mocha','Restaurants','Starbucks','debit',5,'10020',NULL,NULL,'2014-10-20',1,'2014-10-20 12:00:00','2014-10-20 12:00:00'),(21,3334,'Shirt','Clothing','JC Penney','debit',50,'10000',NULL,NULL,'2014-10-01',0,'2014-10-01 12:00:00','2014-10-01 12:00:00'),(22,1112,'Mocha','Restaurants','Starbucks','debit',5,'10001',NULL,NULL,'2014-10-01',0,'2014-10-01 12:00:00','2014-10-01 12:00:00'),(23,2223,'Paycheck','Paycheck','Work','credit',5000,'10002',NULL,NULL,'2014-10-02',0,'2014-10-02 12:00:00','2014-10-02 12:00:00'),(24,1112,'Mocha','Restaurants','Starbucks','credit',5,'10003',NULL,NULL,'2014-10-03',0,'2014-10-03 12:00:00','2014-10-03 12:00:00'),(25,3334,'Tissues','Personal Care','Walgreens','debit',20,'10004',NULL,NULL,'2014-10-04',0,'2014-10-04 12:00:00','2014-10-04 12:00:00'),(26,1112,'Latte','Restaurants','Starbucks','debit',10,'10005',NULL,NULL,'2014-10-05',0,'2014-10-05 12:00:00','2014-10-05 12:00:00'),(27,2223,'Latte','Restaurants','Starbucks','debit',5,'10006',NULL,NULL,'2014-10-06',0,'2014-10-06 12:00:00','2014-10-06 12:00:00'),(28,1112,'Boots','Clothing','Nordstrom','debit',180,'10007',NULL,NULL,'2014-10-07',0,'2014-10-07 12:00:00','2014-10-07 12:00:00'),(29,1112,'Paycheck','Paycheck','Work','credit',5000,'10008',NULL,NULL,'2014-10-08',0,'2014-10-08 12:00:00','2014-10-08 12:00:00'),(30,1112,'Mocha','Restaurants','Starbucks','debit',5,'10009',NULL,NULL,'2014-10-09',0,'2014-10-09 12:00:00','2014-10-09 12:00:00'),(31,2223,'Latte','Restaurants','Starbucks','debit',15,'10011',NULL,NULL,'2014-10-11',0,'2014-10-11 12:00:00','2014-10-11 12:00:00'),(32,1112,'Jacket','Clothing','J Crew','debit',200,'10012',NULL,NULL,'2014-10-12',0,'2014-10-12 12:00:00','2014-10-12 12:00:00'),(33,1112,'Dress','Clothing','Gucci','debit',1000,'10013',NULL,NULL,'2014-10-13',0,'2014-10-13 12:00:00','2014-10-13 12:00:00'),(34,1112,'Ski Gear','Hobbies','REI','debit',200,'10014',NULL,NULL,'2014-10-14',0,'2014-10-14 12:00:00','2014-10-14 12:00:00'),(35,3334,'Mocha','Restaurants','Starbucks','debit',20,'10015',NULL,NULL,'2014-10-15',0,'2014-10-15 12:00:00','2014-10-15 12:00:00'),(36,1112,'Groceries','Groceries','Whole Foods','debit',75,'10016',NULL,NULL,'2014-10-16',0,'2014-10-16 12:00:00','2014-10-16 12:00:00'),(37,1112,'Suit','Clothing','Gucci','debit',1500,'10017',NULL,NULL,'2014-10-17',1,'2014-10-17 12:00:00','2014-10-17 12:00:00'),(38,2223,'Groceries','Groceries','Trader Joes','debit',100,'10018',NULL,NULL,'2014-10-18',0,'2014-10-18 12:00:00','2014-10-18 12:00:00'),(39,1112,'Haircut','Personal Care','Super Cuts','debit',20,'10019',NULL,NULL,'2014-10-19',0,'2014-10-19 12:00:00','2014-10-19 12:00:00'),(40,3334,'Mocha','Restaurants','Starbucks','debit',5,'10020',NULL,NULL,'2014-10-20',1,'2014-10-20 12:00:00','2014-10-20 12:00:00');
/*!40000 ALTER TABLE `TRANSACTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `modo_account_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_guid` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (28,'2014-11-01 12:00:00','0e0bb6d41ccd4cd5af5a3660253e704c','password','9169415753','2014-11-01 14:25:45','10001','user1@personalcapital.com'),(29,'2014-11-01 12:00:00','7a6c21e1ba98413f97c50346e78ac6e9','password','9167104941','2014-11-01 14:25:45','10002','user2@personalcapital.com'),(30,'2014-11-01 12:00:00','790a9bba600440fb9953698a60b35477','password','9167102748','2014-11-01 14:25:45','10003','user3@personalcapital.com'),(31,'2014-11-01 12:00:00','3ba1a3cfd8af49d28cb7fd1bad68f141','password','4154206686','2014-11-01 14:25:45','10004','user4@personalcapital.com'),(32,'2014-11-01 12:00:00','6dd61e0a87e44f10aa470a16825077b4','password','5086379553','2014-11-01 14:25:45','10005','user5@personalcapital.com');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ACCOUNT`
--

DROP TABLE IF EXISTS `USER_ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ACCOUNT` (
  `user_account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `firm_name` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `intuit_account_id` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3335 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ACCOUNT`
--

LOCK TABLES `USER_ACCOUNT` WRITE;
/*!40000 ALTER TABLE `USER_ACCOUNT` DISABLE KEYS */;
INSERT INTO `USER_ACCOUNT` VALUES (1111,28,'Account 001','Bank of America',10000,'10101','2014-11-01 14:25:45','2014-11-01 14:25:45',NULL),(1112,29,'Account 001','Bank of America',10000,'10104','2014-11-01 14:25:45','2014-11-01 14:25:45',NULL),(2222,28,'Account 002','Chase',5000,'10102','2014-11-01 14:25:45','2014-11-01 14:25:45',NULL),(2223,29,'Account 002','Chase',5000,'10105','2014-11-01 14:25:45','2014-11-01 14:25:45',NULL),(3333,28,'Account 003','Wells Fargo',15000,'10103','2014-11-01 14:25:45','2014-11-01 14:25:45',NULL),(3334,29,'Account 003','Wells Fargo',15000,'10106','2014-11-01 14:25:45',NULL,NULL);
/*!40000 ALTER TABLE `USER_ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_PERK`
--

DROP TABLE IF EXISTS `USER_PERK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_PERK` (
  `user_perk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modo_perk_id` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `merchant_id` varchar(255) NOT NULL,
  `location_id` varchar(255) NOT NULL,
  `perk_status` varchar(255) NOT NULL,
  `latitude` varchar(1000) DEFAULT NULL,
  `longitude` varchar(1000) DEFAULT NULL,
  `redemption_details` longtext,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_perk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_PERK`
--

LOCK TABLES `USER_PERK` WRITE;
/*!40000 ALTER TABLE `USER_PERK` DISABLE KEYS */;
INSERT INTO `USER_PERK` VALUES (152,'2e5e4567a18646249bfdd35a2275e4b3',28,'3da28d76b4af44a293baea703644643b','0','ACTIVE',NULL,NULL,'{\"amount\":\"10.0\",\"description\":\"$10 off any purchase\",\"dateGiven\":\"2014-11-02\",\"dateExpiry\":\"2014-11-03\"}','2014-11-04 22:31:12','2014-11-04 22:31:12',NULL),(153,'cb1014c66c8249288209046f3d11817b',29,'8161fa6cd0c24c6ab9606252713ab571','0','ACTIVE',NULL,NULL,'{\"amount\":\"0.0\",\"description\":\"5% Off Your Purchase\",\"dateGiven\":\"2014-11-02\",\"dateExpiry\":\"2014-11-03\",\"modoCheckoutCode\":\"0572182361\",\"barCode\":\"iVBORw0KGgoAAAANSUhEUgAAAQ4AAACrCAIAAAAYdeUbAAAATHRFWHRDb3B5cmlnaHQAR2VuZXJhdGVkIHdpdGggQmFyY29kZSBHZW5lcmF0b3IgZm9yIFBIUCBodHRwOi8vd3d3LmJhcmNvZGVwaHAuY29tWX9wuAAAA6RJREFUeJzt3cFu2zoQQNHnh/7/L6e7bFywdyglMd1zlq1sqUYvuBiQenx8fPwH/M3/P/0AcAapQCIVSKQCiVQgkQokUoFEKpBIBRKpQCIVSKQCiVQgkQokUoFEKpBIBZJfz3/0eDxu+erP/ZWfXzj6k70H27vF6JtHD/Z1/+SyffWuB7v4GKMHK/Z+w9H/hOe/sqpAIhVIpAKJVCCRCiRSgUQqkEgFkj+MIP9Bo1HUyGh4N5oY7s00F/e6OCm+fUz5aqwqkEgFEqlAIhVIpAKJVCCRCiRSgeTsEWTZpvfs4p7HPRennHsb957vPpoqft32zBNZVSCRCiRSgUQqkEgFEqlAIhVIpALJ2SPIi1v5Rt882mx4+73KxeUWF3+WcvHeE74+qwokUoFEKpBIBRKpQCIVSKQCiVQgOXsEORqo7Z2tenGgtndKarnX3usUb59FLp7nPSaPn6wqkEgFEqlAIhVIpAKJVCCRCiRSgeTsEeTtuyDLYaTl5NLna8o8bu9c2T17P9TFt1UezaoCiVQgkQokUoFEKpBIBRKpQCIVSM4eQY72GJZtehdfEzl60+LFWyxuuvjCiz/Uj7xG80VYVSCRCiRSgUQqkEgFEqlAIhVIpALJ2SPI0asSF9O3vcNIRw+2sPcyx71rFp8aXTOa3r7HUNKqAolUIJEKJFKBRCqQSAUSqUAiFUiOHEGOpoqj8eLtb358/ua9edzim8tZr7fPavc+fjSrCiRSgUQqkEgFEqlAIhVIpAKJVCA5cgRZLF5NuLjmoov7EC8e1rr3ksrRg41GvW/GqgKJVCCRCiRSgUQqkEgFEqlAIhVIjhxB3vXKxU9fd7ppeT/j4lOjE1BHuyAXHx9NbxcXv9ks0qoCiVQgkQokUoFEKpBIBRKpQCIVSI4cQY6MzhdduP1Ni3t7Fe86AXV0VOxouLk3JH19VhVIpAKJVCCRCiRSgUQqkEgFEqlAcuQIcm/oVj51cUY22r1YlKNQ9x7srk2doyHp0awqkEgFEqlAIhVIpAKJVCCRCiRSgeTIEWTZwfcNL0Ys1ywetdg7W7VcXH6x0X7G99jquGBVgUQqkEgFEqlAIhVIpAKJVCCRCiRHjiDvshgUlovvOpF1ca/yPeVf8Q07QBdPePstfoRVBRKpQCIVSKQCiVQgkQokUoFEKpA8jp4KwbexqkAiFUikAolUIJEKJFKBRCqQSAUSqUAiFUikAolUIJEKJFKBRCqQSAUSqUDyG9IrKXa/mS4UAAAAAElFTkSuQmCC\"}','2014-11-02 18:08:47','2014-11-02 18:08:47',NULL),(154,'52653de2f4be45d59fdd982bfb13c00a',29,'8161fa6cd0c24c6ab9606252713ab571','0','ACTIVE',NULL,NULL,'{\"amount\":\"2.0\",\"description\":\"$2 Off Any Drink\",\"dateGiven\":\"2014-11-02\",\"dateExpiry\":\"2014-11-03\",\"modoCheckoutCode\":\"0507735952\",\"barCode\":\"iVBORw0KGgoAAAANSUhEUgAAAQ4AAACrCAIAAAAYdeUbAAAATHRFWHRDb3B5cmlnaHQAR2VuZXJhdGVkIHdpdGggQmFyY29kZSBHZW5lcmF0b3IgZm9yIFBIUCBodHRwOi8vd3d3LmJhcmNvZGVwaHAuY29tWX9wuAAAA7BJREFUeJzt3cFy0zAUQFHC8P+/XHbdhBH3yU6LwjnL0thqhjtavJH9+Pj4+AH8zc/vXgCcQSqQSAUSqUAiFUikAolUIJEKJFKBRCqQSAUSqUAiFUikAolUIJEKJFKB5Nfzjx6Pxy2X/jxf+XnB0U/2FrZ3i9GVRwt73Z9cjq/etbCLyxgtrNj7Dkf/E57/ya4CiVQgkQokUoFEKpBIBRKpQCIVSP4wgvwPjUZRI6Ph3WhiuDfTXNzr4qT49jHlv8auAolUIJEKJFKBRCqQSAUSqUAiFUjOHkGWY3rPLp55vKgMChcDx8XvLOxNFV93PPNEdhVIpAKJVCCRCiRSgUQqkEgFEqlAcvYI8uJRvtGVRzO78vHF75QLLj717K6vpfxy+btOZFeBRCqQSAUSqUAiFUikAolUIJEKJGePIEcDtb1nq44GaqPDmBefZbo3lLx9FrlYz3tMHj/ZVSCRCiRSgUQqkEgFEqlAIhVIpALJ2SPI209BloeR7p2CXFxw8TujI5Mje1/UxbdVHs2uAolUIJEKJFKBRCqQSAUSqUAiFUjOHkGWh6N+KlO8i6+J3Ht86+I6ixXuDVIvflHf+xrN72VXgUQqkEgFEqlAIhVIpAKJVCCRCiRnjyDLMb0yfdt7GOlIeU3kxcOPe2u++GbMcp33GEraVSCRCiRSgUQqkEgFEqlAIhVIpALJkSPI0VRxNF583QsN954HO3oUarn74id73+ro40ezq0AiFUikAolUIJEKJFKBRCqQSAWSI0eQxehE4e1nHhfrKXdfnIu8+PDYi8+DHY1634xdBRKpQCIVSKQCiVQgkQokUoFEKpAcOYJcnCjcm3+Vp5vuXbkcflxMSxezv8XHF8soKxxNb8vi34NdBRKpQCIVSKQCiVQgkQokUoFEKpAcOYIcuesg4WiyVqZ4oyuPXmRZLB7NujiwWa5z1wr/NXYVSKQCiVQgkQokUoFEKpBIBRKpQHLkCHLv8GP51OtmZHcdonz+p9HdL84ryzf2uvdpfi+7CiRSgUQqkEgFEqlAIhVIpAKJVCA5cgRZTvCVqdnFFyM+2zstODqDubjXaF5ZvrG9W7zHwPGZXQUSqUAiFUikAolUIJEKJFKBRCqQHDmCvMtoCHjXA10XV36+zmiF5RZfcAJ0sdSjp5N2FUikAolUIJEKJFKBRCqQSAUSqUDyOHoqBF/GrgKJVCCRCiRSgUQqkEgFEqlAIhVIpAKJVCCRCiRSgUQqkEgFEqlAIhVIpALJb5dHJpFz4LNLAAAAAElFTkSuQmCC\"}','2014-11-02 18:08:47','2014-11-02 18:08:47',NULL),(155,'226b49dae0544a79a7b92e105e4a8169',29,'3da28d76b4af44a293baea703644643b','0','ACTIVE',NULL,NULL,'{\"amount\":\"10.0\",\"description\":\"$10 off any purchase\",\"dateGiven\":\"2014-11-02\",\"dateExpiry\":\"2014-11-03\",\"modoCheckoutCode\":\"0672694935\",\"barCode\":\"iVBORw0KGgoAAAANSUhEUgAAAQ4AAACrCAIAAAAYdeUbAAAATHRFWHRDb3B5cmlnaHQAR2VuZXJhdGVkIHdpdGggQmFyY29kZSBHZW5lcmF0b3IgZm9yIFBIUCBodHRwOi8vd3d3LmJhcmNvZGVwaHAuY29tWX9wuAAAA51JREFUeJzt3cFu2zAUAMG66P//cnrLxQW7j5Kb0J05JoosG1nw8EDz8fHx8QP4m59f/QBwBqlAIhVIpAKJVCCRCiRSgUQqkEgFEqlAIhVIpAKJVCCRCiRSgUQqkEgFkl/PP3o8Hrfc+nN/5ecNRz/Ze7C9lxjdefRgr3vLZfvqXQ928TFGD1bsfYaj/4TnX1lVIJEKJFKBRCqQSAUSqUAiFUikAskfRpD/odEoamQ0vBtNDPdmmovXujgpvn1M+d1YVSCRCiRSgUQqkEgFEqlAIhVIpALJ2SPIsk3v2cU9j3vPU361uGbxV4ufLF69TBVftz3zRFYVSKQCiVQgkQokUoFEKpBIBRKpQHL2CPLiVr7Rnfe+xrPcp4wXn19ib3/lxY+lXDx6OwexqkAiFUikAolUIJEKJFKBRCqQSAWSs0eQo4Ha3ner7g3U9l59b2fi3vev3jWLfL7z4pqjWVUgkQokUoFEKpBIBRKpQCIVSKQCydkjyNt3QV4c+d118bPRzs3XzSIvnlZ5NKsKJFKBRCqQSAUSqUAiFUikAolUIDl7BFm2DX4q2/QuHhO5dwRk+WbX8uoLd31QrztG8/uzqkAiFUikAolUIJEKJFKBRCqQSAWSs0eQZZveXWc4FmX6NtpjuPedsRe/abZcM5revsdQ0qoCiVQgkQokUoFEKpBIBRKpQCIVSI4cQY6miqPx4tceaDjamThy+6x278+PZlWBRCqQSAUSqUAiFUikAolUIJEKJEeOIIvF0YSLay4anfw4GomWL3Rd2JsPPl88GvW+GasKJFKBRCqQSAUSqUAiFUikAolUIDlyBLkYzF08KrG8VrnP6MzEvUMhR0ZTztH0dnHxm80irSqQSAUSqUAiFUikAolUIJEKJFKB5MgR5MhdA74yWRtNHkd3XtznriMgR1s4F/e56w1+N1YVSKQCiVQgkQokUoFEKpBIBRKpQHLkCHJv+lb+6vYZWRl37j387e99YfSJfe15mq9jVYFEKpBIBRKpQCIVSKQCiVQgkQokR44gyw6+MjW7eDDinr1NgqODLMtYsHxio0d9j62OC1YVSKQCiVQgkQokUoFEKpBIBRKpQHLkCPIue0c3llnbaD54cRdk8S93gC4e7OjppFUFEqlAIhVIpAKJVCCRCiRSgUQqkDyOngrBP2NVgUQqkEgFEqlAIhVIpAKJVCCRCiRSgUQqkEgFEqlAIhVIpAKJVCCRCiRSgeQ3CDM4c8lc640AAAAASUVORK5CYII=\"}','2014-11-02 18:08:47','2014-11-02 18:08:47',NULL),(157,'958a3277588147da96ddfc9874b51982',28,'cf631f5973974aafb62c0b39bde2d859','0','ACTIVE',NULL,NULL,'{\"amount\":\"5.0\",\"description\":\"$5 Off Any Purchase\",\"dateGiven\":\"2014-11-02\",\"dateExpiry\":\"2014-11-03\"}','2014-11-04 22:31:12','2014-11-04 22:31:12',NULL);
/*!40000 ALTER TABLE `USER_PERK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meta`
--

DROP TABLE IF EXISTS `meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meta` (
  `meta_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`meta_id`),
  UNIQUE KEY `meta_uidx1` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meta`
--

LOCK TABLES `meta` WRITE;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-04 17:13:37
