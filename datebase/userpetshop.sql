/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : userpetshop

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-09-25 19:11:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DealType` int(11) DEFAULT NULL,
  `PetID` int(11) DEFAULT NULL,
  `SellerID` int(11) DEFAULT NULL,
  `BuyerID` int(11) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `DealTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PetID` (`PetID`)
) ENGINE=InnoDB AUTO_INCREMENT=3061 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('3032', '1', '1008', '2001', '2', '30', '2019-07-04');
INSERT INTO `accounts` VALUES ('3033', '1', '1007', '2001', '2', '80', '2019-07-04');
INSERT INTO `accounts` VALUES ('3058', '2', '1008', '2', '0', '30', '2019-07-04');
INSERT INTO `accounts` VALUES ('3059', '2', '1040', '2', '0', '40', '2019-07-05');
INSERT INTO `accounts` VALUES ('3060', '1', '1002', '2001', '2', '20', '2019-07-05');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Health` int(11) DEFAULT NULL,
  `Love` int(11) DEFAULT NULL,
  `Birthday` varchar(255) DEFAULT NULL,
  `OwnerID` int(11) DEFAULT NULL,
  `StoreID` int(11) DEFAULT NULL,
  `money` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `OwnerID` (`OwnerID`),
  KEY `StoreID` (`StoreID`),
  CONSTRAINT `StoreID` FOREIGN KEY (`StoreID`) REFERENCES `petstore` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1091 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES ('1001', 'lyl', 'dog', '5', '70', '2018.07.07', '2001', '2', '20');
INSERT INTO `pet` VALUES ('1002', 'lily', 'cat', '4', '87', '2019.01.28', '0', '2', '20');
INSERT INTO `pet` VALUES ('1003', 'baby', 'pig', '5', '30', '2019.02.15', '2001', '2', '50');
INSERT INTO `pet` VALUES ('1004', 'sara', 'fish', '3', '45', '2019.04.02', null, '2', '30');
INSERT INTO `pet` VALUES ('1007', 'dxx', 'pig', '3', '55', '2018.09.21', null, '2', '80');
INSERT INTO `pet` VALUES ('1008', 'lkt', 'pig', '3', '34', '2018.11.11', '2001', '2', '30');
INSERT INTO `pet` VALUES ('1040', 'tom', 'cat', '3', '87', '2012.05.30', '2001', '2', '40');
INSERT INTO `pet` VALUES ('1060', 'jerry', 'mouse', '3', '34', '2018.08.07', null, '2', '20');
INSERT INTO `pet` VALUES ('1090', 'lkt', 'pig', '3', '45', '1998.08.08', '0', '2', '25');

-- ----------------------------
-- Table structure for petowner
-- ----------------------------
DROP TABLE IF EXISTS `petowner`;
CREATE TABLE `petowner` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `money` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2003 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of petowner
-- ----------------------------
INSERT INTO `petowner` VALUES ('2001', 'zst', '1111', '450');
INSERT INTO `petowner` VALUES ('2002', 'tom', '1111', '100');

-- ----------------------------
-- Table structure for petstore
-- ----------------------------
DROP TABLE IF EXISTS `petstore`;
CREATE TABLE `petstore` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of petstore
-- ----------------------------
INSERT INTO `petstore` VALUES ('2', 'happy', '1234', '515');
INSERT INTO `petstore` VALUES ('5', 'baobao', '1234', '105');
