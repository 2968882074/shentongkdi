/*
SQLyog Ultimate v8.32 
MySQL - 5.1.32-community : Database - shentong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shentong` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shentong`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `phoneSpecial` varchar(11) DEFAULT NULL,
  `level` varchar(100) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `address` */

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) DEFAULT NULL,
  `adminpass` varchar(20) DEFAULT NULL,
  `compellation` varchar(10) DEFAULT NULL,
  `adminimg` varchar(500) DEFAULT NULL,
  `Groupid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `adminrole` */

DROP TABLE IF EXISTS `adminrole`;

CREATE TABLE `adminrole` (
  `adminrole` int(11) NOT NULL AUTO_INCREMENT,
  `Adminid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`adminrole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `adminrole` */

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `brid` int(11) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(20) DEFAULT NULL,
  `brName` varchar(20) DEFAULT NULL,
  `brpone` varchar(11) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `business` varchar(255) DEFAULT NULL,
  `branchType` varchar(255) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `unusualPone` varchar(255) DEFAULT NULL,
  `nextNumber` varchar(255) DEFAULT NULL,
  `subordinate` varchar(255) DEFAULT NULL,
  `brNumberPone` varchar(255) DEFAULT NULL,
  `workAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

/*Table structure for table `charge` */

DROP TABLE IF EXISTS `charge`;

CREATE TABLE `charge` (
  `chid` int(11) NOT NULL AUTO_INCREMENT,
  `chargeName` varchar(100) DEFAULT NULL,
  `weight` tinyint(1) DEFAULT NULL,
  `distanc` varchar(100) DEFAULT NULL,
  `operationStaff` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `chargeTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`chid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `charge` */

/*Table structure for table `chauffeur` */

DROP TABLE IF EXISTS `chauffeur`;

CREATE TABLE `chauffeur` (
  `chauffeurid` int(11) DEFAULT NULL,
  `chauffeurname` varchar(20) DEFAULT NULL,
  `chauffeurage` int(11) DEFAULT NULL,
  `chauffeursex` char(1) DEFAULT NULL,
  `chauffeurphone` varchar(11) DEFAULT NULL,
  `chauffeurcard` varchar(18) DEFAULT NULL,
  `chauffeuraddress` varchar(255) DEFAULT NULL,
  `chauffeurSeniority` int(11) DEFAULT NULL,
  `chauffeurstate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chauffeur` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `coid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `oserial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`coid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `tcid` int(11) NOT NULL AUTO_INCREMENT,
  `trid` int(11) DEFAULT NULL,
  `chanuffeurid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

/*Table structure for table `freight` */

DROP TABLE IF EXISTS `freight`;

CREATE TABLE `freight` (
  `tlid` int(11) NOT NULL AUTO_INCREMENT,
  `trid` int(11) DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tlid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `freight` */

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `groupid` int(11) DEFAULT NULL,
  `groundname` varchar(50) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group` */

/*Table structure for table `line` */

DROP TABLE IF EXISTS `line`;

CREATE TABLE `line` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `line` int(11) DEFAULT NULL,
  `linename` varchar(100) DEFAULT NULL,
  `linepath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `line` */

/*Table structure for table `menuinfo` */

DROP TABLE IF EXISTS `menuinfo`;

CREATE TABLE `menuinfo` (
  `menuid` varchar(100) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `menustate` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `Previd` varchar(100) DEFAULT NULL,
  `iconCls` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menuinfo` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(11) primary key  auto_increment,
  `picid` int(11) DEFAULT NULL,
  `seid` int(11) DEFAULT NULL,
  `Weight` decimal(10,2) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `Amountstate` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL，
  wayid int default null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `pickup` */

DROP TABLE IF EXISTS `pickup`;

CREATE TABLE `pickup` (
  `picid` int(11) NOT NULL AUTO_INCREMENT,
  `seid` int(11) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `stoptime` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`picid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pickup` */

/*Table structure for table `recipients` */

DROP TABLE IF EXISTS `recipients`;

CREATE TABLE `recipients` (
  `reid` int(11) DEFAULT NULL,
  `reName` varchar(255) DEFAULT NULL,
  `rephone` varchar(255) DEFAULT NULL,
  `readdress` varchar(255) DEFAULT NULL,
  `redetailedAddress` varchar(255) DEFAULT NULL,
  `relandline` varchar(255) DEFAULT NULL,
  `reweight` int(11) DEFAULT NULL,
  `retype` varchar(255) DEFAULT NULL,
  `repredictTime` varchar(255) DEFAULT NULL,
  `repredictprice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recipients` */

/*Table structure for table `roleinfo` */

DROP TABLE IF EXISTS `roleinfo`;

CREATE TABLE `roleinfo` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) DEFAULT NULL,
  `rolestate` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roleinfo` */

/*Table structure for table `rolemenu` */

DROP TABLE IF EXISTS `rolemenu`;

CREATE TABLE `rolemenu` (
  `rolemenu` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `menuid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rolemenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rolemenu` */

/*Table structure for table `sender` */

DROP TABLE IF EXISTS `sender`;

CREATE TABLE `sender` (
  `seid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) DEFAULT NULL,
  `saddress` varchar(255) DEFAULT NULL,
  `slandline` varchar(255) DEFAULT NULL,
  `sphone` varchar(255) DEFAULT NULL,
  `sdetailedAddress` varchar(255) DEFAULT NULL,
  `spayment` varchar(255) DEFAULT NULL,
  `sEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sender` */

/*Table structure for table `totalwatehouse` */

DROP TABLE IF EXISTS `totalwatehouse`;

CREATE TABLE `totalwatehouse` (
  `twid` int(11) NOT NULL AUTO_INCREMENT,
  `twname` varchar(20) DEFAULT NULL,
  `twtime` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`twid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `totalwatehouse` */

insert  into `totalwatehouse`(`twid`,`twname`,`twtime`,`state`,`code`) values (1,'大灰狼','2020/12/24 18:33:00',1,'省包裹');

/*Table structure for table `trucks` */

DROP TABLE IF EXISTS `trucks`;

CREATE TABLE `trucks` (
  `trid` int(11) NOT NULL AUTO_INCREMENT,
  `VehicleChoice` int(11) DEFAULT NULL,
  `license` varchar(100) DEFAULT NULL,
  `commonCarrier` varchar(100) DEFAULT NULL,
  `vehicleModel` varchar(100) DEFAULT NULL,
  `control` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`trid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `trucks` */

insert  into `trucks`(`trid`,`VehicleChoice`,`license`,`commonCarrier`,`vehicleModel`,`control`) values (1,2,'76898','申通快递','货车','123');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `userpass` varchar(20) DEFAULT NULL,
  `uphone` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `chinaName` varchar(20) DEFAULT NULL,
  `chinald` varchar(18) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nation` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`userpass`,`uphone`,`sex`,`age`,`chinaName`,`chinald`,`address`,`nation`) values (1,'李小龙','123456','18593489410','男','40','李小龙','435019292934345675','长沙市雨花区','汉族'),(2,'李少龙','999999','13793489410','男','30','李少龙','435019292934345789','湖北省武汉市','苗族');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
